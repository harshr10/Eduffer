package com.example.eduffer;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseService extends Service {

    private String uname, udob, uage, uuniversity ,  uemailid, umob, ucountry, ustate, ucity, upincode;

    private String udept, uyear, uregno, unicountry, unistate, unicity;

    public FirebaseService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String id = intent.getStringExtra("UID");
        String info = intent.getStringExtra("info");
        ResultReceiver resultReciever = intent.getParcelableExtra("ResRec");

        FirebaseAuth fAuth;
        FirebaseFirestore fStore;

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if(info.equals("uni")) {
            DocumentReference docref = fStore.collection("UNIVERSITY DETAILS").document(id);
            docref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot doc = task.getResult();
                        if (doc.exists()) {
                            uuniversity = doc.getString("UNIVERSITY");
                            uemailid = doc.getString("EMAIL ID");
                            udept = doc.getString("DEPARTMENT");
                            uyear = doc.getString("YEAR");
                            uregno = doc.getString("REGISTRATION NUMBER");
                            unicountry = doc.getString("COUNTRY");
                            unistate = doc.getString("STATE");
                            unicity = doc.getString("CITY");

                            Bundle bundle = new Bundle();
                            bundle.putSerializable("university", uuniversity);
                            bundle.putSerializable("emailid", uemailid);
                            bundle.putSerializable("dept", udept);
                            bundle.putSerializable("year", uyear);
                            bundle.putSerializable("regno", uregno);
                            bundle.putSerializable("country" , unicountry);
                            bundle.putSerializable("state", unistate);
                            bundle.putSerializable("city", unicity);
                            resultReciever.send(1, bundle);
                        }
                    }
                }
            });
        }
        else if (info.equals("basic")){
            DocumentReference docref = fStore.collection("USER PROFILE").document(id);
            docref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot doc = task.getResult();
                        if (doc.exists()) {
                            uname = doc.getString("NAME");
                            udob = doc.getString("DOB");
                            uage = doc.getString("AGE");
                            uuniversity = doc.getString("UNIVERSITY");
                            uemailid = doc.getString("EMAIL ID");
                            umob = doc.getString("MOBILE NO");
                            ucountry = doc.getString("COUNTRY");
                            ustate = doc.getString("STATE");
                            ucity = doc.getString("CITY");
                            upincode = doc.getString("ZIPCODE");

                            Bundle bundle = new Bundle();
                            bundle.putSerializable("name", uname);
                            bundle.putSerializable("dob", udob);
                            bundle.putSerializable("age", uage);
                            bundle.putSerializable("university", uuniversity);
                            bundle.putSerializable("emailid", uemailid);
                            bundle.putSerializable("mob", umob);
                            bundle.putSerializable("country", ucountry);
                            bundle.putSerializable("state", ustate);
                            bundle.putSerializable("city", ucity);
                            bundle.putSerializable("pincode", upincode);
                            resultReciever.send(1, bundle);

                        }
                    }
                }
            });
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}