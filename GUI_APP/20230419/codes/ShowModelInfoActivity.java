package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ShowModelInfoActivity extends AppCompatActivity {

    Button button_showmodelinfo_BackToModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmodelinfo);
        button_showmodelinfo_BackToModel=findViewById(R.id.Button_showmodelinfo_BackToModel);
        button_showmodelinfo_BackToModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
