package com.example.ip.myapplication_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class LastProposeGame extends AppCompatActivity {
    ImageView[] img = new ImageView[12];
    int[] click_num = new int[12];
    int result = 0;
    int cnt = 0;
    int num=0;
    LastPropose lastPropose = new LastPropose();
    int[] show = lastPropose.getShow();
    ImageView[] show_img = new ImageView[12];
    Intent intent;
    Random rnd=new Random();
    int random;
    String answer[]={"m1","m2","m3","m4","m5","m6","m7","m8","m9","m10","m11","m12",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_propose_game);

        //익명 클래스를 사용하여 이벤트 리스터 사용
        ImageView.OnClickListener onClickListener = new ImageView.OnClickListener(){
            @Override
            public void onClick(View view){

                show_img[0] = (ImageView)findViewById(R.id.proimg_show1);
                show_img[1] = (ImageView)findViewById(R.id.proimg_show2);
                show_img[2] = (ImageView)findViewById(R.id.proimg_show3);
                show_img[3] = (ImageView)findViewById(R.id.proimg_show4);
                show_img[4] = (ImageView)findViewById(R.id.proimg_show5);
                show_img[5] = (ImageView)findViewById(R.id.proimg_show6);
                show_img[6] = (ImageView)findViewById(R.id.proimg_show7);
                show_img[7] = (ImageView)findViewById(R.id.proimg_show8);
                show_img[8] = (ImageView)findViewById(R.id.proimg_show9);
                show_img[9] = (ImageView)findViewById(R.id.proimg_show10);
                show_img[10] = (ImageView)findViewById(R.id.proimg_show11);
                show_img[11] = (ImageView)findViewById(R.id.proimg_show12);


                String ivKey=(String)view.getTag();
                if(!ivKey.equals(answer[cnt])){
                    result = 1;
                }
                  /*
                int num = Integer.parseInt(view.getTag().toString());

                if(click_num[cnt] != show[cnt]) {
                    result = 1;
                }
                */

                switch (ivKey){ //누르면 밑에 나오게
                    case "m7":
                        show_img[cnt].setBackgroundResource(R.drawable.m7);
                        break;
                    case "m1":
                        show_img[cnt].setBackgroundResource(R.drawable.m1);
                        break;
                    case "m5":
                        show_img[cnt].setBackgroundResource(R.drawable.m5);
                        break;
                    case "m10":
                        show_img[cnt].setBackgroundResource(R.drawable.m10);
                        break;
                    case "m8":
                        show_img[cnt].setBackgroundResource(R.drawable.m8);
                        break;
                    case "m3":
                        show_img[cnt].setBackgroundResource(R.drawable.m3);
                        break;
                    case "m9":
                        show_img[cnt].setBackgroundResource(R.drawable.m9);
                        break;
                    case "m6":
                        show_img[cnt].setBackgroundResource(R.drawable.m6);
                        break;
                    case "m11":
                        show_img[cnt].setBackgroundResource(R.drawable.m11);
                        break;
                    case "m2":
                        show_img[cnt].setBackgroundResource(R.drawable.m2);
                        break;
                    case "m4":
                        show_img[cnt].setBackgroundResource(R.drawable.m4);
                        break;
                    case "m12":
                        show_img[cnt].setBackgroundResource(R.drawable.m12);
                        break;
                }


                if(result == 1 ){ //&& cnt == 11
                    Toast.makeText(LastProposeGame.this, click_num[cnt]  + "미션 실패", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LastProposeGame.this, MainActivity.class));
                }

                //성공시 "랜덤으로" Ending.class, Ending2.class, Ending3.class 띄워주기(랜덤으로는 되는데 나오는 위치가 이상함...)
                if(result == 0 && cnt == 11){
                    random=rnd.nextInt(3); //0~2출력
                    switch(random){
                        case 0:
                            intent = new Intent(LastProposeGame.this,Ending.class);
                            break;
                        case 1:
                            intent = new Intent(LastProposeGame.this,Ending2.class);
                            break;
                        case 2:
                            intent = new Intent(LastProposeGame.this,Ending3.class);
                            break;
                    }
                    startActivity(intent);
                }
                cnt++;
            }
        };


        img[0] = (ImageView)findViewById(R.id.pro_img1);
        img[0].setTag("m7");
        img[1] = (ImageView)findViewById(R.id.pro_img2);
        img[1].setTag("m1");
        img[2] = (ImageView)findViewById(R.id.pro_img3);
        img[2].setTag("m5");
        img[3] = (ImageView)findViewById(R.id.pro_img4);
        img[3].setTag("m10");
        img[4] = (ImageView)findViewById(R.id.pro_img5);
        img[4].setTag("m8");
        img[5] = (ImageView)findViewById(R.id.pro_img6);
        img[5].setTag("m3");
        img[6] = (ImageView)findViewById(R.id.pro_img7);
        img[6].setTag("m9");
        img[7] = (ImageView)findViewById(R.id.pro_img8);
        img[7].setTag("m6");
        img[8] = (ImageView)findViewById(R.id.pro_img9);
        img[8].setTag("m11");
        img[9] = (ImageView)findViewById(R.id.pro_img10);
        img[9].setTag("m2");
        img[10] = (ImageView)findViewById(R.id.pro_img11);
        img[10].setTag("m4");
        img[11] = (ImageView)findViewById(R.id.pro_img12);
        img[11].setTag("m12");



        for(int i=0; i<12; i++){
            img[i].setOnClickListener(onClickListener);
        }
    }
}
