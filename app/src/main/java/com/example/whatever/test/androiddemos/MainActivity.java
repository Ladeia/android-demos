package com.example.whatever.test.androiddemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    float brightness = 0.0F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        System.out.println(lp.screenBrightness);
        lp.screenBrightness = (10);
        getWindow().setAttributes(lp);
    }

    public void aumentarBrilho(View view){
        if(brightness <= 1.0F) {
            Log.d("btnpress ++", "aumentarBrilho: ok");
            brightness += 0.1F;
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            System.out.println(lp.screenBrightness);
            lp.screenBrightness = brightness;
            getWindow().setAttributes(lp);
        }
    }

    public void diminuirBrilho(View view){
        if(brightness >= 0.0F) {
            Log.d("btnpress --", "diminuirBrilho: ok");
            brightness -= 0.1F;
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            System.out.println(lp.screenBrightness);
            lp.screenBrightness = brightness;
            getWindow().setAttributes(lp);
        }
    }
}
