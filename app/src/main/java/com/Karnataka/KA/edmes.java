package com.Karnataka.KA;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.Karnataka.R;

public class edmes extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edmes);

        VideoView video = findViewById(R.id.videoView2);
        MediaController mc=new MediaController(this);
        Uri uri=Uri.parse("https://covid19-risk-assesment-tool.000webhostapp.com/uploads/Amitabh%20Bachchan's%20message%20on%20COVID-19.mp4");
        video.setVideoURI(uri);
        video.setMediaController(mc);
        mc.setAnchorView(video);

        video.start();
    }
}