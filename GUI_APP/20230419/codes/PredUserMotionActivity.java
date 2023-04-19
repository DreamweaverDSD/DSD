package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PredUserMotionActivity extends AppCompatActivity {

    Button button_predusermotion_BackToModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predusermotion);
        button_predusermotion_BackToModel=findViewById(R.id.Button_predusermotion_BackToModel);
        button_predusermotion_BackToModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
