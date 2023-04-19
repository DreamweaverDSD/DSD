package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ResetModelActivity extends AppCompatActivity {

    Button button_resetmodel_BackToModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetmodel);
        button_resetmodel_BackToModel=findViewById(R.id.Button_resetmodel_BackToModel);
        button_resetmodel_BackToModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
