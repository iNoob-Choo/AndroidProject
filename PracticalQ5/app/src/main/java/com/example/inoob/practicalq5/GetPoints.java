package com.example.inoob.practicalq5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class GetPoints extends Fragment {


    private TextInputEditText x1,x2,y1,y2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {





        return inflater.inflate(R.layout.fragment_get_points,container,false);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        x1=(TextInputEditText)getView().findViewById(R.id.x1);
        x2=(TextInputEditText)getView().findViewById(R.id.x2);
        y1=(TextInputEditText)getView().findViewById(R.id.y1);
        y2=(TextInputEditText)getView().findViewById(R.id.y2);


        Point p1=new Point(Double.parseDouble(x1.getText().toString()),Double.parseDouble(y1.getText().toString()));
        Point p2=new Point(Double.parseDouble(x2.getText().toString()),Double.parseDouble(y2.getText().toString()));

        Bundle bundle=new Bundle();
        bundle.putSerializable("point1",p1);
        bundle.putSerializable("point2",p2);

        ShowMidPoint f=new ShowMidPoint();

        f.setArguments(bundle);


    }



}
