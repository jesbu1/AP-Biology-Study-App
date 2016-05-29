package com.example.jesse.apbiologystudyappv2;

import android.content.DialogInterface;
import android.content.Intent;
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
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jesse.inappbilling.util.IabHelper;
import com.example.jesse.inappbilling.util.IabResult;
import com.example.jesse.inappbilling.util.Purchase;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    static String EXTRA_MESSAGE;
    boolean isFragment1Open;
    IabHelper mHelper;
    MenuItem menuItem;
    Purchase purchase;
    String[] arrayOfDonations = {"$1 Donation", "$3 Donation", "$5 Donation"};
    //My public key for linking with google play and donations
    public static String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtw3PYQYqYzWB6QrG1w3kAr" +
            "YbM/fkZjl0gdp6xLuyiHRkmdrGrDMLH2jef+7Q3w3Q" +
            "hsXiNCU3g6a6dalI/I1ixt5ljS0s5mb4m5gap8klhVReuo2u5+TPxsfjz+AFE6" +
            "YjUoesSVlO6Bj6b6iI4e8DacZVXqOwSyHW8Iam5rwoQ3kCfF3Khr6Ms" +
            "qd7MdX2zhSXi/UK5x5eTGGDOtNrFwwO8O4lIcguozOppDftgydNH56Krc0p4NUuHI2VRRxyZh6tBr3+qUJzn7yZzzBgVEtbfy+rC+di1Rsl6EEoKOmtD8Vhqtppnl3+74Stn3fXlyFDP9OmkqANLorsfiohQbAwVwIDAQAB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //This setTheme creates the launch screen
        setTheme(R.style.AppTheme);
        setupmHelper();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BigIdea1Fragment fragment = new BigIdea1Fragment();
        fragmentSetup(fragment);
        isFragment1Open = true;
        setupInitialView();
    }
    public void setupmHelper(){
        mHelper = new IabHelper(this, base64EncodedPublicKey);
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {
                    // Oh noes, there was a problem.
                    Log.d("PROBLEM", "Problem setting up In-app Billing: " + result);
                }
                // Hooray, IAB is fully set up!
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Destory mHelper which was communicating with google play
        if (mHelper != null) mHelper.dispose();
        mHelper = null;
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
    //Purchase handler
    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener
            = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase)
        {
            if (result.isFailure()) {
                Log.d("ERROR", "Error purchasing: " + result);
                return;
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(), "Thanks for the beer...JK I'm not 21 yet :(", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };
    //Consume the donation purchase immediately after purchase so they can donate again if they want
    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase, IabResult result) {
                    if (result.isSuccess()) {
                        Log.d("Consume", "Consumption succesful");
                    }
                    else {
                        Log.d("Consume", "Consumption NOT SUCCESSFUL");
                    }
                }
            };


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
            builder.setMessage("I recommend starting " +
                    "with the first big idea and progressing in order." +
                    "\n\nIn each big idea, first read the overview then go through each section," +
                    " carefully reading the notes and then taking the quiz. " +
                    "\n\nGood luck!" + "\n\nPS: I am just a high school senior, and I put hours upon hours into this app." +
                            "\n\nI would never put ads in this app nor would I ever charge for it. " + "\n\nIt would be awesome to receive a few donations."+
                            " My paypal is: jessezhang5@gmail.com" +
                            "\n\nAlternatively, just click the donation tab in the menu to send me a donation through Google Play!");
            AlertDialog dialog = builder.create();
            dialog.show();
        } else if (id == R.id.help_me) {
            isFragment1Open = false;
            AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.myDialog));

            builder.setTitle("Please support my college fund!");

            builder.setItems(arrayOfDonations, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //TODO: Fix consumption things
                    if (which == 0){
                        mHelper.launchPurchaseFlow(MainActivity.this, "1_dollar_donation", 1, mPurchaseFinishedListener ,"");
                        //mHelper.consumeAsync(purchase,mConsumeFinishedListener);


                    } else if (which == 1) {
                        mHelper.launchPurchaseFlow(MainActivity.this, "3_dollar_donation", 2, mPurchaseFinishedListener ,"");
                        //mHelper.consumeAsync(purchase,mConsumeFinishedListener);

                    } else if (which == 2){
                        mHelper.launchPurchaseFlow(MainActivity.this, "5_dollar_donation", 3, mPurchaseFinishedListener ,"");
                        //mHelper.consumeAsync(purchase,mConsumeFinishedListener);


                    }
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //Required for the in app purchase
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Pass on the activity result to the helper for handling
        if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
        else {

        }
    }


}

