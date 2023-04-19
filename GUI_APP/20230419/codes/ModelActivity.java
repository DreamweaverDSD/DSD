package com.example.dsd_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModelActivity extends AppCompatActivity {

    Button button_model_ShowModelInfo;
    Button button_model_ResetModel;
    Button button_model_PredUserMotion;
    Button button_model_BackToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //I don't know what it means.
        super.onCreate(savedInstanceState);
        //Bind a layout.
        setContentView(R.layout.activity_model);
        //Add click event to one button.
        button_model_ShowModelInfo=findViewById(R.id.Button_model_ShowModelInfo);
        button_model_ShowModelInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ModelActivity.this,ShowModelInfoActivity.class);
                startActivity(intent);
            }
        });
        button_model_ResetModel=findViewById(R.id.Button_model_ResetModel);
        button_model_ResetModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ModelActivity.this,ResetModelActivity.class);
                startActivity(intent);
            }
        });
        button_model_PredUserMotion=findViewById(R.id.Button_model_PredUserMotion);
        button_model_PredUserMotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ModelActivity.this,PredUserMotionActivity.class);
                startActivity(intent);
            }
        });
        button_model_BackToMain=findViewById(R.id.Button_model_BackToMain);
        button_model_BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
