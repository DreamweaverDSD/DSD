package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    Button button_login_commit;
    Button button_login_register;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //to find the dir of the file which is used to store user id
        GetFromServer.dir = new File(this.getExternalFilesDir(null).getPath() + "username.txt");
        //to solve the problem that main thread can't use http
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button_login_commit = findViewById(R.id.Button_login_Commit);
        button_login_register = findViewById(R.id.Button_login_Register);
        textView = findViewById(R.id.Text_login_Error);

        ArrayList<EditText> editTextArrayList = new ArrayList<EditText>();
        for(int i = 0; i < 2; i++){
            EditText editText = new EditText(this);
            editTextArrayList.add(editText);
        }
        editTextArrayList.set(0, findViewById(R.id.EditText_login_UserName));
        editTextArrayList.set(1, findViewById(R.id.EditText_login_Password));
        GetFromServer getFromServer = new GetFromServer();

        button_login_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = new String(String.valueOf(editTextArrayList.get(0).getText()));
                String password = new String(String.valueOf(editTextArrayList.get(1).getText()));
                int result_value = getFromServer.login(username, password);
                if(result_value != 0){
                    textView.setText("Login information is not correct. Please check it.");
                }
                else{
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });


        button_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
