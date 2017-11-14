package com.example.ilkeutd.pametanpisebudalapamti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper= new DatabaseHelper(this);
    EditText email, password;
    Button loginButton;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }
    public void logIn(View view){

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);

        String mail= email.getText().toString();
        String pass=password.getText().toString();

        String pword= databaseHelper.logIn(mail);
        if (pass.equals(pword)){

            Toast.makeText(LogInActivity.this,
                    "Welcome", Toast.LENGTH_LONG).show();
        }

        else {

            Toast.makeText(LogInActivity.this,
                    "Email and password do not exist", Toast.LENGTH_LONG).show();
        }



    }





    public void openReg(View view){

        Intent intent= new Intent(this, RegistrationActivity.class );
        startActivity(intent);
    }







}
