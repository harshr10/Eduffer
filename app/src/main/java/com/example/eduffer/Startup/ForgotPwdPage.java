package com.example.eduffer.Startup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eduffer.R;
import com.google.firebase.auth.FirebaseAuth;


public class ForgotPwdPage  extends AppCompatActivity {

    private Button sendveriflinkbutton;
    private EditText emailid;
    private FirebaseAuth fAuth;
    private ProgressBar progressBar;

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_fgt_pwd_page);

        emailid = findViewById(R.id.fgtpwd_emailid);
        sendveriflinkbutton = findViewById(R.id.fgtpwd_sendveriflink);
        progressBar = findViewById(R.id.fgtpwd_progressBar);

        fAuth = FirebaseAuth.getInstance();

        sendveriflinkbutton.setOnClickListener(view -> {

            try {
                String email = emailid.getText().toString();

                sendveriflinkbutton.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                fAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener(task -> {
                    if (task.getResult().getSignInMethods().size() != 0)
                    {
                            fAuth.sendPasswordResetEmail(email).addOnCompleteListener(task1 -> {
                                if (task1.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Check Mail For Password Reset Link", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(), LoginPage.class));
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), task1.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    sendveriflinkbutton.setVisibility(View.VISIBLE);
                                    progressBar.setVisibility(View.INVISIBLE);
                                    return;
                                }
                            });
                        }
                        else {
                        Toast.makeText(getApplicationContext(), "Email ID Does Not Exist", Toast.LENGTH_LONG).show();
                        sendveriflinkbutton.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Enter Email ID", Toast.LENGTH_LONG).show();
                sendveriflinkbutton.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }
}
