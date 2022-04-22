package com.example.covidteam9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.covidteam9.Login.LoginActivity;
import com.example.covidteam9.Login.LoginSession;
import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

   DrawerLayout drawerLayout;
    public static final String TAG = "MainActivity";
    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout)  getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        toggle.syncState();
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_toolbar));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(this, DashboardActivity.class);
                overridePendingTransition(0, 0);
                allocateActivityTitle("Home");
                startActivity(intent);
                break;
            case R.id.nav_profile:
                Intent intent2 = new Intent(this, ProfileActivity.class);
                overridePendingTransition(0, 0);
                allocateActivityTitle("Profile");
                startActivity(intent2);
                break;
            case R.id.nav_bookmark:
                Intent intent3 = new Intent(this, BookmarkActivity.class);
                overridePendingTransition(0, 0);
                allocateActivityTitle("Bookmark");
                startActivity(intent3);
                break;
            case R.id.nav_logout:
                LoginSession.getInstance().endUserSession(DrawerBaseActivity.this);
                openLoginActivity();
        }
        return true;
    }

    protected void allocateActivityTitle(String title){
        Log.e(TAG, "TITLE : " + getSupportActionBar());
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    protected void onResume() {
        boolean isAllowed = LoginSession.getInstance().isSessionActive(this, Calendar.getInstance().getTime());
        if (!isAllowed){
            openLoginActivity();
        }
        super.onResume();
    }

    private void openLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}