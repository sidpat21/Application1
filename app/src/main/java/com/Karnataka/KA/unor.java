package com.Karnataka.KA;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;

public class unor extends NavigationDrawerBaseActivity {
    private WebView unweb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unor);
        appBarTxt.setText("Financial Support");

        unweb=findViewById(R.id.wun);
        WebSettings a=  unweb.getSettings();
        a.setJavaScriptEnabled(true);

        unweb.loadUrl("https://serviceonline.gov.in/karnataka/popUp.do?serviceId=10940007&primary=T&UUID=700c6fc5-af92-4477-b9f3-4a52fe9f76ed&grievDefined=0&serviceLinkRequired=No&directService=true&userLoggedIn=N&tempId=5206&source=CTZN&OWASP_CSRFTOKEN=ZMHU-E55V-YE98-1C3O-6T8N-V4TQ-ENT3-4RJR");

    }
}
