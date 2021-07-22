package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;

public class th4 extends hospital  {
    private WebView mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th4);
        mMap=findViewById(R.id.ma4);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://www.google.com/maps/place/Gulbarga+Institute+of+Medical+Sciences/@17.3278782,76.8375984,16z/data=!4m5!3m4!1s0x3bc8c74da9db9bd1:0xcfd78c639e51f3b3!8m2!3d17.328506!4d76.8398625");
    }
}
