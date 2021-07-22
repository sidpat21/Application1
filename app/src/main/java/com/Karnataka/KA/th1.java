package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;


public class th1 extends hospital  {
    private WebView mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th1);
        mMap=findViewById(R.id.ma1);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://www.google.com/maps/place/BMCRI+-+Bangalore+Medical+College+and+Research+Institute/@12.9593958,77.5725327,17z/data=!3m1!4b1!4m5!3m4!1s0x3bae16773e7dc413:0x655b9637743997d8!8m2!3d12.9593958!4d77.5747214");
    }
}
