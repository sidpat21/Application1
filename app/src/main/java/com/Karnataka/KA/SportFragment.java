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
import android.widget.ImageView;
import android.widget.Toast;

import com.Karnataka.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class SportFragment extends Fragment {


    public SportFragment() {
        // Required empty public constructor
    }
    Activity context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getActivity();

        return inflater.inflate(R.layout.fragment_sport, container, false);
    }

    public void onStart(){
        super.onStart();
        CardView button3=context.findViewById(R.id.button3);
        CardView button2=context.findViewById(R.id.button2);
        CardView od=context.findViewById(R.id.od);
        CardView button8=context.findViewById(R.id.button8);
        CardView qw=context.findViewById(R.id.qw);
        CardView volunterRegistration=context.findViewById(R.id.volunter);
        CardView volunterTask=context.findViewById(R.id.voluntertask);

        final int[] mImages=new int[]{
                R.drawable.ca1, R.drawable.ca2, R.drawable.ca3, R.drawable.ca4
        };

        CarouselView carouselView=context.findViewById(R.id.carousel);


        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        });
        carouselView.setPageCount(mImages.length);

        volunterRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,reginner.class);
                startActivity(i);
            }
        });


        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, qw.class);
                startActivity(intent);
            }

        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, epass.class);
                startActivity(intent);
            }

        });
        od.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, DonateActivityDrawer.class);
                startActivity(intent);
            }

        });
        button8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, unor.class);
                startActivity(intent);
            }

        });
        qw.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, q.class);
                startActivity(intent);
            }

        });
        volunterTask.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, volunteerTask.class);
                startActivity(intent);
            }

        });

    }

}