package com.activity.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class RecordListActivity extends AppCompatActivity {

    ListView mListView ;
    ArrayList<Model> mList ;
    RecordListAdapter mAdapter = null ;
    ImageView imageViewIcoi ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);

        ActionBar actionBar = getSupportActionBar() ;


        mListView = findViewById(R.id.ListView) ;
        mList = new ArrayList<>() ;
        mAdapter = new RecordListAdapter(this, R.layout.row, mList) ;
        mListView.setAdapter(mAdapter);

        Cursor cursor = TheloaiActivity.mSqliteHelper.getData("SELECT * FROM RECORD") ;
        mList.clear();

        while (cursor.moveToNext()){
            int id  = cursor.getInt(0) ;
            String stt = cursor.getString(1) ;
            String masach = cursor.getString(2) ;
            String tensach = cursor.getString(3) ;
            String sotien = cursor.getString(4) ;
            byte[] image = cursor.getBlob(5) ;

            mList.add(new Model(id, stt, masach, tensach, sotien, image)) ;
        }
        mAdapter.notifyDataSetChanged();
        if (mList.size()==0){
            Toast.makeText(this, "không tìm thấy bản ghi", Toast.LENGTH_SHORT).show();
        }
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {

                final CharSequence[] items = {"Sửa", "Xóa"} ;
                AlertDialog.Builder dialog = new AlertDialog.Builder(RecordListActivity.this);

                dialog.setTitle("Hãy chọn ") ;
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 0){
                            //update
                            Cursor c = TheloaiActivity.mSqliteHelper.getData("SELECT id FROM RECORD") ;
                            ArrayList<Integer> arrID = new ArrayList<Integer>() ;
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0)) ;
                            }
                            showDialogUpdate(RecordListActivity.this, arrID.get(position));
                        }
                        if (i==1){
                            //delete
                            Cursor c = TheloaiActivity.mSqliteHelper.getData("SELECT id FROM RECORD") ;
                            ArrayList<Integer> arrID = new ArrayList<Integer>() ;
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0)) ;
                        }
                        showDialogDelete(arrID.get(position)) ;
                    }
                    }
                });
                dialog.show() ;

                return true;
            }
        });
    }

    private void showDialogDelete(final int idRecord) {

        AlertDialog.Builder dialogDelete = new AlertDialog.Builder(RecordListActivity.this) ;
        dialogDelete.setTitle("Cảnh báo!!") ;
        dialogDelete.setMessage("Bạn có chắc chắn muốn xóa?") ;
        dialogDelete.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    TheloaiActivity.mSqliteHelper.deleteData(idRecord);
                    Toast.makeText(RecordListActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Log.e("Lỗi", e.getMessage()) ;
                }
                updateRecordList();
            }
        });

        dialogDelete.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialogDelete.show() ;
    }

    private void  showDialogUpdate(Activity activity, final int position){
        final Dialog dialog = new Dialog(activity) ;
        dialog.setContentView(R.layout.update_dialog);
        dialog.setTitle("Sửa");

       imageViewIcoi = dialog.findViewById(R.id.imageViewRecord) ;
        final EditText edtStt = dialog.findViewById(R.id.edtStt) ;
        final EditText edtMasach = dialog.findViewById(R.id.edtMasach) ;
        final EditText edtTensach = dialog.findViewById(R.id.edtTensach) ;
        final EditText edtSotien = dialog.findViewById(R.id.edtSotien) ;
        Button btnUpdate = dialog.findViewById(R.id.btnUpdate) ;

        int width = (int)(activity.getResources().getDisplayMetrics().widthPixels*0.95) ;
        int height = (int)(activity.getResources().getDisplayMetrics().heightPixels*0.7) ;
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        imageViewIcoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(RecordListActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    TheloaiActivity.mSqliteHelper.updateDate(edtStt.getText().toString().trim(),
                            edtMasach.getText().toString().trim(),
                            edtTensach.getText().toString().trim(),
                            edtSotien.getText().toString().trim(), TheloaiActivity.imageViewToByte(imageViewIcoi) , position );

               dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();
                }
        catch (Exception error){
            Log.e("Sửa thất bại", error.getMessage()) ;
        }
        updateRecordList() ;
            }
        });

    }

    private void updateRecordList() {
        Cursor cursor = TheloaiActivity.mSqliteHelper.getData("SELECT * FROM RECORD ") ;
        mList.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0) ;
            String stt = cursor.getString(1) ;
            String masach = cursor.getString(2) ;
            String tensach = cursor.getString(3) ;
            String sotien = cursor.getString(4) ;
            byte[] image = cursor.getBlob(5) ;

            mList.add(new Model(id, stt, masach, tensach, sotien, image)) ;
        }
        mAdapter.notifyDataSetChanged();
    }


    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 888) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, 888);
            } else {
                Toast.makeText(this, "Không được phép truy cập vị trí tệp  ", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 888 && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            CropImage.activity(imageUri).setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1, 1)
                    .start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                imageViewIcoi.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
