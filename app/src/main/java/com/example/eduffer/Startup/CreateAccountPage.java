package com.example.eduffer.Startup;

import android.app.DatePickerDialog;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateAccountPage extends AppCompatActivity {
    private Button nextbutton;
    private EditText name, dob , age , university , emailid, mobno, country ,  state, city, zipcode;
    private ProgressBar progressBar;
    private FirebaseAuth fAuth;
    final Calendar myCalendar= Calendar.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_page);

        name = findViewById(R.id.createaccount_name);
        dob = findViewById(R.id.createaccount_dob);
        age = findViewById(R.id.createaccount_age);
        university = findViewById(R.id.createaccount_universityname);
        emailid = findViewById(R.id.createaccount_emiailid);
        mobno = findViewById(R.id.createaccount_mobno);
        country = findViewById(R.id.createaccount_country);
        state = findViewById(R.id.createaccount_state);
        city = findViewById(R.id.createaccount_city);
        zipcode = findViewById(R.id.createaccount_pincode);
        progressBar = findViewById(R.id.createaccount_progressBar);

        fAuth = FirebaseAuth.getInstance();

        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,month);
            myCalendar.set(Calendar.DAY_OF_MONTH,day);
            String myFormat="MM/dd/yy";
            SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
            dob.setText(dateFormat.format(myCalendar.getTime()));
        };

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CreateAccountPage.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        nextbutton = findViewById(R.id.createaccount_next);

        nextbutton.setOnClickListener(V -> {

            nextbutton.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);

            if (name.getText().toString().equals("")) {
                name.setError("Error , Field Cannot Be Empty");
                progressBar.setVisibility(View.INVISIBLE);
                nextbutton.setVisibility(View.VISIBLE);
                return;
            }

            if (dob.getText().toString().equals("")) {
                dob.setError("Error , Field Cannot Be Empty");
                progressBar.setVisibility(View.INVISIBLE);
                nextbutton.setVisibility(View.VISIBLE);
                return;
            }

            if (age.getText().toString().equals("")) {
                age.setError("Error , Field Cannot Be Empty");
                progressBar.setVisibility(View.INVISIBLE);
                nextbutton.setVisibility(View.VISIBLE);
                return;
            }

            if(university.getText().toString().equals("")){
                university.setError("Error , Field Cannot Be Empty");
                progressBar.setVisibility(View.INVISIBLE);
                nextbutton.setVisibility(View.VISIBLE);
                return;
            }

            if (emailid.getText().toString().equals("")) {
                emailid.setError("Error , Field Cannot Be Empty");
                progressBar.setVisibility(View.INVISIBLE);
                nextbutton.setVisibility(View.VISIBLE);
                return;
            }

            if (!emailid.getText().toString().endsWith(".edu"))
                if (!emailid.getText().toString().endsWith(".ac.in")) {
                    emailid.setError("Error , Enter Student Email ID");
                    progressBar.setVisibility(View.INVISIBLE);
                    nextbutton.setVisibility(View.VISIBLE);
                    return;
                }

            if (mobno.getText().toString().equals("")) {
                mobno.setError("Error , Field Cannot Be Empty");
                progressBar.setVisibility(View.INVISIBLE);
                nextbutton.setVisibility(View.VISIBLE);
                return;
            }

            if (country.getText().toString().equals("")) {
                country.setError("Error , Field Cannot Be Empty");
                progressBar.setVisibility(View.INVISIBLE);
                nextbutton.setVisibility(View.VISIBLE);
                return;
            }

            if (state.getText().toString().equals("")) {
                state.setError("Error , Field Cannot Be Empty");
                progressBar.setVisibility(View.INVISIBLE);
                nextbutton.setVisibility(View.VISIBLE);
                return;
            }

            if (city.getText().toString().equals("")) {
                city.setError("Error , Field Cannot Be Empty");
                progressBar.setVisibility(View.INVISIBLE);
                nextbutton.setVisibility(View.VISIBLE);
                return;
            }

            if (zipcode.getText().toString().equals("")) {
                zipcode.setError("Error , Field Cannot Be Empty");
                progressBar.setVisibility(View.INVISIBLE);
                nextbutton.setVisibility(View.VISIBLE);
                return;
            }
            else
                {
                String email = emailid.getText().toString();
                String uname = name.getText().toString();
                String udob = dob.getText().toString();
                String uage = age.getText().toString();
                String uuniversity = university.getText().toString();
                String mob = mobno.getText().toString();
                String ucountry = country.getText().toString();
                String ustate = state.getText().toString();
                String ucity = city.getText().toString();
                String uzipcode = zipcode.getText().toString();

                fAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener(task -> {

                    Log.d("TAG", "");
                        if (task.getResult().getSignInMethods().size() == 0) {
                            Intent intent = new Intent(getApplicationContext(), NewPwdPage.class);
                            intent.putExtra("EMAIL_ID", email);
                            intent.putExtra("NAME", uname);
                            intent.putExtra("DOB" , udob);
                            intent.putExtra("UNIVERSITY" , uuniversity);
                            intent.putExtra("AGE" , uage);
                            intent.putExtra("MOB", mob);
                            intent.putExtra("COUNTRY" , ucountry);
                            intent.putExtra("STATE", ustate);
                            intent.putExtra("CITY", ucity);
                            intent.putExtra("ZIPCODE", uzipcode);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email ID Already Exists", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), LoginPage.class));
                            finish();
                        }

                });
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