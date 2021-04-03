package com.example.horoscope;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainZodiac extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase firebaseDatabase;
    UserDetail userDetail;
    private TextView loginText, userName, userEmail,viewProfile;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_zodiac);





        firebaseAuth = FirebaseAuth.getInstance();

        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        View navHeaderView = navigationView.getHeaderView(0);

        loginText = (TextView) navHeaderView.findViewById(R.id.loginStatus);
        userName = (TextView) navHeaderView.findViewById(R.id.userName);
        userEmail = (TextView) navHeaderView.findViewById(R.id.userEmail);
        viewProfile = (TextView) navHeaderView.findViewById(R.id.viewProfile);


        if (firebaseUser != null) {

            loginText.setText("LogOut");

            DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    userDetail = dataSnapshot.getValue(UserDetail.class);


                    userName.setText(userDetail.getName());
                    userEmail.setText(userDetail.getEmail());
                    viewProfile.setText("View "+"Profile");

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(MainZodiac.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

                }
            });

        } else {
            loginText.setText("LogIn");
            viewProfile.setText(null);
        }


        if (savedInstanceState == null) {


            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new horos()).commit();
            navigationView.setCheckedItem(R.id.horoscope);
        }

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(firebaseUser==null) {
                    startActivity(new Intent(MainZodiac.this, MainActivity.class));
                }else{

                    firebaseAuth.signOut();
                    startActivity(new Intent(MainZodiac.this, MainActivity.class));

                }
            }
        });



        viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    startActivity(new Intent(MainZodiac.this,profileUser.class));





            }
        });


    }



    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {


        switch (menuItem.getItemId()) {
            case R.id.horoscope:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new horos()).commit();

                break;
            case R.id.comp_match:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new compati()).commit();
                break;

            case R.id.property:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new properties()).commit();
                break;

            case R.id.notification:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new notifi()).commit();
                break;

            case R.id.about_us:
                Toast.makeText(this, "We are adhikari Team", Toast.LENGTH_SHORT).show();
                break;

            case R.id.contact_us:
                Toast.makeText(this, "Contact us at man32boy@gmail.com", Toast.LENGTH_SHORT).show();
                break;


        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {


            new AlertDialog.Builder(this)
                    .setTitle("Really Exit?")
                    .setMessage("Are you sure you want to exit?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {
                            MainZodiac.super.onBackPressed();
                        }
                    }).create().show();
        }

        }






}



