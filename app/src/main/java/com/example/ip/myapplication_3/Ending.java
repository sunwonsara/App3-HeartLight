package com.example.ip.myapplication_3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

//엔딩 - ontouch() , Linear도 onclick먹음!
public class Ending extends AppCompatActivity {
  //  private CallbackManager callbackManager;
    Button but1,but2;
    LinearLayout cartoon1;
    int []images={R.drawable.a2, R.drawable.a3, R.drawable.a4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_ending);
      //  callbackManager = CallbackManager.Factory.create();
        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        cartoon1=(LinearLayout)findViewById(R.id.cartoon1);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                cartoon1.setBackgroundResource(images[0]);
            }
        }, 1000);

        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            public void run() {
                cartoon1.setBackgroundResource(images[1]);
            }
        }, 2000);

        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            public void run() {
                cartoon1.setBackgroundResource(images[2]);
            }
        }, 3000);


        findViewById(R.id.but1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        but1 = (Button) findViewById(R.id.but1);
                        but1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                                startActivity(intent);
                            }
                        });
                    }
                });}
/*
    findViewById(R.id.but2).setOnClickListener(
                new Button.OnClickListener() {
        public void onClick(View v) {
            but2 = (Button) findViewById(R.id.but2);
            but2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View rootView = getWindow().getDecorView();

                    File screenShot = ScreenShot(rootView);
                    if(screenShot!=null){
                        //갤러리에 추가
                        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(screenShot)));
                    }


                }
            });
        }
    });}
    */

        //캡쳐버튼클릭
        public void mOnCaptureClick(View v){
            //전체화면
            View rootView = getWindow().getDecorView();
            File screenShot = ScreenShot(rootView);
            if(screenShot!=null){
                //갤러리에 추가
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(screenShot)));
            }
        }

    //화면 캡쳐하기
    public File ScreenShot(View view){
        view.setDrawingCacheEnabled(true);  //화면에 뿌릴때 캐시를 사용하게 한다

        Bitmap screenBitmap = view.getDrawingCache();   //캐시를 비트맵으로 변환

        String filename = "screenshot.png";
        File file = new File(Environment.getExternalStorageDirectory()+"/Pictures", filename);  //Pictures폴더 screenshot.png 파일
        FileOutputStream os = null;
        try{
            os = new FileOutputStream(file);
            screenBitmap.compress(Bitmap.CompressFormat.PNG, 90, os);   //비트맵을 PNG파일로 변환
            os.close();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

        view.setDrawingCacheEnabled(false);
        return file;
    }





/*
        findViewById(R.id.cartoon1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if(v.getId() ==R.id.cartoon1) {
                            cartoon1 = (ImageView) findViewById(R.id.cartoon1);
                            cartoon1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  cartoon1.setVisibility(View.GONE);
                                    cartoon2.setVisibility(View.VISIBLE);
                                }
                            });
                        }
                    }
                });
                */
/*
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.v("result",object.toString());
                    }
                });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.e("LoginErr",error.toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
*/
}


