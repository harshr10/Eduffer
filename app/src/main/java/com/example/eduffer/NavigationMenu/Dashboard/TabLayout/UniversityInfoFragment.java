package com.example.eduffer.NavigationMenu.Dashboard.TabLayout;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.eduffer.FirebaseService;
import com.example.eduffer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UniversityInfoFragment extends Fragment {

    private String uuniversityname, udept, uyear, uregno, ucountry, ustate, ucity, uemailid;

    private EditText universityname, dept, year, regno, country, state, city , emailid;

    private final Handler handler = new Handler();

    private ProgressBar progloading;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_university_info, container, false);

        Button edit, submit;

        FirebaseAuth fAuth;
        FirebaseFirestore fStore;
        String userID;

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();

        MyResultReceiver myReceiver = new MyResultReceiver(null);
        Intent intent = new Intent(getActivity(), FirebaseService.class);
        intent.putExtra("UID", userID);
        intent.putExtra("ResRec", myReceiver);
        intent.putExtra("info", "uni");
        requireActivity().startService(intent);


        universityname = view.findViewById(R.id.universityinfo_univeritysname);
        dept = view.findViewById(R.id.universityinfo_dept);
        year = view.findViewById(R.id.universityinfo_year);
        regno = view.findViewById(R.id.universityinfo_regno);
        emailid = view.findViewById(R.id.universityinfo_emailid);
        country = view.findViewById(R.id.universityinfo_country);
        state = view.findViewById(R.id.universityinfo_state);
        city = view.findViewById(R.id.universityinfo_city);
        edit = view.findViewById(R.id.universityinfo_edit);
        submit = view.findViewById(R.id.universityinfo_submit);
        progloading = view.findViewById(R.id.progressBarLaoding);
        progloading.setVisibility(View.INVISIBLE);

        edit.setOnClickListener(view1 -> {

            edit.setVisibility(View.INVISIBLE);
            submit.setVisibility(View.VISIBLE);

            universityname.setEnabled(true);
            dept.setEnabled(true);
            year.setEnabled(true);
            regno.setEnabled(true);
            country.setEnabled(true);
            state.setEnabled(true);
            city.setEnabled(true);
        });

        submit.setOnClickListener(view1 -> {

            progloading.setVisibility(View.VISIBLE);

            uuniversityname = universityname.getText().toString();
            udept = dept.getText().toString();
            uyear = year.getText().toString();
            uemailid = emailid.getText().toString();
            uregno = regno.getText().toString();
            ucountry = country.getText().toString();
            ustate = state.getText().toString();
            ucity = city.getText().toString();

            try {
                fAuth.getCurrentUser().updateEmail(uemailid).addOnCompleteListener(task1 -> {
                    if (task1.isSuccessful()) {
                        DocumentReference docref = fStore.collection("USER PROFILE").document(userID);
                        Map<String, Object> edited = new HashMap<>();
                        edited.put("UNIVERSITY", uuniversityname);
                        docref.update(edited);

                        Toast.makeText(getContext(), "USER PROFILE UPDATED", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), " USER PROFILE NOT UPDATED ", Toast.LENGTH_SHORT).show();
                    }
                });

                fAuth.getCurrentUser().updateEmail(uemailid).addOnCompleteListener(task2 -> {
                    if (task2.isSuccessful()) {
                        DocumentReference docrefr = fStore.collection("UNIVERSITY DETAILS").document(userID);
                        Map<String, Object> user = new HashMap<>();
                        user.put("UNIVERSITY", uuniversityname);
                        user.put("DEPARTMENT", udept);
                        user.put("YEAR", uyear);
                        user.put("EMAIL ID", uemailid);
                        user.put("REGISTRATION NUMBER", uregno);
                        user.put("COUNTRY", ucountry);
                        user.put("STATE", ustate);
                        user.put("CITY", ucity);
                        docrefr.update(user);
                        progloading.setVisibility(View.INVISIBLE);

                        Toast.makeText(getContext(), "UNIVERSITY DETAILS UPDATED", Toast.LENGTH_LONG).show();

                    } else {
                        progloading.setVisibility(View.INVISIBLE);
                        Toast.makeText(getContext(), "UNIVERSITY DETAILS NOT UPDATED", Toast.LENGTH_LONG).show();
                    }
                });
            }
            catch (Exception e ){
                Toast.makeText(getContext() , e.getMessage() , Toast.LENGTH_LONG).show();
            }
            edit.setVisibility(View.VISIBLE);
            submit.setVisibility(View.INVISIBLE);

            universityname.setEnabled(false);
            dept.setEnabled(false);
            year.setEnabled(false);
            regno.setEnabled(false);
            country.setEnabled(false);
            state.setEnabled(false);
            city.setEnabled(false);
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

            universityname = getActivity().findViewById(R.id.universityinfo_univeritysname);
            dept = getActivity().findViewById(R.id.universityinfo_dept);
            year = getActivity().findViewById(R.id.universityinfo_year);
            emailid = getActivity().findViewById(R.id.universityinfo_emailid);
            regno = getActivity().findViewById(R.id.universityinfo_regno);
            country = getActivity().findViewById(R.id.universityinfo_country);
            state = getActivity().findViewById(R.id.universityinfo_state);
            city = getActivity().findViewById(R.id.universityinfo_city);

            if(resultCode == 1 && resultData != null){

                uuniversityname = resultData.getString("university");
                uemailid = resultData.getString("emailid");
                udept = resultData.getString("dept");
                uyear = resultData.getString("year");
                uregno = resultData.getString("regno");
                ucountry = resultData.getString("country");
                ustate = resultData.getString("state");
                ucity = resultData.getString("city");

                handler.post(() -> {
                    universityname.setText(uuniversityname);
                    dept.setText(udept);
                    year.setText(uyear);
                    emailid.setText(uemailid);
                    regno.setText(uregno);
                    country.setText(ucountry);
                    state.setText(ustate);
                    city.setText(ucity);
                });
            }
        }
    }
}