package com.example.dsd_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetDataListActivity extends AppCompatActivity {

    Button button_getdatalist_BackToData;
    TableLayout tableLayout;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdatalist);
        button_getdatalist_BackToData=findViewById(R.id.Button_getdatalist_BackToData);
        tableLayout = findViewById(R.id.TableLayout_getdatalist_List);
        GetFromServer getFromServer = new GetFromServer();

        button_getdatalist_BackToData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<DataMotion> dataList = getFromServer.getdatalist();

        for(int i = 0; i < dataList.size(); i++){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String date = sdf.format(new Date(Long.parseLong(String.valueOf(dataList.get(i).starttime))));
            String type = dataList.get(i).checktype();

            TextView textView = new TextView(this);
            textView.setText("number:" + i + "\tType:" + type + "\nDate:" + date);
            textView.setTextSize(20);
            textView.setTextColor(Color.rgb(0,0, 0));
            textView.setGravity(Gravity.LEFT);
            textView.setHeight((int) textView.getTextSize() * 3);
            Typeface typeFace =Typeface.createFromAsset(getAssets(),"fonts/LCD-BQ.ttf");
            textView.setTypeface(typeFace);

            TableRow tableRow = new TableRow(this);

            tableRow.setDividerDrawable(Drawable.createFromPath("@drawable/table_h_divider"));
            tableRow.setOrientation(TableLayout.HORIZONTAL);
            tableRow.setShowDividers(LinearLayout.SHOW_DIVIDER_BEGINNING);

            tableRow.addView(textView);
            tableLayout.addView(tableRow, tableLayout.getLayoutParams());

        }

    }
}
