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

public class abs_workout extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.abs_workout, container, false);

        view.findViewById(R.id.crunch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=Xyd_fa5zoEU");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.plank).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=TvxNkmjdhMM");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.oneleg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=kvV6Mfchga4");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.russiantwist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=kvV6Mfchga4");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.burpees).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=ZiDrFSdI3yg");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.sit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=1fbU_MkV7NE&t=18s");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.reverse).setOnClickListener(new View.OnClickListener() {
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



