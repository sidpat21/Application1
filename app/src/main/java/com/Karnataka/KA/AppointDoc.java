package com.Karnataka.KA;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.Karnataka.R;


public class AppointDoc extends NavigationDrawerBaseActivity {
    private static final int REQUEST_CALL = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor);
        appBarTxt.setText("Appoint a Doctor");

        Button na=findViewById(R.id.button5);
        //Button ai=findViewById(R.id.button4);


        na.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppointDoc.this, ho1.class);
                startActivity(intent);
            }
        });

//        ai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                makePhoneCall();
//            }
//        });
    }

    public void makePhoneCall() {
        String number = "0771-2572240";


        if (ContextCompat.checkSelfPermission(AppointDoc.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(AppointDoc.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            String dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number)));
        }
    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_CALL) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                makePhoneCall();
//            } else {
//                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
