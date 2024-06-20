package com.example.gymtrainer;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

//attendence
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private static final String TAG = "MainActivity";

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private static final int REQUEST_USAGE_STATS_PERMISSION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.abs, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.reflexwhey,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.teenfemale,ScaleTypes.FIT));


        ImageSlider imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);





        Button aboveb = findViewById(R.id.aboveb);
        Button belowb = findViewById(R.id.belowb);
        Button bdiet = findViewById(R.id.bdiet);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        aboveb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(MainActivity.this, AboveActivity.class);
                startActivity(intent);
            }
        });

        belowb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(MainActivity.this, PainsActivity.class);
                startActivity(intent);
            }
        });
        bdiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(MainActivity.this, Diet.class);
                startActivity(intent);
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        captureAttendance();

        if (checkUsageStatsPermission()) {
            // Permission already granted, proceed with your logic
            captureAttendance();
        } else {
            // Request permission from the user
            requestUsageStatsPermission();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Log.d("NavigationItemSelected", "Item ID: " + id);

        if (id == R.id.nav_home) {
            // Handle the home action
            Intent intent = new Intent(MainActivity.this, Calorie.class);
            startActivity(intent);
            Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            // Handle the gallery action
            Intent intent = new Intent(MainActivity.this, Payments.class);
            startActivity(intent);
            Toast.makeText(this, "Gallery Clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            // Handle the slideshow action
            Intent intent = new Intent(MainActivity.this, AttendanceActivity.class);
            startActivity(intent);
            // Toast.makeText(this, "Slideshow Clicked", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_book) {
            // Handle the slideshow action
            Intent intent = new Intent(MainActivity.this, Booking.class);
            startActivity(intent);
            // Toast.makeText(this, "book Clicked", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_chat) {
            // Handle the slideshow action
            Intent intent = new Intent(MainActivity.this, Chatbot.class);
            startActivity(intent);
            // Toast.makeText(this, "book Clicked", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_showbook) {
            // Handle the slideshow action
            Intent intent = new Intent(MainActivity.this, UserItemsActivity.class);
            startActivity(intent);
            // Toast.makeText(this, "book Clicked", Toast.LENGTH_SHORT).show();
        }

        // Close the navigation drawer
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void captureAttendance() {
        if (!isAppOpenedToday()) {
            markAttendanceAsAbsent();
        }
        else {
            markAttendanceAsPresent();
        }
    }

    private boolean isAppOpenedToday() {
        long endTime = System.currentTimeMillis();
        long startTime = endTime - TimeUnit.DAYS.toMillis(1);

        UsageStatsManager usageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        if (usageStatsManager != null) {
            List<UsageStats> appUsageStats = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startTime, endTime);
            for (UsageStats usageStats : appUsageStats) {
                if (usageStats.getPackageName().equals(getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void markAttendanceAsAbsent() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String currentDate = dateFormat.format(new Date());

            mDatabase.child("attendance").child(currentUser.getUid()).child(currentDate).setValue("Absent");
        }
    }
    private void markAttendanceAsPresent() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String currentDate = dateFormat.format(new Date());

            mDatabase.child("attendance").child(currentUser.getUid()).child(currentDate).setValue("Present");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        captureAttendance();
    }

    private boolean checkUsageStatsPermission() {
        AppOpsManager appOps = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, android.os.Process.myUid(), getPackageName());
        return mode == AppOpsManager.MODE_ALLOWED;
    }

    private void requestUsageStatsPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            startActivityForResult(intent, REQUEST_USAGE_STATS_PERMISSION);
        } else {
            // Device does not support UsageStats API
            Toast.makeText(this, "UsageStats API is not supported on this device", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_USAGE_STATS_PERMISSION) {
            if (checkUsageStatsPermission()) {
                // Permission granted by the user
                captureAttendance();
            } else {
                // Permission denied by the user
                Toast.makeText(this, "Usage stats permission is required for attendance tracking", Toast.LENGTH_SHORT).show();
                // Handle the scenario where permission is denied
            }
        }
    }

}
