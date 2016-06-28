package com.example.whatever.test.androiddemos;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Environment.getDataDirectory
        TextView tv  = (TextView) findViewById(R.id.env_data_dir_value);
        tv.setText(Environment.getDataDirectory().getAbsolutePath());

        // Environment.getDownloadCacheDirectory
        tv = (TextView) findViewById(R.id.env_dlcache_dir_value);
        tv.setText(Environment.getDownloadCacheDirectory().getAbsolutePath());

        // Environment.getExternalStorageDirectory
        tv = (TextView) findViewById(R.id.env_ext_store_dir_value);
        tv.setText(Environment.getExternalStorageDirectory().getAbsolutePath());

        // Environment.getRootDirectory
        tv = (TextView) findViewById(R.id.env_root_dir_value);
        tv.setText(Environment.getRootDirectory().getAbsolutePath());

        // Environment.getExternalStoragePublicDirectory
        tv = (TextView) findViewById(R.id.env_extpub_dir_value);
        tv.setText(Environment.getExternalStoragePublicDirectory("").getAbsolutePath());
    }
}
