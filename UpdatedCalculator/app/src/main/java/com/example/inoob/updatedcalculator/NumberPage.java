package com.example.inoob.updatedcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class NumberPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText firstnum,secondnum;
        Button addButton,subButton;
        firstnum=(EditText)findViewById(R.id.num_1);
        secondnum=(EditText)findViewById(R.id.num_2);



        addButton=(Button)findViewById(R.id.btnAdd);
        subButton=(Button)findViewById(R.id.btnsub);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result;
                double sum,num1,num2;
                num1=Double.parseDouble(firstnum.getText().toString());
                num2=Double.parseDouble(secondnum.getText().toString());



                sum=num1+num2;
                result=Double.toString(sum);

                Intent sendResults=new Intent(getApplicationContext(),ResultActivity.class);
                sendResults.putExtra("result_add",result);
                startActivity(sendResults);

            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result;
                double sum,num1,num2;
                num1=Double.parseDouble(firstnum.getText().toString());
                num2=Double.parseDouble(secondnum.getText().toString());



                sum=num1-num2;
                result=Double.toString(sum);

                Intent sendResults=new Intent(getApplicationContext(),ResultActivity.class);
                sendResults.putExtra("result_add",result);
                startActivity(sendResults);
            }
        });



    }

    public final static String EXTRA_MESSAGE= "com.example.inoob.updatedcalculator.MESSAGE";

    public void sendMessage(View view){
        Intent sendMessage= new Intent(getApplicationContext(),ResultActivity.class);
        EditText editText=(EditText)findViewById(R.id.getName);
        String name=editText.getText().toString();
        sendMessage.putExtra(EXTRA_MESSAGE,name);
        startActivity(sendMessage);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.action_settings){
            return true;
        }
        String text="";
        switch (id) {

            case R.id.action_add:
                text="Adding";
                break;
            case R.id.action_sub:
                text="Minus";
                break;
            case R.id.action_divide:
                text="Divide";
                break;
            case R.id.action_multi:
                text="Multiply";
                break;
            default:
                return super.onOptionsItemSelected(item);



        }
        return super.onOptionsItemSelected(item);






    }



    }



