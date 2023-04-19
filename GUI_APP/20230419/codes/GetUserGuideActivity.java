package com.example.dsd_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GetUserGuideActivity extends AppCompatActivity {

    Button button_getuserguide_BackToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getuserguide);
        button_getuserguide_BackToMain=findViewById(R.id.Button_getuserguide_BackToMain);
        button_getuserguide_BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
