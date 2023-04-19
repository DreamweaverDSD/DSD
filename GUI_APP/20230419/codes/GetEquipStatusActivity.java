package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GetEquipStatusActivity extends AppCompatActivity {

    Button button_getequipstatus_BackToEquip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getequipstatus);
        button_getequipstatus_BackToEquip=findViewById(R.id.Button_getequipstatus_BackToEquip);
        button_getequipstatus_BackToEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
