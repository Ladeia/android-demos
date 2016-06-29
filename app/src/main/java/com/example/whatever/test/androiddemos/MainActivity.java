package com.example.whatever.test.androiddemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeStringToFile("String saved to file");

        TextView tv = (TextView) findViewById(R.id.msg_text_view);

        tv.setText(readStringFromFile());
    }

    private void writeStringToFile(String s){
        File path = this.getFilesDir();
        File local_file = new File(path, "local_file.txt");

        if (!local_file.exists()){
            try {
                local_file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fileOutput = new FileOutputStream(local_file);
            fileOutput.write(s.getBytes());
            fileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readStringFromFile(){
        String s = "";

        File path = this.getFilesDir();
        File local_file = new File(path, "local_file.txt");

        if (local_file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(local_file);

                byte buffer[] = new byte[1024];

                while (fileInputStream.read(buffer) > 0){
                    s = new String(buffer);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return s;
    }
}
