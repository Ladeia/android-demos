package com.example.whatever.test.androiddemos;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView mVideoView = (VideoView) findViewById(R.id.video_view);

        Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");

        mVideoView.setVideoURI(uri);

        mVideoView.start();
    }
}
