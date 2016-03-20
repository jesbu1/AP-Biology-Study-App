package com.example.jesse.apbiologystudyappv2;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    boolean isFragment1Open;
    MenuItem menuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BigIdea1Fragment fragment = new BigIdea1Fragment();
        fragmentSetup(fragment);
        isFragment1Open = true;
        setupInitialView();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void fragmentSetup(android.support.v4.app.Fragment fragmentInput) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_view, fragmentInput);
        fragmentTransaction.commit();
    }

    public void setupInitialView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        menuItem = navigationView.getMenu().findItem(R.id.big_idea_1);
        menuItem.setChecked(true);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.big_idea_1) {
            if (isFragment1Open != true) {
                BigIdea1Fragment bigIdea1Fragment = new BigIdea1Fragment();
                fragmentSetup(bigIdea1Fragment);
            }


        } else if (id == R.id.big_idea_2) {
            isFragment1Open = false;
            BigIdea2Fragment bigIdea2Fragment = new BigIdea2Fragment();
            fragmentSetup(bigIdea2Fragment);

        } else if (id == R.id.big_idea_3) {
            isFragment1Open = false;
            BigIdea3Fragment bigIdea3Fragment = new BigIdea3Fragment();
            fragmentSetup(bigIdea3Fragment);
            //same as above
        } else if (id == R.id.big_idea_4) {
            isFragment1Open = false;
            BigIdea4Fragment bigIdea4Fragment = new BigIdea4Fragment();
            fragmentSetup(bigIdea4Fragment);

        } else if (id == R.id.how_to) {
            isFragment1Open = false;
            AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.myDialog));
            builder.setMessage("Though you can start in any order you'd like, I recommend starting " +
                    "with the first big idea (evolution) and progressing in order." +
                    "\n\nIn each big idea, first read the overview then go through each section, first" +
                    " carefully reading the notes and then taking the quiz. " +
                    "\n\nIt's important that you read the notes carefully." +
                    "\n\nGood luck!");
            AlertDialog dialog = builder.create();
            dialog.show();
        } else if (id == R.id.help_me) {
            isFragment1Open = false;
            AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.myDialog));
            builder.setMessage("I am just a high school senior, and I put hours upon hours into this app." +
                    "\n\nI would never put ads in it because that is distracting from the purpose of the app, and " +
                    "I'd never charge for this app." + "\n\nIt would be awesome to receive a few donations to support me."+
                    " My paypal is: jessezhang5@gmail.com \n\nAny donation amount is fine, thank you!");
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

