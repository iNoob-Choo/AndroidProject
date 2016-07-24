package com.example.inoob.practicalq5;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;



public class GetCoordinate extends AppCompatActivity {


    private EditText x1,x2,y1,y2;
    private double X1,X2,Y1,Y2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_coordinate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_place,InputFragment.newInstance()).commit();






        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x1=(EditText)findViewById(R.id.x1);
                x2=(EditText)findViewById(R.id.x2);
                y1=(EditText)findViewById(R.id.y1);
                y2=(EditText)findViewById(R.id.y2);

                X1=Double.parseDouble(x1.getText().toString());
                X2=Double.parseDouble(x2.getText().toString());
                Y1=Double.parseDouble(y1.getText().toString());
                Y2=Double.parseDouble(y2.getText().toString());

                Point p1=new Point(X1,Y1);
                Point p2=new Point(X2,Y2);

                Line l1=new Line(p1,p2);

                Point mid=l1.getMidPoint();

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_place,DisplayFragment.newInstance(mid,new DisplayFragment.OnDetachListener(){
                            @Override
                            public void onDetach(){
                                fab.setEnabled(true);
                            }

                        })).addToBackStack(null).commit();
                fab.setEnabled(false);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_coordinate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
