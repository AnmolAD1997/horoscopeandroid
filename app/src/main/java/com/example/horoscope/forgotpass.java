package com.example.horoscope;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpass extends AppCompatActivity {

    private Button resetBtn;
    private EditText emaiResetText;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        resetBtn=(Button)findViewById(R.id.reset);
        emaiResetText=(EditText) findViewById(R.id.emailReset);

        firebaseAuth=FirebaseAuth.getInstance();

        resetBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                final String userEmail=emaiResetText.getText().toString().trim();

                if(userEmail.equals("")){
                    Toast.makeText(forgotpass.this,"Enter Email Please!!!",Toast.LENGTH_SHORT).show();

                }else{
                    firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(forgotpass.this,"Password Reset Detail has been sent to "+ userEmail+" ",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(forgotpass.this,MainActivity.class));

                            }else{
                                Toast.makeText(forgotpass.this,"Password Reset Failed!! Try Again Later",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }


            }

        });




    }




}

