package com.example.ip.myapplication_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.Random;

public class ClothesActivity extends AppCompatActivity {
    Intent intent;
    Thread thread;
    Random rnd = new Random();
    ImageView[]img = new ImageView[9];
    ImageView question, stop;
    static int[] show = new int[4];
    int num = 0, val = 0;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_clothes);

        intent = getIntent();
        val = intent.getExtras().getInt("num");

        stop = (ImageView)findViewById(R.id.stop);
        question = (ImageView)findViewById(R.id.question);
        img[0] = (ImageView)findViewById(R.id.img1);
        img[1] = (ImageView)findViewById(R.id.img2);
        img[2] = (ImageView)findViewById(R.id.img3);
        img[3] = (ImageView)findViewById(R.id.img4);
        img[4] = (ImageView)findViewById(R.id.img5);
        img[5] = (ImageView)findViewById(R.id.img6);
        img[6] = (ImageView)findViewById(R.id.img7);
        img[7] = (ImageView)findViewById(R.id.img8);
        img[8] = (ImageView)findViewById(R.id.img9);

        num = rnd.nextInt(4);

        switch (num){
            case 0:
                question.setBackgroundResource(R.drawable.dressroom_1);
                show[0] = 1; //상의
                show[1] = 4; //치마
                show[2] = 2; //넥타이
                show[3] = 8; //양말
                break;
            case 1:
                question.setBackgroundResource(R.drawable.dressroom_2);
                show[0] = 8;
                show[1] = 2;
                show[2] = 1;
                show[3] = 4;
                break;
            case 2:
                question.setBackgroundResource(R.drawable.dressroom_3);
                show[0] = 2;
                show[1] = 8;
                show[2] = 1;
                show[3] = 4;
                break;
            case 3:
                question.setBackgroundResource(R.drawable.dressroom_4);
                show[0] = 2;
                show[1] = 8;
                show[2] = 1;
                show[3] = 4;
                break;
        }

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(val > 3){
                        intent = new Intent(ClothesActivity.this, ClothesGameActivity.class);
                        intent.putExtra("num", 0);
                        intent.putExtra("show",show);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        thread.interrupt();
                    }
                    Thread.sleep(1000);
                    val++;
                    if(val > 3){
                        intent = new Intent(ClothesActivity.this, ClothesGameActivity.class);
                        intent.putExtra("num", 0);
                        intent.putExtra("show",show);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        thread.interrupt();
                    }
                    Thread.sleep(1000);
                    val++;
                    if(val > 3){
                        intent = new Intent(ClothesActivity.this, ClothesGameActivity.class);
                        intent.putExtra("num", 0);
                        intent.putExtra("show",show);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        thread.interrupt();
                    }
                    Thread.sleep(1000);
                    val++;
                    intent = new Intent(ClothesActivity.this, ClothesGameActivity.class);
                    intent.putExtra("num", 0);
                    intent.putExtra("show",show);
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
                intent = new Intent(ClothesActivity.this, ClothesDialogActivity.class);
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
