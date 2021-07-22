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

public class call extends NavigationDrawerBaseActivity {
    Button call1,call2,call3,email,wapp;
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);
        appBarTxt.setText("Contact the helpline");

        email=findViewById(R.id.email);
        call1 = findViewById(R.id.call1);
        call2 = findViewById(R.id.call2);
        call3 = findViewById(R.id.call3);
        wapp = findViewById(R.id.wapp);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall1();
            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall2();

            }
        });

        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall3();
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

        wapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wapp();
            }
        });
    }

    private void wapp(){

        PackageManager pm=getPackageManager();
        try {


            String toNumber = "919013151515";
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:"+ toNumber + "?body=" + ""));
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(call.this,"it may be you dont have whats app",Toast.LENGTH_LONG).show();

        }


    }
    private void sendMail() {

        String recipientList =  "ncov2019@gmail.com";
        String[] recipients = recipientList.split(",");

        String subject = "Help/Query related to COVID19 ";
        String message = "Type your Query/Greveiences here";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }

    public void makePhoneCall1() {
        String number = "1075";


            if (ContextCompat.checkSelfPermission(call.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(call.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number)));
            }
    }

    public void makePhoneCall2() {
        String number = "+91-11-23978043";


        if (ContextCompat.checkSelfPermission(call.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(call.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            String dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number)));
        }
    }

    public void makePhoneCall3() {
        String number = "104";


        if (ContextCompat.checkSelfPermission(call.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(call.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            String dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number)));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                        makePhoneCall1();
                        makePhoneCall2();
                        makePhoneCall3();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
