package com.Karnataka.KA;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.Karnataka.R;


public class NavigationDrawerBaseActivity extends AppCompatActivity {
    public TextView appBarTxt;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private float lastTranslate = 0.0f;
    private ImageView imgLeftToolbar;
    private boolean isOpenOrClose = false;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layout) {
        View parentView = LayoutInflater.from(NavigationDrawerBaseActivity.this).inflate(R.layout.activity_main, null);
        FrameLayout frame = (FrameLayout) parentView.findViewById(R.id.frame);
        getLayoutInflater().inflate(layout, frame, true);
        super.setContentView(parentView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarTxt = (TextView) findViewById(R.id.app_bar_txt);
        imgLeftToolbar = (ImageView) findViewById(R.id.img_left_toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setUpNavigationView();
        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer) {
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (drawerView.getWidth() * slideOffset);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    findViewById(R.id.app_bar_main_layout).setTranslationX(moveFactor);
                } else {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    findViewById(R.id.app_bar_main_layout).startAnimation(anim);
                    lastTranslate = moveFactor;
                }
            }
        };










        drawer.setDrawerListener(drawerToggle);

        imgLeftToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ha","onclick triggered");
                if (isOpenOrClose)
                    drawer.closeDrawers();
                else
                    drawer.openDrawer(GravityCompat.START);
                drawer.setDrawerListener(drawerToggle);
            }
        });
        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View view) {
                isOpenOrClose = true;

            }

            @Override
            public void onDrawerClosed(View view) {
                isOpenOrClose = false;

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }


    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.nav_call:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, call.class));

                        break;
                    case R.id.q:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, q.class));

                        break;
                    case R.id.nav_watch:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, quarentine.class));

                        break;
                    case R.id.nav_finance:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, unor.class));

                        break;

                    case R.id.nav_survey:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, survey.class));

                        break;
                    case R.id.nav_sec:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, hospital.class));

                        break;
                    case R.id.nav_qw:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, qw.class));

                        break;

                    case R.id.nav_movies:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, AppointDoc.class));

                        break;
                    case R.id.nav_epass:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, epass.class));

                        break;
                    case R.id.nav_don:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, DonateActivityDrawer.class));
                        break;

                    case R.id.nav_logout:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, logout.class));
                        finish();
                        break;

                    case R.id.twitter:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, twitter.class));

                        break;

                    case R.id.youtube:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, youtube.class));

                        break;

                    default:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, trialView.class));
                        finish();
                }

                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                return true;
            }
        });
    }

}
