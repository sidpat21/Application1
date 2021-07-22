package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;

public class th2 extends hospital  {

    private WebView mMap;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th2);
        mMap=findViewById(R.id.ma2);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);

        mMap.loadUrl("https://www.google.com/maps/place/Cancyte+Technologies+Pvt+Ltd/@12.9543879,77.5694688,17z/data=!3m1!4b1!4m5!3m4!1s0x3bae15f073e55999:0xeb0bc1ae9d0d07ab!8m2!3d12.9543879!4d77.5716575?shorturl=1");

    }
}
