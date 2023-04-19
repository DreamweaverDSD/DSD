package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CollectDataActivity extends AppCompatActivity {

    Button button_collectdata_BackToEquip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectdata);
        button_collectdata_BackToEquip=findViewById(R.id.Button_collectdata_BackToEquip);
        button_collectdata_BackToEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
