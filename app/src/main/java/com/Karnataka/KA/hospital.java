package com.Karnataka.KA;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Karnataka.R;

public class hospital extends NavigationDrawerBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_activity);
        appBarTxt.setText("Find an hospital");


        Button map1=findViewById(R.id.map4);
        Button map2=findViewById(R.id.map3);
        Button map3=findViewById(R.id.map5);
        Button map4=findViewById(R.id.map6);
        Button map5=findViewById(R.id.map7);
        Button map6=findViewById(R.id.map8);
        Button map7=findViewById(R.id.map9);
        Button map8=findViewById(R.id.map10);
        Button map9=findViewById(R.id.map11);
        Button map10=findViewById(R.id.map12);

        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this, th1.class);
                startActivity(intent);
            }
        });
        map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this, th2.class);
                startActivity(intent);
            }
        });
        map3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this, th3.class);
                startActivity(intent);
            }
        });
        map4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this, th4.class);
                startActivity(intent);
            }
        });
        map5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this, th5.class);
                startActivity(intent);
            }
        });
        map6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this, th6.class);
                startActivity(intent);
            }
        });
        map7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this, th7.class);
                startActivity(intent);
            }
        });
        map8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this, th8.class);
                startActivity(intent);
            }
        });
        map9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this, th9.class);
                startActivity(intent);
            }
        });

        map10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hospital.this, th10.class);
                startActivity(intent);
            }
        });

    }
}
