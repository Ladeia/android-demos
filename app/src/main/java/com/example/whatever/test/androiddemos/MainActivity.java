package com.example.whatever.test.androiddemos;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            tts.setLanguage(Locale.US);
        } else {
            Toast.makeText(MainActivity.this, "Init failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void doSpeak(View view) {
        String text = ((EditText)findViewById(R.id.edit_text)).getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}
