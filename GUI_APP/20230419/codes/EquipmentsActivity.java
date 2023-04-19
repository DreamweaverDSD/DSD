package com.example.dsd_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EquipmentsActivity extends AppCompatActivity {

    Button button_equipments_ConnectEquip;
    Button button_equipments_GetEquipInfo;
    Button button_equipments_GetEquipStatus;
    Button button_equipments_CollectData;
    Button button_equipments_UnbindEquip;
    Button button_equipments_BackToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //I don't know what it means.
        super.onCreate(savedInstanceState);
        //Bind a layout.
        setContentView(R.layout.activity_equipments);
        //Add click event to one button.
        button_equipments_ConnectEquip=findViewById(R.id.Button_equipments_ConnectEquip);
        button_equipments_ConnectEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EquipmentsActivity.this,ConnectEquipActivity.class);
                startActivity(intent);
            }
        });

        button_equipments_GetEquipInfo=findViewById(R.id.Button_equipments_GetEquipInfo);
        button_equipments_GetEquipInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EquipmentsActivity.this,GetEquipInfoActivity.class);
                startActivity(intent);
            }
        });
        button_equipments_GetEquipStatus=findViewById(R.id.Button_equipments_GetEquipStatus);
        button_equipments_GetEquipStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EquipmentsActivity.this,GetEquipStatusActivity.class);
                startActivity(intent);
            }
        });
        button_equipments_CollectData=findViewById(R.id.Button_equipments_CollectData);
        button_equipments_CollectData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EquipmentsActivity.this,CollectDataActivity.class);
                startActivity(intent);
            }
        });
        button_equipments_UnbindEquip=findViewById(R.id.Button_equipments_UnbindEquip);
        button_equipments_UnbindEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EquipmentsActivity.this,UnbindEquipActivity.class);
                startActivity(intent);
            }
        });
        button_equipments_BackToMain=findViewById(R.id.Button_model_BackToMain);
        button_equipments_BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
