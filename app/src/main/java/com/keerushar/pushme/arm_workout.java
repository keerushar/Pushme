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

public class arm_workout extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.arm_work, container, false);

        view.findViewById(R.id.armrises).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=ww0r9xZunD");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.pushup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=_l3ySVKYVJ8");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.tricep).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=yDSMdd8hiFg&t=36s");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.punch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=6kALZikXxLc");
                startActivity(intent);
            }
        });


        view.findViewById(R.id.shoulder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=t158UsaSrX4");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.diamond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=J0DnG1_S92I&t=22s");
                startActivity(intent);
            }
        });


        view.findViewById(R.id.oneleg).setOnClickListener(new View.OnClickListener() {
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



