package com.keerushar.pushme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.keerushar.pushme.R;

import java.util.ArrayList;
import java.util.List;

public class leg_workout extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.leg_workout, container, false);



        view.findViewById(R.id.wallsit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=yDSMdd8hiFg&t=36s");
                startActivity(intent);
            }
        });


        view.findViewById(R.id.bridge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=yDSMdd8hiFg&t=36s");
                startActivity(intent);
            }
        });


        view.findViewById(R.id.situponchair).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=yDSMdd8hiFg&t=36s");
                startActivity(intent);
            }
        });


        view.findViewById(R.id.lunges).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=yDSMdd8hiFg&t=36s");
                startActivity(intent);
            }
        });


        view.findViewById(R.id.squats).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=yDSMdd8hiFg&t=36s");
                startActivity(intent);
            }
        });


        view.findViewById(R.id.calfraises).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=yDSMdd8hiFg&t=36s");
                startActivity(intent);
            }
        });


        view.findViewById(R.id.pilesquats).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=yDSMdd8hiFg&t=36s");
                startActivity(intent);
            }
        });
        return view;
    }

}



