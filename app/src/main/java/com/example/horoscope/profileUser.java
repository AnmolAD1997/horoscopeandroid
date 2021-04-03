package com.example.horoscope;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profileUser extends AppCompatActivity {

    private Button editBtn;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseUser firebaseUser;
    UserDetail userDetail;
    private TextView nameText, contactText, emailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);
        editBtn = (Button) findViewById(R.id.updateBtn);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();

        nameText = (TextView)findViewById(R.id.nameText);
        contactText = (TextView)findViewById(R.id.contactText);
        emailText = (TextView)findViewById(R.id.emailText);

        if (firebaseUser != null) {

            DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    userDetail = dataSnapshot.getValue(UserDetail.class);


                    nameText.setText(userDetail.getName());
                    emailText.setText(userDetail.getEmail());

                    contactText.setText(userDetail.getContact());

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(profileUser.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

                }
            });

        }



        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(profileUser.this, UpdateProfile.class));

            }
        });

    }

}
