package com.example.ip.myapplication_3;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LastPropose extends AppCompatActivity {
    int []images={R.id.pro_txt1, R.id.pro_txt2, R.id.pro_txt3,R.id.pro_txt4,R.id.pro_txt5,R.id.pro_txt6,R.id.pro_txt7,R.id.pro_txt8,R.id.pro_txt9,R.id.pro_txt10,R.id.pro_txt11,R.id.pro_txt12};
    Intent intent;
    static int[] show = new int[12];
    ImageView[] txt = new ImageView[12];
    Random rnd = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_propose);


        txt[0] = (ImageView)findViewById(R.id.pro_txt1);
        txt[1] = (ImageView)findViewById(R.id.pro_txt2);
        txt[2] = (ImageView)findViewById(R.id.pro_txt3);
        txt[3] = (ImageView)findViewById(R.id.pro_txt4);
        txt[4] = (ImageView)findViewById(R.id.pro_txt5);
        txt[5] = (ImageView)findViewById(R.id.pro_txt6);
        txt[6] = (ImageView)findViewById(R.id.pro_txt7);
        txt[7] = (ImageView)findViewById(R.id.pro_txt8);
        txt[8] = (ImageView)findViewById(R.id.pro_txt9);
        txt[9] = (ImageView)findViewById(R.id.pro_txt10);
        txt[10] = (ImageView)findViewById(R.id.pro_txt11);
        txt[11] = (ImageView)findViewById(R.id.pro_txt12);


        // 5초간 멈추기
        Handler handler = new Handler(){
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                intent=new Intent(LastPropose.this, LastProposeGame.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        };
        handler.sendEmptyMessageDelayed(0, 5000);
    }
    int[] getShow(){
        return show;
    }
}
