package com.example.eduffer.Startup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eduffer.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    private Button loginbutton;
    private TextView createaccount , fgtpwd;
    private FirebaseAuth fAuth;
    private ProgressBar progressBar;
    private EditText emailid , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext() ,Main_Home_Activity.class));
            finish();
        }

        setContentView(R.layout.activity_login_page);

        emailid = findViewById(R.id.login_emailid);
        password = findViewById(R.id.login_pwd);
        loginbutton = findViewById(R.id.login_loginbutton);
        createaccount = findViewById(R.id.login_createaccount);
        fgtpwd = findViewById(R.id.login_fgtpwd);
        progressBar = findViewById(R.id.login_progressBar);

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

        loginbutton.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        try{
            fAuth.signInWithEmailAndPassword(email , pwd).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Main_Home_Activity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Error!! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    loginbutton.setVisibility(View.VISIBLE);
                    return;
                }
            });
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error!! , Enter Correct Login Details" , Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
            loginbutton.setVisibility(View.VISIBLE);
        }
    }
}