package com.example.myapplication;

import static com.example.myapplication.R.id.btn4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Button btn2 =findViewById(R.id.btn2);
        Button btn4 =findViewById(R.id.btn4);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        findViewById(R.id.ret).setOnClickListener( this);
        //登录反馈
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setClass(ButtonActivity.this,EmptyActivity.class);
                String name=ed1.getText().toString();
                String password=ed2.getText().toString();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(ButtonActivity.this,"学号不能为空！",Toast.LENGTH_SHORT).show();
                }
               else if(TextUtils.isEmpty(password)){
                    Toast.makeText(ButtonActivity.this,"密码不能为空！",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ButtonActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(ButtonActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

//返回按钮
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.ret){
            finish();
        }
    }
}