package com.Karnataka.KA;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import com.Karnataka.R;

public class vvideo extends NavigationDrawerBaseActivity {

    VideoView vv;
    MediaController Mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vvideo);
        appBarTxt.setText("Video view");

        vv=findViewById(R.id.videoView);
        Mc=new MediaController(this);


        String path="https://www.youtube.com/watch?v=v-852f1PXBo";
        Uri uri=Uri.parse(path);
        vv.setVideoURI(uri);
        vv.setMediaController(Mc);
        Mc.setAnchorView(vv);
        vv.start();


    }
}