package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GetEquipInfoActivity extends AppCompatActivity {

    Button button_getequipinfo_BackToEquip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getequipinfo);
        button_getequipinfo_BackToEquip=findViewById(R.id.Button_getequipinfo_BackToEquip);
        button_getequipinfo_BackToEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
