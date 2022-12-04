package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed3,ed4,ed5;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btn3 = findViewById(R.id.btn3);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        findViewById(R.id.ret2).setOnClickListener(this);
        preferences = getSharedPreferences("config", Context.MODE_PRIVATE);//保存注册账号
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(RegisterActivity.this, EmptyActivity.class);
                String name1 = ed3.getText().toString();
                String password1 = ed4.getText().toString();
                String password2 = ed5.getText().toString();
                if (TextUtils.isEmpty(name1)) {
                    Toast.makeText(RegisterActivity.this, "学号不能为空！", Toast.LENGTH_SHORT).show();
                }
              else  if (TextUtils.isEmpty(password1)) {
                    Toast.makeText(RegisterActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                }
               else if (!TextUtils.equals(password1, password2)) {
                    Toast.makeText(RegisterActivity.this, "前后密码不一致！", Toast.LENGTH_SHORT).show();
                }

              else {
                    Toast.makeText(RegisterActivity.this, "注册成功！请前往登录", Toast.LENGTH_SHORT).show();
                    //保存注册账号
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("name1",name1);
                    editor.putString("password",password1);
                    editor.putString("password2",password2);
                    editor.commit();
                }
            }
        });


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.ret2){
            finish();
        }

    }
}