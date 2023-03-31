package com.example.eduffer.NavigationMenu.Dashboard.TabLayout;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.eduffer.FirebaseService;
import com.example.eduffer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BasicInfoFragment extends Fragment {

    private String uname, udob, uage, uemailid, umob, ucountry, ustate, ucity, upincode;

    private EditText name, dob, age, emailid, mob, country, state, city, pincode;

    private final Handler handler = new Handler();

    final Calendar myCalendar= Calendar.getInstance();

    private TextView loading;

    private ProgressBar progloading;

    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;
    private String userID;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_basic_info, container, false);

        Button edit, submit;

        name = view.findViewById(R.id.basicinfo_name);
        dob = view.findViewById(R.id.basicinfo_dob);
        age = view.findViewById(R.id.basicinfo_age);
        emailid = view.findViewById(R.id.basicinfo_emailid);
        mob = view.findViewById(R.id.basicinfo_mob);
        country = view.findViewById(R.id.basicinfo_country);
        state = view.findViewById(R.id.basicinfo_state);
        city = view.findViewById(R.id.basicinfo_city);
        pincode = view.findViewById(R.id.basicinfo_pincode);

        edit = view.findViewById(R.id.basicinfo_edit);
        submit = view.findViewById(R.id.basicinfo_submit);
        loading = view.findViewById(R.id.Loading);
        progloading = view.findViewById(R.id.progressBarLaoding);

        name.setVisibility(View.INVISIBLE);
        dob.setVisibility(View.INVISIBLE);
        age.setVisibility(View.INVISIBLE);
        emailid.setVisibility(View.INVISIBLE);
        mob.setVisibility(View.INVISIBLE);
        country.setVisibility(View.INVISIBLE);
        state.setVisibility(View.INVISIBLE);
        city.setVisibility(View.INVISIBLE);
        pincode.setVisibility(View.INVISIBLE);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();

        MyResultReceiver myReceiver = new MyResultReceiver(null);
        Intent intent = new Intent(getActivity(), FirebaseService.class);
        intent.putExtra("UID", userID);
        intent.putExtra("ResRec", myReceiver);
        intent.putExtra("info" , "basic");
        requireActivity().startService(intent);

        edit.setOnClickListener(view1 -> {

            edit.setVisibility(View.INVISIBLE);
            submit.setVisibility(View.VISIBLE);

            name.setEnabled(true);
            dob.setClickable(true);

            DatePickerDialog.OnDateSetListener date = (view2, year, month, day) -> {
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
                    new DatePickerDialog(getContext(),date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });
            age.setEnabled(true);
            mob.setEnabled(true);
            country.setEnabled(true);
            state.setEnabled(true);
            city.setEnabled(true);
            pincode.setEnabled(true);
        });

        submit.setOnClickListener(view1 -> {

            progloading.setVisibility(View.VISIBLE);

            uname = name.getText().toString();
            uemailid = emailid.getText().toString();
            udob = dob.getText().toString();
            uage = age.getText().toString();
            umob = mob.getText().toString();
            ucountry = country.getText().toString();
            ustate = state.getText().toString();
            ucity = city.getText().toString();
            upincode = pincode.getText().toString();

            try {
                fAuth.getCurrentUser().updateEmail(uemailid).addOnCompleteListener(task1 -> {
                    if (task1.isSuccessful()) {
                        DocumentReference docrefr = fStore.collection("USER PROFILE").document(userID);
                        Map<String, Object> edited = new HashMap<>();
                        edited.put("NAME", uname);
                        edited.put("DOB", udob);
                        edited.put("AGE", uage);
                        edited.put("EMAIL ID", uemailid);
                        edited.put("MOBILE NO", umob);
                        edited.put("COUNTRY", ucountry);
                        edited.put("STATE" , ustate);
                        edited.put("CITY", ucity);
                        edited.put("ZIPCODE", upincode);
                        docrefr.update(edited);
                        Toast.makeText(getContext(), "PROFILE UPDATED", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getContext(), "PROFILE NOT UPDATED", Toast.LENGTH_LONG).show();
                    }

                    edit.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.INVISIBLE);

                    name.setEnabled(false);
                    dob.setEnabled(false);
                    mob.setEnabled(false);
                    country.setEnabled(false);
                    state.setEnabled(false);
                    city.setEnabled(false);
                    pincode.setEnabled(false);

                    progloading.setVisibility(View.INVISIBLE);
                });
            } catch (Exception e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    private class MyResultReceiver extends ResultReceiver {

        public MyResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);

            name = getActivity().findViewById(R.id.basicinfo_name);
            dob = getActivity().findViewById(R.id.basicinfo_dob);
            age = getActivity().findViewById(R.id.basicinfo_age);
            emailid = getActivity().findViewById(R.id.basicinfo_emailid);
            mob = getActivity().findViewById(R.id.basicinfo_mob);
            country = getActivity().findViewById(R.id.basicinfo_country);
            state = getActivity().findViewById(R.id.basicinfo_state);
            city = getActivity().findViewById(R.id.basicinfo_city);
            pincode = getActivity().findViewById(R.id.basicinfo_pincode);
            loading = getActivity().findViewById(R.id.Loading);
            progloading = getActivity().findViewById(R.id.progressBarLaoding);

            if (resultCode == 1 && resultData != null) {

                uname = resultData.getString("name");
                uemailid = resultData.getString("emailid");
                udob = resultData.getString("dob");
                uage = resultData.getString("age");
                umob = resultData.getString("mob");
                ucountry = resultData.getString("country");
                ustate = resultData.getString("state");
                ucity = resultData.getString("city");
                upincode = resultData.getString("pincode");

                handler.post(() -> {
                    name.setText(uname);
                    emailid.setText(uemailid);
                    dob.setText(udob);
                    age.setText(uage);
                    mob.setText(umob);
                    country.setText(ucountry);
                    state.setText(ustate);
                    city.setText(ucity);
                    pincode.setText(upincode);

                    name.setVisibility(View.VISIBLE);
                    dob.setVisibility(View.VISIBLE);
                    age.setVisibility(View.VISIBLE);
                    emailid.setVisibility(View.VISIBLE);
                    mob.setVisibility(View.VISIBLE);
                    country.setVisibility(View.VISIBLE);
                    state.setVisibility(View.VISIBLE);
                    city.setVisibility(View.VISIBLE);
                    pincode.setVisibility(View.VISIBLE);
                    loading.setVisibility(View.INVISIBLE);
                    progloading.setVisibility(View.INVISIBLE);
                });

            }
        }
    }
}
