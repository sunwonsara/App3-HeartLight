package com.example.ip.myapplication_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class ClockAcitivity extends AppCompatActivity {
    Intent intent;
    Thread thread;
    int val;

    ImageView stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_clock);

        intent = getIntent();
        val = intent.getExtras().getInt("num");

        stop = (ImageView)findViewById(R.id.stop);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(val > 3){
                        intent = new Intent(ClockAcitivity.this, ClockGameActivity.class);
                        intent.putExtra("num", 0);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        thread.interrupt();
                    }
                    Thread.sleep(1000);
                    val++;
                    if(val > 3){
                        intent = new Intent(ClockAcitivity.this, ClockGameActivity.class);
                        intent.putExtra("num", 0);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        thread.interrupt();
                    }
                    Thread.sleep(1000);
                    val++;
                    if(val > 3){
                        intent = new Intent(ClockAcitivity.this, ClockGameActivity.class);
                        intent.putExtra("num", 0);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        thread.interrupt();
                    }
                    Thread.sleep(1000);
                    val++;
                    intent = new Intent(ClockAcitivity.this, ClockGameActivity.class);
                    intent.putExtra("num", 0);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    thread.interrupt();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.interrupt();
                intent = new Intent(ClockAcitivity.this, ClockDialogAcitivity.class);
                intent.putExtra("num", val);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

    }

    /*void next_intent(){
        intent = new Intent(this, ClockGameActivity.class);
        intent.putExtra("num", 0);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }*/
}
