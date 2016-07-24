package com.example.inoob.practicalq5;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MidPoint extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_point);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Point p1,p2,mid;

        Bundle receive=getIntent().getExtras();
        p1= (Point) receive.getSerializable("point");
        p2=(Point)receive.getSerializable("points");

        Line line=new Line(p1,p2);

        mid=line.getMidPoint();

        TextView midx=new TextView(this);
        midx.setTextSize(40);
        midx.setText(Double.toString(mid.getX()));

        TextView midy=new TextView(this);
        midy.setTextSize(40);
        midy.setText(Double.toString(mid.getY()));

        LinearLayout layout=(LinearLayout) findViewById(R.id.resultpage);
        layout.addView(midx);
        layout.addView(midy);








    }

}
