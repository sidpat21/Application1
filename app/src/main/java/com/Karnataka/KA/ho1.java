package com.Karnataka.KA;

import android.os.Bundle;
import android.webkit.WebView;
import com.Karnataka.R;

public class ho1 extends AppointDoc {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ho1);
        appBarTxt.setText("Appoint a Doctor");

        mWebView=findViewById(R.id.wd1);
        mWebView.loadUrl("https://www.practo.com/bangalore/doctors");

    }


}
