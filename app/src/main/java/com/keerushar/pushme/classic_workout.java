package com.keerushar.pushme;

import android.content.Intent;
import android.media.Image;
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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.keerushar.pushme.R;

import java.util.ArrayList;
import java.util.List;

public class classic_workout extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classic_frag, container, false);

      view.findViewById(R.id.jmpjk).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(getActivity(),webview_you.class);
              intent.putExtra("url","https://www.youtube.com/watch?v=yDSMdd8hiFg&t=36s");
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
        view.findViewById(R.id.plank).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=DHvSGdCIZyQ");
                startActivity(intent);
            }
        });
        view.findViewById(R.id.lunge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=QF0BQS2W80k");
                startActivity(intent);
            }
        });
        view.findViewById(R.id.squat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=xqvCmoLULNY");
                startActivity(intent);
            }
        });
        view.findViewById(R.id.tricep).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=6kALZikXxLc");
                startActivity(intent);
            }
        });
        view.findViewById(R.id.sit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),webview_you.class);
                intent.putExtra("url","https://www.youtube.com/watch?v=1fbU_MkV7NE");
                startActivity(intent);
            }
        });




        return view;
    }


}
