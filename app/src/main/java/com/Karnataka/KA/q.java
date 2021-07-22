package com.Karnataka.KA;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;

public class q extends NavigationDrawerBaseActivity {

    private WebView tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q);
        appBarTxt.setText("Covid19 Advisories By Government");

        tw=findViewById(R.id.ne1);
        WebSettings a=  tw.getSettings();
        a.setJavaScriptEnabled(true);

        tw.loadUrl("http://www.cghealth.nic.in/cghealth17/index.html");

    }


}
