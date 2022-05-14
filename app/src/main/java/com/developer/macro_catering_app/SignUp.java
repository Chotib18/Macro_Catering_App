package com.developer.macro_catering_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUp extends AppCompatActivity {

    private EditText InputUsername, InputEmail, NoKontak, InputPass1, InputPass2;
    private Button butnSignUp;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();



        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(SignUp.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan Tunggu");
        progressDialog.setCancelable(false);

        InputUsername = findViewById(R.id.username);
        InputEmail = findViewById(R.id.email);
        NoKontak = findViewById(R.id.telphone);
        InputPass1 = findViewById(R.id.password1);
        InputPass2 = findViewById(R.id.password2);

        butnSignUp = findViewById(R.id.btnSignUp);

        butnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InputUsername.getText().length()>0 && InputEmail.getText().length()>0 && NoKontak.getText().length()>0 && InputPass1.getText().length()>0 && InputPass2.getText().length()>0){
                    if (InputPass1.getText().toString().equals(InputPass2.getText().toString())){
                        register(InputUsername.getText().toString(), InputEmail.getText().toString(),NoKontak.getText().toString(), InputPass1.getText().toString());
                    } else {
                        Toast.makeText(getApplicationContext(), "Password berbeda ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                        Toast.makeText(getApplicationContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void register(String username, String email, String telphone, String password ) {
        progressDialog.show();;
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult()!=null){
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser!=null) {
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName("")
                                .build();
                        firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                reload();
                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "Register Gagal!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    private void reload(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser curentUser = mAuth.getCurrentUser();
        if (curentUser != null){
            reload();
        }
    }

    public void onClickRegistBackToLogin(View view) {
        Intent bckLogin = new Intent(SignUp.this, com.developer.macro_catering_app.Login.class );
        startActivity(bckLogin);
    }
}