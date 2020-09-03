package com.example.assigment71;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class credits extends AppCompatActivity {
    //variable delecration
    TextView tv;
    Intent gi;
    float lastSummery;
    boolean summeryFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        tv = (TextView)findViewById(R.id.tv);

        //get the Indent and the data
        gi = getIntent();
        lastSummery = gi.getFloatExtra("lastSummery",0);
        summeryFlag = gi.getBooleanExtra("summeryFlag",false);

        if (summeryFlag)
        {
            if((((float)((int)lastSummery)) == (float)lastSummery))
            {
                tv.setText(String.valueOf((int)lastSummery));
            }
            else
            {
                tv.setText(String.valueOf(lastSummery));
            }
        }
        else
        {
            tv.setText("There is no summery yet");
        }
    }

    public void backToMain(View view) {
       finish();
    }
}