package com.example.whatever.test.androiddemos;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void shareMethod(View view) {
        EditText et = (EditText) findViewById(R.id.msg_edit_text);

        String textToShare = et.getText().toString();

        Intent intent = ShareCompat.IntentBuilder
                .from(this)
                .setText(textToShare)
                .setType("text/plain")
                .getIntent();

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
