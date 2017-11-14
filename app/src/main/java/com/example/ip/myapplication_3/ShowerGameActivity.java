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

public class ShowerGameActivity extends AppCompatActivity {
    ImageView[] img = new ImageView[4];
    int[] click_num = new int[4];
    int result = 0;
    int cnt = 0, val = 0;
    ShowerActivity showerActivity = new ShowerActivity();
    int[] show = showerActivity.getShow();
    ImageView[] show_img = new ImageView[4];
    ImageView stop;
    Intent intent;
    Handler handler;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_showergame);

        intent = getIntent();
        val = intent.getExtras().getInt("num");

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
                    intent = new Intent(ShowerGameActivity.this, MainActivity.class);
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
                show_img[0] = (ImageView)findViewById(R.id.img_show1);
                show_img[1] = (ImageView)findViewById(R.id.img_show2);
                show_img[2] = (ImageView)findViewById(R.id.img_show3);
                show_img[3] = (ImageView)findViewById(R.id.img_show4);

                int num = Integer.parseInt(view.getTag().toString());

                click_num[cnt] = num;

                if(click_num[cnt] != show[cnt]) {
                    result = 1;
                }

                switch (num){
                    case 0:
                        show_img[cnt].setBackgroundResource(R.drawable.conditioner);
                        break;
                    case 1:
                        show_img[cnt].setBackgroundResource(R.drawable.shampoo);
                        break;
                    case 2:
                        show_img[cnt].setBackgroundResource(R.drawable.soap);
                        break;
                    case 3:
                        show_img[cnt].setBackgroundResource(R.drawable.toothbrush);
                        break;
                }

                img[num].setVisibility(View.GONE);

                if(result == 1 && cnt == 3){
                    handler.removeMessages(0);
                    intent = new Intent(ShowerGameActivity.this, MainActivity.class);
                    Toast.makeText(ShowerGameActivity.this, click_num[cnt] + ", " + showerActivity.show[cnt] + "미션 실패", Toast.LENGTH_SHORT).show();
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
                if(result == 0 && cnt == 3){
                    handler.removeMessages(0);
                    intent = new Intent(ShowerGameActivity.this, ClothesActivity.class); //s
                    intent.putExtra("num", 0);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }

                cnt++;
            }
        };

        img[0] = (ImageView)findViewById(R.id.img_1);
        img[0].setTag(0);
        img[1] = (ImageView)findViewById(R.id.img_2);
        img[1].setTag(1);
        img[2] = (ImageView)findViewById(R.id.img_3);
        img[2].setTag(2);
        img[3] = (ImageView)findViewById(R.id.img_4);
        img[3].setTag(3);

        for(int i=0; i<4; i++){
            img[i].setOnClickListener(onClickListener);
        }

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeMessages(0);
                intent = new Intent(ShowerGameActivity.this, ShowerGameDialogAcitivity.class);
                intent.putExtra("num", val);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
