package com.example.inoob.practicalq5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class DisplayFragment extends Fragment {


    public DisplayFragment() {
        // Required empty public constructor
    }

    public interface OnDetachListener {
        void onDetach();
    }


    private Point mid;
    private EditText midx,midy;
    private OnDetachListener onDetachListener;

    private static final String EXTRA_VALUE="URL.COM";



    // TODO: Rename and change types and number of parameters
    public static DisplayFragment newInstance(Point mid,OnDetachListener onDetachListener) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_VALUE,mid);
        fragment.setArguments(args);
        fragment.onDetachListener=onDetachListener;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mid=(Point)getArguments().getSerializable(EXTRA_VALUE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_display,container,false);
        midx=(EditText)view.findViewById(R.id.tbx_mid_x);
        midy=(EditText)view.findViewById(R.id.tbx_mid_y);

        if(mid!=null){
            midx.setText(String.valueOf(mid.getX()));
            midy.setText(String.valueOf(mid.getY()));
        }
        return view;


    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDetachListener.onDetach();
    }


}
