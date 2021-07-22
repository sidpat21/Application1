package com.Karnataka.KA;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.Karnataka.R;


public class youtube extends YouTubeBaseActivity  {

    private  static final String TAG="YoutubeActivity";

    YouTubePlayerView mYouTubeplayerView;
    Button Play;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube);
        Log.d(TAG,"OnCreate: Starting.");

        //appBarTxt.setText("Home");
        Play = (Button) findViewById(R.id.play);
        mYouTubeplayerView=(YouTubePlayerView)findViewById(R.id.youtubeplayer);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG,"OnClick Initializing done");

                youTubePlayer.loadVideo("ykZJ-jcE-Do");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG,"OnClick failed Initializing");
            }
        };

        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"OnClick:Initilisg youtubeplayer");
                mYouTubeplayerView.initialize(Youtubeconfig.getApiKey(),mOnInitializedListener);
                Log.d(TAG,"OnClick Initializing done");
            }
        });



    }

}



