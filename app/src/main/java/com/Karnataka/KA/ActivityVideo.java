package com.Karnataka.KA;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.Karnataka.R;
import com.bumptech.glide.Glide;

public class ActivityVideo extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("video_url") /*&& getIntent().hasExtra("image_name")*/){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String videoUrl = getIntent().getStringExtra("video_url");

            setVideoPlayer(videoUrl);
        }
    }


    private void setVideoPlayer(String videoUrl){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        WebView wb=findViewById(R.id.vvvv);
        WebSettings a=  wb.getSettings();
        a.setJavaScriptEnabled(true);
        wb.loadUrl(videoUrl);

    }

}
