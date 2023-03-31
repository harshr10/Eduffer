package com.example.eduffer.Startup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eduffer.FirebaseService;
import com.example.eduffer.R;
import com.google.firebase.auth.FirebaseAuth;

public class VerifyLoginPage extends AppCompatActivity {

    private Button loginbutton;
    private TextView createaccount, fgtpwd;
    private FirebaseAuth fAuth;
    private ProgressBar progressBar;
    private EditText emailid, password;
    private String name;
    String userID;

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fAuth = FirebaseAuth.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        setContentView(R.layout.activity_verify_login_page);

        MyResultReceiver myReceiver = new MyResultReceiver(null);
        Intent intent = new Intent(getApplicationContext() , FirebaseService.class);
        intent.putExtra("UID" , userID);
        intent.putExtra("ResRec" , myReceiver);
        intent.putExtra("info" , "basic");
        startService(intent);

        emailid = findViewById(R.id.verify_emailid);
        password = findViewById(R.id.verify_pwd);
        loginbutton = findViewById(R.id.verify_loginbutton);
        createaccount = findViewById(R.id.verify_createaccount);
        fgtpwd = findViewById(R.id.verify_fgtpwd);
        progressBar = findViewById(R.id.verify_progressBar);

        loginbutton.setOnClickListener(v -> openactivityhomepage());

        createaccount.setOnClickListener(v -> openactivitycreateaccount());

        fgtpwd.setOnClickListener(v -> openactivityfgtpwd());
    }

    public void openactivityfgtpwd() {
        Intent intent = new Intent(this, ForgotPwdPage.class);
        startActivity(intent);
    }

    public void openactivitycreateaccount() {
        Intent intent = new Intent(this, CreateAccountPage.class);
        startActivity(intent);
    }

    public void openactivityhomepage() {

        String email = emailid.getText().toString().trim();
        String pwd = password.getText().toString().trim();

        try {
            loginbutton.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);

            fAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    if (fAuth.getCurrentUser().isEmailVerified()) {
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Main_Home_Activity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please Verify Your Email ID", Toast.LENGTH_SHORT).show();
                        loginbutton.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Error!! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    loginbutton.setVisibility(View.VISIBLE);
                    return;
                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error!! , Enter Correct Login Details", Toast.LENGTH_SHORT).show();
            loginbutton.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    private class MyResultReceiver extends ResultReceiver {

        public MyResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if(resultCode == 1 && resultData != null)
            {
                name = resultData.getString("name");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Welcome " + name, Toast.LENGTH_LONG).show();
                    }
                });

            }
        }
    }
}
