package com.example.eduffer.Startup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.eduffer.FirebaseService;
import com.example.eduffer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class FlashScreen extends AppCompatActivity {

    private String uname;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    TextView welcome;

    private final Handler handler = new Handler();

    private static final int SPLASH_SCREEN_TIME_OUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flash_screen);

        ConstraintLayout constraintLayout = findViewById(R.id.flashscreen);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.start();

        ImageView image = findViewById(R.id.edufferlogo);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null)
        {
            userID = fAuth.getCurrentUser().getUid();
            MyResultReceiver myReceiver = new MyResultReceiver(null);
            Intent intent = new Intent(getApplicationContext() , FirebaseService.class);
            intent.putExtra("UID" , userID);
            intent.putExtra("ResRec" , myReceiver);
            intent.putExtra("info" , "basic");
            startService(intent);
        }
        else
        {
            welcome = findViewById(R.id.Welcome);
            welcome.setText("Welcome");
            Animation animation2 =
                    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
            welcome.startAnimation(animation2);
        }

        new Handler().postDelayed(() -> {
            Intent i=new Intent(FlashScreen.this, LoginPage.class);
            startActivity(i);
            finish();
        }, SPLASH_SCREEN_TIME_OUT);
    }
    private class MyResultReceiver extends ResultReceiver {

        public MyResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            welcome = findViewById(R.id.Welcome);
            if(resultCode == 1 && resultData != null)
            {
                uname = resultData.getString("name");
                handler.post(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        welcome.setText("Welcome " + uname);
                        Animation animation2 =
                                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
                        welcome.startAnimation(animation2);
                    }
                });

            }
        }
    }
}