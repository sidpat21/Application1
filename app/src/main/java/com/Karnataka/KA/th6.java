package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;


public class th6 extends hospital  {
    private WebView mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th6);
        mMap=findViewById(R.id.ma6);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://www.google.com/maps/place/Neuberg+Anand+Reference+Laboratory/@12.9817797,77.6027857,17z/data=!4m5!3m4!1s0x3bae17f4a3bf1e3f:0xafc494140932de1a!8m2!3d12.9820988!4d77.603801");
    }
}
