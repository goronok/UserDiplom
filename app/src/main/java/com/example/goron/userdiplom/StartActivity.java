package com.example.goron.userdiplom;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.goron.userdiplom.Fragments.ActivityFragment;
import com.example.goron.userdiplom.Fragments.MenuFragment;
import com.example.goron.userdiplom.Fragments.MyQueueFragment;
import com.example.goron.userdiplom.Fragments.ScheduleFragment;

public class StartActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ViewPager viewpager;


    MenuFragment menuFragment;

    String name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);




        // Инициализируем элементы:
        frameLayout = findViewById(R.id.content_frame);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolBar);
        navigationView = findViewById(R.id.navView);
        viewpager = findViewById(R.id.viewpager);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));



        Bundle arguments = getIntent().getExtras();
        name = arguments.get("name").toString();
        password = arguments.get("password").toString();




        drawerLayout.addDrawerListener(toggle);


        toggle.syncState();

        // Переход по NavigationView
        navigationMenu();


        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE || getSupportFragmentManager().getBackStackEntryCount() > 1) {
            // If the screen is now in landscape mode, we can show the
            // dialog in-line with the list so we don't need this activity.

            return;
        } else {
            Toast.makeText(getApplicationContext(), "Добро пожаловать", Toast.LENGTH_LONG).show();
            menuFragment = MenuFragment.newInstance();
            showFragment(menuFragment);
        }


    }


    private void showFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment).addToBackStack(null).commit();
    }//showFragment


    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();


        // Если открыто боковое меню - закрываем его, Если в стеке последний фрагмент закрываем активность иначе возвращаемся к предыдущему фрагменту
        if (drawerLayout.isDrawerOpen(GravityCompat.START))  drawerLayout.closeDrawer(GravityCompat.START);
        else if (count == 1) {
           // super.onBackPressed();
            moveTaskToBack(true);

        }else {
            getSupportFragmentManager().popBackStack();
        }

    }


    // Переход по NavigationView
    private void navigationMenu() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                Intent intent;
                switch (id) {


                    case R.id.activitys:
                        showFragment(ActivityFragment.newInstance());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.settings:

                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.schedule:
                        showFragment(ScheduleFragment.newInstance());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.exit:

                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("CloseApp", true);
                        startActivity(intent);

                        break;


                    case R.id.myqueues:
                        showFragment(MyQueueFragment.newInstance());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return false;
            }
        });
    }
}
