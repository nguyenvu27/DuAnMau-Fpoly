package com.activity.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class TheloaiActivity extends AppCompatActivity {
    Spinner spinner;
    Button btnThem, btnList, btn_xoa;
    EditText ed_id, ed_stt, ed_maSach, ed_tenSach, ed_soTien;

    ImageView mImageView;
    final int REQUEST_CODE_GALLERY = 999;
    public static SQLiteHelper mSqliteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai);


        btnThem = findViewById(R.id.btnAdd);
        btnList = findViewById(R.id.btnList) ;

        ActionBar actionBar = getSupportActionBar() ;


        mImageView = findViewById(R.id.imageView);
        ed_stt = findViewById(R.id.edtStt);
        ed_maSach = findViewById(R.id.edtMasach);
        ed_tenSach = findViewById(R.id.edtTensach);
        ed_soTien = findViewById(R.id.edtSotien);


        mSqliteHelper = new SQLiteHelper(this);

        mSqliteHelper.queryData("CREATE TABLE IF NOT EXISTS RECORD(id INTEGER PRIMARY KEY AUTOINCREMENT, stt VARCHAR, masach VARCHAR, tensach VARCHAR, sotien VARCHAR, image BLOB)");

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityCompat.requestPermissions(TheloaiActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY);

            }
        });


        spinner = findViewById(R.id.spn);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Thể loại");
        arrayList.add("Khoa học");
        arrayList.add("Thiếu nhi");
        arrayList.add("Truyện ngắn");
        arrayList.add("Truyện tranh");
        arrayList.add("Văn học");
        arrayList.add("Sách tham khảo");
        arrayList.add("Sách thiếu nhi");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList);
        spinner.setAdapter(arrayAdapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    String stt = ed_stt.getText().toString();
                    String masach = ed_maSach.getText().toString();
                    String tensach = ed_tenSach.getText().toString();
                    String sotien = ed_soTien.getText().toString();

                    if (stt.isEmpty() && masach.isEmpty() && tensach.isEmpty() && sotien.isEmpty()){
                        Toast.makeText(TheloaiActivity.this, "Bạn cần điền đầy đủ thông tin, và ảnh", Toast.LENGTH_SHORT).show();
                    }else {

                        mSqliteHelper.insertData(
                                ed_stt.getText().toString().trim(),
                                ed_maSach.getText().toString().trim(),
                                ed_tenSach.getText().toString().trim(),
                                ed_soTien.getText().toString().trim(),
                                imageViewToByte(mImageView)
                        );

                        Toast.makeText(TheloaiActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

                        ed_stt.setText("");
                        ed_maSach.setText("");
                        ed_tenSach.setText("");
                        ed_soTien.setText("");
                        mImageView.setImageResource(R.drawable.ic_add_a_photo_black_24dp);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TheloaiActivity.this, RecordListActivity.class));
            }
        });
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
        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(this, "Don't have permission to access file location  ", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            CropImage.activity(imageUri).setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1, 1)
                    .start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                mImageView.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}