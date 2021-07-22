package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;

public class ka_stat extends others {
    private WebView mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ka_stat);
        mMap=findViewById(R.id.ka_sta_web);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://www.covid19india.org/state/KA");
    }
}
