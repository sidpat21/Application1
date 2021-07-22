package com.Karnataka.KA;

import android.os.Bundle;
import android.webkit.WebView;

import com.Karnataka.R;

public class DonateActivityDrawer extends NavigationDrawerBaseActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate_activity);
        appBarTxt.setText("Donate");

        mWebView=findViewById(R.id.cmd);
        mWebView.loadUrl("https://cmrf.karnataka.gov.in/English/index.html");

    }


}
