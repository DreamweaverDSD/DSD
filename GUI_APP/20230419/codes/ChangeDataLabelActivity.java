package com.example.dsd_android;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChangeDataLabelActivity extends AppCompatActivity {

    Button button_changedatalabel_BackToData;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changedatalabel);
        button_changedatalabel_BackToData=findViewById(R.id.Button_changedatalabel_BackToData);
        tableLayout = findViewById(R.id.TableLayout_changedatalabel_list);
        button_changedatalabel_BackToData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        GetFromServer getFromServer = new GetFromServer();
        ArrayList<DataMotion> dataList = getFromServer.getdatalist();


        for(int i = 0; i < dataList.size(); i++){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String date = sdf.format(new Date(Long.parseLong(String.valueOf(dataList.get(i).starttime))));
            String type = dataList.get(i).checktype();

            //Add textview.
            TextView textView = new TextView(this);
            textView.setText(" number:" + i + "\tType:" + type + "\n Date:" + date);
            textView.setTextSize(20);
            textView.setTextColor(Color.rgb(0,0, 0));
            textView.setGravity(Gravity.LEFT);
            textView.setHeight((int) textView.getTextSize() * 3);
            Typeface typeFace =Typeface.createFromAsset(getAssets(),"fonts/LCD-BQ.TTF");
            textView.setTypeface(typeFace);

            //Create the delete button for each datalist, and set its text, color and the color of
            // text.
            Button button = new Button(this);
            button.setText("Change");
            button.setTextColor(Color.rgb(255,255,255));
            button.setBackgroundColor(Color.rgb(119,136,153));
            button.setHeight(textView.getHeight());

            //Create the delete submit dialog, and add dialog to the button
            int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogFragment newFragment = new ChangeDataLabel_SubmitDialogFragment(finalI);
                    newFragment.show(getSupportFragmentManager(), "Dialog_discarddata_" + finalI);
                }
            });

            //Add all of them to tableRow.
            TableRow tableRow = new TableRow(this);

            tableRow.setDividerDrawable(Drawable.createFromPath("@drawable/table_h_divider"));
            tableRow.setOrientation(TableLayout.HORIZONTAL);
            tableRow.setShowDividers(LinearLayout.SHOW_DIVIDER_BEGINNING);

            tableRow.addView(textView);
            tableRow.addView(button);
            tableLayout.addView(tableRow, tableLayout.getLayoutParams());

        }
    }
}
