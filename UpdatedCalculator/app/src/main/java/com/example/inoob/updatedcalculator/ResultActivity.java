package com.example.inoob.updatedcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent getMessage=getIntent();
        String message=getMessage.getStringExtra(NumberPage.EXTRA_MESSAGE);

        TextView textView=(TextView)findViewById(R.id.displayName);
        textView.setText(message);

        Intent getResult=getIntent();
        String result=getResult.getStringExtra("result_add");


        TextView textView1=(TextView)findViewById(R.id.result);
        textView1.setText(result);



    }

}
