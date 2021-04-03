package com.example.horoscope;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateProfile extends AppCompatActivity {

    private Button updateBtn;
    private EditText nameField, contactField, emailField;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase firebaseDatabase;
    private UserDetail userDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        nameField = (EditText) findViewById(R.id.nameField);
        contactField = (EditText) findViewById(R.id.contactField);
        emailField = (EditText) findViewById(R.id.emailField);
        updateBtn = (Button) findViewById(R.id.updateBtn);


        firebaseAuth = FirebaseAuth.getInstance();

        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();


        if (firebaseUser != null) {

            final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    userDetail = dataSnapshot.getValue(UserDetail.class);


                    nameField.setText(userDetail.getName());
                    emailField.setText(userDetail.getEmail());

                    contactField.setText(userDetail.getContact());

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(UpdateProfile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

                }
            });

            updateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String name=nameField.getText().toString().trim();
                    String contact=contactField.getText().toString().trim();
                    String email=emailField.getText().toString().trim();

                    UserDetail userDetail= new UserDetail(name,contact,email);

                    databaseReference.setValue(userDetail);

                    Toast.makeText(UpdateProfile.this,"Profile Updated Successfully!!",Toast.LENGTH_SHORT).show();

                    finish();
                }
            });


        }

    }
}
