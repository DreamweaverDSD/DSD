package com.example.dsd_android;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_main_UserInfo;
    Button button_main_GetUserGuide;
    Button button_main_Equipments;
    Button button_main_Data;
    Button button_main_Model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        /*
        if(actionBar!=null){
            actionBar.hide();
        }
        */
        button_main_UserInfo=findViewById(R.id.Button_main_UserInfo);
        button_main_UserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,UserInfoActivity.class);
                startActivity(intent);
            }
        });
        button_main_GetUserGuide=findViewById(R.id.Button_main_GetUserGuide);
        button_main_GetUserGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GetUserGuideActivity.class);
                startActivity(intent);
            }
        });
        button_main_Equipments=findViewById(R.id.Button_main_Equipments);
        button_main_Equipments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,EquipmentsActivity.class);
                startActivity(intent);
            }
        });
        button_main_Data=findViewById(R.id.Button_main_Data);
        button_main_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DataActivity.class);
                startActivity(intent);
            }
        });
        button_main_Model=findViewById(R.id.Button_main_Model);
        button_main_Model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ModelActivity.class);
                startActivity(intent);
            }
        });
    }
}