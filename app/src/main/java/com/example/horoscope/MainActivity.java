package com.example.horoscope;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private TextView newUser,info,forgotText,guestText;
    private Button loginBtn;
    private EditText email,password;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private int counter=5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainUi();

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog=new ProgressDialog(this);

        FirebaseUser user=firebaseAuth.getCurrentUser();

        if(user!=null){
            finish();
            startActivity(new Intent(MainActivity.this,MainZodiac.class));
        }

        newUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){



                startActivity(new Intent(MainActivity.this,registration.class));
            }

        });



        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            validate(email.getText().toString(),password.getText().toString());


            }

        });

        guestText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                finish();
                startActivity(new Intent(MainActivity.this,MainZodiac.class));
            }

        });

        forgotText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                finish();
                startActivity(new Intent(MainActivity.this,forgotpass.class));

            }

        });






    }

    private void validate(String mail, String password){

                progressDialog.setMessage(" Wait While We Login To The System.");
                progressDialog.show();

            firebaseAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        verifyEmail();

                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                        counter--;
                        info.setText("No of Attempts Remaining: " + counter);
                        if(counter==0){
                                loginBtn.setEnabled(false);

                        }
                    }


                }
            });

    }

        private void verifyEmail(){

        FirebaseUser firebaseUser=firebaseAuth.getInstance().getCurrentUser();
        Boolean emailStamp=firebaseUser.isEmailVerified();
        
        if(emailStamp){
            finish();
            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,MainZodiac.class));
            
        }else{
            Toast.makeText(MainActivity.this, "Verify Your Email First.!!!", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }

        }


    private void mainUi() {
        newUser=(TextView)findViewById(R.id.newUserText);
        loginBtn=(Button)findViewById(R.id.loginBtn);
        email=(EditText)findViewById(R.id.emailArea);
        password=(EditText)findViewById(R.id.passArea);
        info=(TextView)findViewById(R.id.infoView);
        forgotText=(TextView)findViewById(R.id.forgotText);
guestText=(TextView)findViewById(R.id.guestText);
    }

}

