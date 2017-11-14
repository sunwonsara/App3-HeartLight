package com.example.ip.myapplication_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class StartWebtoon2Activity extends AppCompatActivity {
    Intent intent;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_startwebtoon2);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    intent = new Intent(StartWebtoon2Activity.this, StartWebtoon3Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    thread.interrupt();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}
