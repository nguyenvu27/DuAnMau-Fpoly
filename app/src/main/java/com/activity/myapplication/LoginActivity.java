package com.activity.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText user_name, user_pass ;
    private TextView login ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login() ;

    }

    private void Login() {
        user_name = findViewById(R.id.ed_userName) ;
        user_pass = findViewById(R.id.ed_userPass) ;
        login = findViewById(R.id.tv_login) ;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(user_name.getText().toString().equals("admin") && user_pass.getText().toString().equals("admin")) {
                     Intent intent = new Intent(LoginActivity.this, MenuActivity.class) ;
                     startActivity(intent);
                     Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else {
                     Toast.makeText(LoginActivity.this, "Sai thông tin tài khoản, mật khẩu", Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }
}
