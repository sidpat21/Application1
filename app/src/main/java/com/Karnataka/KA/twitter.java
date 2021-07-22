package com.Karnataka.KA;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;

public class twitter extends NavigationDrawerBaseActivity {
private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter);
        appBarTxt.setText("Latest Covid19 news");

        mWebView=findViewById(R.id.w);
        WebSettings a=  mWebView.getSettings();
        a.setJavaScriptEnabled(true);

        mWebView.loadUrl("https://www.google.com/search?rlz=1C1HSTG_enIN899IN899&biw=1536&bih=754&ei=3ra2Xr6rMsXuz7sP1seauAs&q=covid+19+latest+chhattisgarh&oq=covid+19+latest+bihar&gs_lcp=CgZwc3ktYWIQAzIECAAQRzIECAAQRzIECAAQR1CD6ldYn41YYPKPWGgAcAF4AIABAIgBAJIBAJgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwi-kob_96bpAhVF93MBHdajBrcQ4dUDCAw&uact=5");

    }

}
