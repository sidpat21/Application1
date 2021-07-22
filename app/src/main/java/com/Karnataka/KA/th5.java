package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;

public class th5 extends hospital  {
    private WebView mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th5);
        mMap=findViewById(R.id.ma5);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://www.google.com/maps/place/Mysore+Medical+College+And+Research+Institute/@12.3150229,76.648216,17z/data=!3m1!4b1!4m5!3m4!1s0x3baf70730406bcef:0x332f4cf6f98307e9!8m2!3d12.3150229!4d76.6504047");
    }
}
