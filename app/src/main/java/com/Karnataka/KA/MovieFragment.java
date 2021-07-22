package com.Karnataka.KA;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.Karnataka.R;

public class MovieFragment extends Fragment {


    public MovieFragment() {
        // Required empty public constructor
    }
    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getActivity();

        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    public void onStart() {
        super.onStart();

        CardView edmess=(CardView)context.findViewById(R.id.edmess);
        edmess.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(context, edmes.class);
                startActivity(intent);
            }

        });
        CardView cardvot=(CardView)context.findViewById(R.id.cardvot);
        cardvot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(context, trainingrepo.class);
                startActivity(intent);
            }

        });

        CardView server=(CardView)context.findViewById(R.id.server);
        server.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(context, vot.class);
                startActivity(intent);
            }

        });
    }

    }
