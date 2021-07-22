package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;


public class th3 extends hospital  {
    private WebView mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th3);
        mMap=findViewById(R.id.ma3);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://www.google.com/maps/place/Hassan+Institute+Of+Medical+Sciences/@13.004869,76.1004978,17z/data=!3m1!4b1!4m5!3m4!1s0x3ba5483de14ade31:0xe15eae8a98ba6ded!8m2!3d13.0048638!4d76.1026865?shorturl=1");
    }
}
