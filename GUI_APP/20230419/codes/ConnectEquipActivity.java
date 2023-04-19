package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectEquipActivity extends AppCompatActivity {

    Button button_connectequip_BackToEquip;
    Button button_connectequip_Connect;
    EditText editText_connectequip_InputIP0;
    EditText editText_connectequip_InputIP1;
    EditText editText_connectequip_InputIP2;
    EditText editText_connectequip_InputIP3;
    EditText editText_connectequip_InputPort;
    TextView textView_connectequip_Error;

    int Error = 0;
    /*
    We use the integer Error to check what's wrong with the input thing.
    0: Everything is OK.
    others: Something is wrong.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectequip);
        button_connectequip_BackToEquip=findViewById(R.id.Button_connectequip_BackToEquip);
        button_connectequip_BackToEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_connectequip_Connect = findViewById(R.id.Button_connectequip_Connect);
        editText_connectequip_InputIP0 = findViewById(R.id.editText_connectequip_InputIP0);
        editText_connectequip_InputIP1 = findViewById(R.id.editText_connectequip_InputIP1);
        editText_connectequip_InputIP2 = findViewById(R.id.editText_connectequip_InputIP2);
        editText_connectequip_InputIP3 = findViewById(R.id.editText_connectequip_InputIP3);
        editText_connectequip_InputPort = findViewById(R.id.editText_connectequip_InputPort);
        textView_connectequip_Error = findViewById(R.id.Text_connectequip_Error);
        button_connectequip_Connect.setOnClickListener(new View.OnClickListener() {
            String str_IP_address0 = new String(), str_IP_address1 = new String(),
                    str_IP_address2 = new String(), str_IP_address3 = new String(),
                    str_Port = new String();
            String IP_address = new String();
            String textView_error = new String();
            Integer int_IP_address0, int_IP_address1, int_IP_address2, int_IP_address3, int_Port;
            @Override
            public void onClick(View view) {
                textView_error = "";
                Error = 0;
                button_connectequip_BackToEquip.setEnabled(false);
                button_connectequip_Connect.setEnabled(false);
                button_connectequip_Connect.setText("Connecting...");
                try {
                    str_IP_address0 = editText_connectequip_InputIP0.getText().toString();
                    int_IP_address0 = Integer.parseInt(str_IP_address0);
                    if(int_IP_address0 < 0 || int_IP_address0 > 255){
                        Exception e = new IllegalArgumentException();
                        throw e;
                    }
                }
                catch(Exception e){
                    Error = 1;
                    textView_error = textView_error + "The first IP address is illegal!\n";
                }
                try {
                    str_IP_address1 = editText_connectequip_InputIP1.getText().toString();
                    int_IP_address1 = Integer.parseInt(str_IP_address1);
                    if(int_IP_address1 < 0 || int_IP_address1 > 255){
                        Exception e = new IllegalArgumentException();
                        throw e;
                    }
                }
                catch(Exception e){
                    Error = 2;
                    textView_error = textView_error + "The second IP address is illegal!\n";

                }
                try {
                    str_IP_address2 = editText_connectequip_InputIP2.getText().toString();
                    int_IP_address2 = Integer.parseInt(str_IP_address2);
                    if(int_IP_address2 < 0 || int_IP_address2 > 255){
                        Exception e = new IllegalArgumentException();
                        throw e;
                    }
                }
                catch(Exception e){
                    Error = 3;
                    textView_error = textView_error + "The third IP address is illegal!\n";
                }
                try {
                    str_IP_address3 = editText_connectequip_InputIP3.getText().toString();
                    int_IP_address3 = Integer.parseInt(str_IP_address3);
                    if(int_IP_address3 < 0 || int_IP_address3 > 255){
                        Exception e = new IllegalArgumentException();
                        throw e;
                    }
                }
                catch(Exception e){
                    Error = 4;
                    textView_error = textView_error + "The fourth IP address is illegal!\n";
                }
                try {
                    str_Port = editText_connectequip_InputPort.getText().toString();
                    int_Port = Integer.parseInt(str_Port);
                    if(int_Port < 0 || int_Port > 65535){
                        Exception e = new IllegalArgumentException();
                        throw e;
                    }
                }
                catch(Exception e){
                    Error = 5;
                    textView_error = textView_error + "The port is illegal!\n";
                }
                if(Error != 0){
                    textView_error = textView_error + "The IP address should be in 0~255.\n";
                    textView_error = textView_error + "The port should be in 0~65535.\n";
                    textView_connectequip_Error.setText(textView_error);
                    button_connectequip_Connect.setEnabled(true);
                    button_connectequip_Connect.setText("Connect");
                }
                else{
                    IP_address = int_IP_address0.toString() + ":" + int_IP_address1.toString()
                            + ":" + int_IP_address2.toString()
                            + ":" + int_IP_address3.toString()
                            + "::" + int_Port.toString();
                    button_connectequip_Connect.setText(IP_address);
                }
                button_connectequip_BackToEquip.setEnabled(true);
            }
        });
    }
}
