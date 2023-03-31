package com.example.eduffer.Startup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.eduffer.FirebaseService;
import com.example.eduffer.NavigationMenu.Dashboard.DashBoardFragment;
import com.example.eduffer.NavigationMenu.Home.HomeFragment;
import com.example.eduffer.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class Main_Home_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment fragment;
    private Toolbar toolbar;
    private ImageView logout;
    private TextView name;
    private String uname;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        logout = findViewById(R.id.logout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();

        MyResultReceiver myReceiver = new MyResultReceiver(null);
        Intent intent = new Intent(getApplicationContext() , FirebaseService.class);
        intent.putExtra("UID" , userID);
        intent.putExtra("ResRec" , myReceiver);
        intent.putExtra("info" , "basic");
        startService(intent);

        logout.setOnClickListener(view -> {
            fAuth.signOut();
            startActivity(new Intent(getApplicationContext() , LoginPage.class));
        });

    }

    private class MyResultReceiver extends ResultReceiver{

        public MyResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            name = findViewById(R.id.name_of_student);
            if(resultCode == 1 && resultData != null)
            {
                uname = resultData.getString("name");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        name.setText(uname);
                    }
                });

            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        FragmentTransaction fragreplace = getSupportFragmentManager().beginTransaction();
        switch (id)
        {
            case R.id.home:
            default:
                fragment = new HomeFragment();
                fragreplace.replace(R.id.fragmentContainerView , fragment);
                fragreplace.commit();
                break;
            case R.id.dashboard:
                fragment = new DashBoardFragment();
                fragreplace.replace(R.id.fragmentContainerView , fragment);
                fragreplace.commit();
                break;
            case R.id.share:
                Intent shareIntent =   new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Insert Subject here");
                String app_url = "https://play.google.com/store/apps/details?id=my.example.javatpoint";
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}