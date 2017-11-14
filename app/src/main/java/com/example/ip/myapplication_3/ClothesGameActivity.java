package com.example.ip.myapplication_3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ClothesGameActivity extends AppCompatActivity {
    ImageView[] img = new ImageView[9];
    int[] click_num = new int[4];
    int result = 0;
    int cnt = 0, val = 0;
    ShowerActivity showerActivity = new ShowerActivity();
    int[] show = new int[4];
    ImageView stop;
    Intent intent;
    Handler handler;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_clothesgame);

        intent = getIntent();
        val = intent.getExtras().getInt("num");
        show = intent.getExtras().getIntArray("show");

        stop = (ImageView)findViewById(R.id.stop);
        time = (TextView)findViewById(R.id.time);

        handler = new Handler(){
            public void handleMessage(Message msg){
                time.setText(""+val);
                handler.sendEmptyMessageDelayed(0,1000);
                val++;
                time.setText(""+val);

                if(val == 10){
                    handler.removeMessages(0);
                    intent = new Intent(ClothesGameActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        };

        handler.sendEmptyMessage(0);

        ImageView.OnClickListener onClickListener = new ImageView.OnClickListener(){
            @Override
            public void onClick(View view){
                int num = Integer.parseInt(view.getTag().toString());

                click_num[cnt] = num;

                if(click_num[cnt] != show[cnt]) {
                    result = 1;
                }

                img[num].setVisibility(View.INVISIBLE);

                if(result == 1 && cnt == 3){
                    handler.removeMessages(0);
                    intent = new Intent(ClothesGameActivity.this, MainActivity.class);
                    Toast.makeText(ClothesGameActivity.this, "미션 실패", Toast.LENGTH_SHORT).show();
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
                if(result == 0 && cnt == 3){
                    handler.removeMessages(0);
                    intent = new Intent(ClothesGameActivity.this, LastPropose.class); //성공 시 가야하는 곳 - ?
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }

                cnt++;
            }
        };

        img[0] = (ImageView)findViewById(R.id.img1);
        img[0].setTag(0);
        img[1] = (ImageView)findViewById(R.id.img2);
        img[1].setTag(1);
        img[2] = (ImageView)findViewById(R.id.img3);
        img[2].setTag(2);
        img[3] = (ImageView)findViewById(R.id.img4);
        img[3].setTag(3);
        img[4] = (ImageView)findViewById(R.id.img5);
        img[4].setTag(4);
        img[5] = (ImageView)findViewById(R.id.img6);
        img[5].setTag(5);
        img[6] = (ImageView)findViewById(R.id.img7);
        img[6].setTag(6);
        img[7] = (ImageView)findViewById(R.id.img8);
        img[7].setTag(7);
        img[8] = (ImageView)findViewById(R.id.img9);
        img[8].setTag(8);

        for(int i=0; i<9; i++){
            img[i].setOnClickListener(onClickListener);
        }

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeMessages(0);
                intent = new Intent(ClothesGameActivity.this, ClothesGameDialogAcitivity.class);
                intent.putExtra("num", val);
                intent.putExtra("show",show);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
