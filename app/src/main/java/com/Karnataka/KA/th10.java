package com.Karnataka.KA;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.Karnataka.R;

public class th10 extends hospital  {
    private WebView mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th10);
        mMap=findViewById(R.id.ma10);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://www.google.com/search?client=firefox-b-d&q=bims&sxsrf=ALeKk03rsISySClQtVsgMCMaR8RoDMG6dg:1593860339895&npsic=0&rflfq=1&rlha=0&rllag=15872202,74510931,198&tbm=lcl&rldimm=17554763322967553676&lqi=CgRiaW1zWgwKBGJpbXMiBGJpbXM&ved=2ahUKEwi784W7uLPqAhWSzDgGHUmeDEIQvS4wAHoECAsQIA&rldoc=1&tbs=lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:2&rlst=f#rlfi=hd:;si:17554763322967553676,l,CgRiaW1zWgwKBGJpbXMiBGJpbXM;mv:[[15.880748699999998,74.51977389999999],[15.847937600000002,74.4964232]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:2");
    }
}
