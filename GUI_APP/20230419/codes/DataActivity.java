package com.example.dsd_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataActivity extends AppCompatActivity {

    Button button_data_GetDataList;
    Button button_data_DiscardData;
    Button button_data_ChangeDataLabel;
    Button button_data_BackToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        button_data_BackToMain=findViewById(R.id.Button_data_BackToMain);
        button_data_BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_data_DiscardData=findViewById(R.id.Button_data_DiscardData);
        button_data_DiscardData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DataActivity.this,DiscardDataActivity.class);
                startActivity(intent);
            }
        });
        button_data_ChangeDataLabel=findViewById(R.id.Button_data_ChangeDataLabel);
        button_data_ChangeDataLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DataActivity.this,ChangeDataLabelActivity.class);
                startActivity(intent);
            }
        });
        button_data_GetDataList=findViewById(R.id.Button_data_GetDataList);
        button_data_GetDataList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DataActivity.this,GetDataListActivity.class);
                startActivity(intent);
            }
        });
    }
}
