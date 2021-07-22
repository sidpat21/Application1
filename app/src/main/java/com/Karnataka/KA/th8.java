package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;


public class th8 extends hospital  {
    private WebView mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th8);
        mMap=findViewById(R.id.ma8);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://www.google.com/maps/place/VIMS/@15.1529479,76.8945018,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb713ca1d7cf069:0xffcc6a3055b4ae5f!8m2!3d15.1529479!4d76.8966905");
    }
}
