package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;


public class th7 extends hospital  {
    private WebView mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th7);
        mMap=findViewById(R.id.ma7);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://www.google.com/maps/place/SHIMOGA+Institute+of+Medical+Sciences+(SIMS)/@13.9326578,75.5646635,17z/data=!3m1!4b1!4m5!3m4!1s0x3bbba8d0bb6c8adf:0xc7be084ea62ac67d!8m2!3d13.9326526!4d75.5668522?shorturl=1");
    }
}
