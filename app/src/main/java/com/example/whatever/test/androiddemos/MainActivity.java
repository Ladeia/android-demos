package com.example.whatever.test.androiddemos;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.IOException;

import static android.support.v4.content.FileProvider.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File imagePath = getFilesDir();

        File newFile = new File(imagePath, "default_image.jpg");

        if (!newFile.exists()){
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Uri contentUri = getUriForFile(this,
                "com.example.whatever.test.androiddemos.fileprovider", newFile);

        Intent shareIntent = ShareCompat.IntentBuilder.from(this).setType("image/jpeg")
                .setStream(contentUri).getIntent();

        shareIntent.setData(contentUri);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        if (shareIntent.resolveActivity(getPackageManager()) != null){
            startActivity(shareIntent);
        }
    }
}
