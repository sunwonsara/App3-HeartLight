package com.example.ip.myapplication_3;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class ClockGameActivity extends AppCompatActivity {
    Intent intent;
    Context context;
    int val = 0;
    TextView time;
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    ImageView stop;
    Button setalarm;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_clockgame);

        this.context = this;
        intent = getIntent();
        val = intent.getExtras().getInt("num");

        alarm_manager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarm_timepicker = (TimePicker)findViewById(R.id.timePicker);
        time = (TextView)findViewById(R.id.time);
        stop = (ImageView)findViewById(R.id.stop);

        handler = new Handler(){
            public void handleMessage(Message msg){
                time.setText(""+val);
                handler.sendEmptyMessageDelayed(0,1000);
                val++;
                time.setText(""+val);

                if(val == 10){
                    handler.removeMessages(0);
                    intent = new Intent(ClockGameActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        };

        handler.sendEmptyMessage(0);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeMessages(0);
                intent = new Intent(ClockGameActivity.this, ClockGameDialogAcitivity.class);
                intent.putExtra("num", val);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        setalarm = (Button)findViewById(R.id.setalarm);
        setalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calendar.set(Calendar.HOUR_OF_DAY,alarm_timepicker.getHour());
                //calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());
                //Toast.makeText(context, alarm_timepicker.getHour()+", "+alarm_timepicker.getMinute(), Toast.LENGTH_SHORT).show();
                if((alarm_timepicker.getHour() == 6 || alarm_timepicker.getHour() == 18 )&&(alarm_timepicker.getMinute()==0)){
                    handler.removeMessages(0);
                    Toast.makeText(context, "미션 성공", Toast.LENGTH_SHORT).show();
                    intent = new Intent(ClockGameActivity.this, ClockSuccessActivity.class);
                    startActivity(intent);
                }
                else{
                    handler.removeMessages(0);
                    intent = new Intent(ClockGameActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
