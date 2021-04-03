package com.example.horoscope;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registration extends AppCompatActivity {

    private EditText name,email,contact,password;
    private Button regButton;
    private TextView alreadyLoggin;
    private FirebaseAuth firebaseAuth;
    String newName,newEmail,newContact;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mainUiViews();

        firebaseAuth=FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(validate()){

                String guest_email=email.getText().toString().trim();
                String guest_password=password.getText().toString().trim();



                    firebaseAuth.createUserWithEmailAndPassword(guest_email,guest_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()) {
                                sendVerification();
                                sendData();
                                firebaseAuth.signOut();
                                Toast.makeText(registration.this,"User Created and Verification Email sent !!!",Toast.LENGTH_SHORT).show();
                                finish();










                            }else{
                                Toast.makeText(registration.this, "Failed Registration", Toast.LENGTH_SHORT).show();
                            }
                    }
                });

                }

            }

        });


        alreadyLoggin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                finish();
                startActivity(new Intent(registration.this,MainActivity.class));
            }

        });

    }

    private void mainUiViews(){
        name=(EditText)findViewById(R.id.nameField);
        email=(EditText)findViewById(R.id.contactField);
        contact=(EditText)findViewById(R.id.emailField);
        password=(EditText)findViewById(R.id.passwordField);
        regButton=(Button)findViewById(R.id.updateBtn);
        alreadyLoggin=(TextView)findViewById(R.id.loggedInText);
    }

    private Boolean validate(){
        Boolean result=false;
         newName= name.getText().toString();
        newEmail= email.getText().toString();
         newContact=contact.getText().toString();
        String newPassword= password.getText().toString();

       if(newName.isEmpty() || newEmail.isEmpty() || newContact.isEmpty() || newPassword.isEmpty()){

            Toast.makeText(this,"Please enter all the values in the text box.",Toast.LENGTH_SHORT).show();

        }
        else{
            result=true;

       }
        return result;


    }

    private void sendVerification(){
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){


                        }else{
                            Toast.makeText(registration.this,"Verification Mail not sent.",Toast.LENGTH_SHORT).show();
                        }

                }
            });

        }
    }

    private void sendData(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference myRef= firebaseDatabase.getReference(firebaseAuth.getUid());

        UserDetail userDetail=new UserDetail(newName,newContact,newEmail);
        myRef.setValue(userDetail);
    }

}
