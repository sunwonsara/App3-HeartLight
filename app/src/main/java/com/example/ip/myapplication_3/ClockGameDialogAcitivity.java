package com.example.ip.myapplication_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class ClockGameDialogAcitivity extends AppCompatActivity {
    Intent intent;
    int val = 0;

    ImageView btn_continue, btn_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_clockgamedialog);

        intent = getIntent();
        val = intent.getExtras().getInt("num");

        btn_continue = (ImageView)findViewById(R.id.btn_continue);
        btn_home = (ImageView)findViewById(R.id.btn_home);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ClockGameDialogAcitivity.this, ClockGameActivity.class);
                intent.putExtra("num", val);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ClockGameDialogAcitivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
