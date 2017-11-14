package com.example.ip.myapplication_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.Random;

public class ShowerActivity extends AppCompatActivity {
    Intent intent;
    Thread thread;

    String[] menu = {"conditioner", "shampoo", "soap", "toothbrush"};
    static int[] show = new int[4];
    Random rnd = new Random();
    int num, val = 0;
    ImageView question, stop;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_shower);

        num = rnd.nextInt(3);
        question = (ImageView)findViewById(R.id.question);
        stop = (ImageView)findViewById(R.id.stop);

        switch (num){
            case 0:
                question.setBackgroundResource(R.drawable.question_01);
                show[0] = 3;
                show[1] = 1;
                show[2] = 2;
                show[3] = 0;
                break;
            case 1:
                question.setBackgroundResource(R.drawable.question_02);
                show[0] = 2;
                show[1] = 1;
                show[2] = 3;
                show[3] = 0;
                break;
            case 2:
                question.setBackgroundResource(R.drawable.question_03);
                show[0] = 1;
                show[1] = 3;
                show[2] = 0;
                show[3] = 2;
                break;
        }

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(val > 3){
                        intent = new Intent(ShowerActivity.this, ShowerGameActivity.class);
                        intent.putExtra("num", 0);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        thread.interrupt();
                    }
                    Thread.sleep(1000);
                    val++;
                    if(val > 3){
                        intent = new Intent(ShowerActivity.this, ShowerGameActivity.class);
                        intent.putExtra("num", 0);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        thread.interrupt();
                    }
                    Thread.sleep(1000);
                    val++;
                    if(val > 3){
                        intent = new Intent(ShowerActivity.this, ShowerGameActivity.class);
                        intent.putExtra("num", 0);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        thread.interrupt();
                    }
                    Thread.sleep(1000);
                    val++;
                    intent = new Intent(ShowerActivity.this, ShowerGameActivity.class);
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
                intent = new Intent(ShowerActivity.this, ShowerDialogActivity.class);
                intent.putExtra("num", val);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                thread.interrupt();
            }
        });
    }

    int[] getShow(){
        return show;
    }
}
