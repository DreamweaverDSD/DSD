package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UnbindEquipActivity extends AppCompatActivity {

    Button button_unbindequip_BackToEquip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unbindequip);
        button_unbindequip_BackToEquip=findViewById(R.id.Button_unbindequip_BackToEquip);
        button_unbindequip_BackToEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
