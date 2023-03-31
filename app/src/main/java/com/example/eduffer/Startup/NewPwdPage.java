package com.example.eduffer.Startup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eduffer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NewPwdPage extends AppCompatActivity {

    private Button submitbutton;
    private EditText newpwd, reenterpwd;
    private FirebaseAuth fAuth;
    private ProgressBar progressBar;
    private FirebaseFirestore fStore;
    private String userID;

    @SuppressLint("CommitTransaction")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pwd_page);

        newpwd = findViewById(R.id.newpwd_pwd);
        reenterpwd = findViewById(R.id.newpwd_re_enterpwd);
        progressBar = findViewById(R.id.newpwd_progressBar);
        submitbutton = findViewById(R.id.newpwd_submit);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        submitbutton.setOnClickListener(v -> {

            submitbutton.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);

            if (!newpwd.getText().toString().equals(reenterpwd.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Error , Passwords Don't Match Re Enter Password", Toast.LENGTH_LONG).show();
                newpwd.getText().clear();
                reenterpwd.getText().clear();
                submitbutton.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                return;
            }

            if (newpwd.getText().toString().equals("") && reenterpwd.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Error , Re Enter Password", Toast.LENGTH_LONG).show();
                newpwd.getText().clear();
                reenterpwd.getText().clear();
                submitbutton.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                return;
            }

            if (newpwd.getText().toString().length() < 8 && reenterpwd.getText().toString().length() < 8) {
                Toast.makeText(getApplicationContext(), "Error , Password Length Less Than 8 Characters", Toast.LENGTH_LONG).show();
                newpwd.getText().clear();
                reenterpwd.getText().clear();
                submitbutton.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                return;
            }

            Bundle extras = getIntent().getExtras();
            String email = extras.getString("EMAIL_ID");
            String name = extras.getString("NAME");
            String dob = extras.getString("DOB");
            String age = extras.getString("AGE");
            String university = extras.getString("UNIVERSITY");
            String mob = extras.getString("MOB");
            String country = extras.getString("COUNTRY");
            String state = extras.getString("STATE");
            String city = extras.getString("CITY");
            String zipcode = extras.getString("ZIPCODE");
            String password = newpwd.getText().toString();

            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    userID = fAuth.getCurrentUser().getUid();
                    DocumentReference docref = fStore.collection("USER PROFILE").document(userID);
                    Map<String, Object> user = new HashMap<>();
                    user.put("NAME", name);
                    user.put("DOB", dob);
                    user.put("AGE", age);
                    user.put("UNIVERSITY", university);
                    user.put("EMAIL ID", email);
                    user.put("MOBILE NO", mob);
                    user.put("COUNTRY", country);
                    user.put("STATE", state);
                    user.put("CITY", city);
                    user.put("ZIPCODE", zipcode);
                    docref.set(user).addOnSuccessListener(unused -> {
                        Log.d("TAG", "Success");
                    });

                    DocumentReference docrefr = fStore.collection("UNIVERSITY DETAILS").document(userID);
                    Map<String, Object> uni = new HashMap<>();
                    uni.put("UNIVERSITY", university);
                    uni.put("DEPARTMENT", "");
                    uni.put("YEAR", "");
                    uni.put("EMAIL ID", email);
                    uni.put("REGISTRATION NUMBER", "");
                    uni.put("COUNTRY", "");
                    uni.put("CITY", "");
                    uni.put("STATE", "");
                    docrefr.set(uni).addOnSuccessListener(unused -> {
                        Log.d("TAG", "Success");
                    });

                    fAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(task1 -> {
                        if (task1.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "New Account Created , Check Mail For Verification Link", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), VerifyLoginPage.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), task1.getException().getMessage(), Toast.LENGTH_LONG).show();
                            submitbutton.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                            return;
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Error!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    submitbutton.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });
        });
    }
}
