package com.example.ip.myapplication_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class ClothesGameDialogAcitivity extends AppCompatActivity {
    Intent intent;
    int val = 0;
    int[] show = new int[4];

    ImageView btn_continue, btn_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_clothesgamedialog);

        intent = getIntent();
        val = intent.getExtras().getInt("num");
        show = intent.getExtras().getIntArray("show");

        btn_continue = (ImageView)findViewById(R.id.btn_continue);
        btn_home = (ImageView)findViewById(R.id.btn_home);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ClothesGameDialogAcitivity.this, ClothesGameActivity.class);
                intent.putExtra("num", val);
                intent.putExtra("show", show);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ClothesGameDialogAcitivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
