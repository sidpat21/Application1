package com.Karnataka.KA;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.Karnataka.R;

public class qw extends  NavigationDrawerBaseActivity {
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qw);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        appBarTxt.setText("Essential protective products");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.patanjaliayurved.net/product/herbal-home-care/toiletries/hand-wash-and-sanitizer/patanjali-hand-sanitizer/1632";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.amazon.in/Mediweave-KN95-FFP2-Nonwoven-Face/dp/B086T5LN62/ref=sr_1_18?dchild=1&keywords=mask&qid=1589273271&sr=8-18";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.amazon.in/Dettol-Instant-Hand-Sanitizer-50/dp/B007BBU09M/ref=sr_1_3?crid=5YJ9AHV7ZZWT&dchild=1&keywords=sanitizer+for+hand&qid=1589273860&sprefix=sanitizer%2Caps%2C382&sr=8-3";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.amazon.in/Careway-Medical-Examination-Disposable-Powderd/dp/B01MZ3LC2Q";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
