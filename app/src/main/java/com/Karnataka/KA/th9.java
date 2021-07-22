package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;


public class th9 extends hospital  {
    private WebView mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th9);
        mMap=findViewById(R.id.ma9);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://www.google.com/maps/place/Karnataka+Institute+of+Medical+Sciences/@15.3616003,75.1307201,15z/data=!4m5!3m4!1s0x0:0x63a4c93787789c0f!8m2!3d15.3616003!4d75.1307201");
    }
}
