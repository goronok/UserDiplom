package com.example.goron.userdiplom;

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
import android.widget.FrameLayout;

import com.example.goron.userdiplom.Fragments.MenuFragment;

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

        menuFragment = MenuFragment.newInstance(name, password);
        showFragment(menuFragment);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
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
            finish();
        }else {
            getSupportFragmentManager().popBackStack();
        }

    }
}
