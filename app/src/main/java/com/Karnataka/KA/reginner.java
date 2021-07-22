package com.Karnataka.KA;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.Karnataka.R;

public class reginner extends NavigationDrawerBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reginner);

        CardView innervol=(CardView)findViewById(R.id.innervol);
        innervol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(reginner.this, volunteerRegistration.class);
                startActivity(intent);
            }

        });

        CardView innerngo=(CardView)findViewById(R.id.innerngo);
        innerngo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(reginner.this, ngoRegistration.class);
                startActivity(intent);
            }

        });

    }
}