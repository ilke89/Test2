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
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);
    EditText enterName, enterUname, enterEmail, enterPass, repeatPassword;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    public void saveData(View v){

        enterName = (EditText) findViewById(R.id.enterName);
        enterUname = (EditText) findViewById(R.id.enterUserName);
        enterEmail = (EditText) findViewById(R.id.enterEmail);
        enterPass = (EditText) findViewById(R.id.enterPassword);
        repeatPassword=(EditText) findViewById(R.id.repeatPassword);

        String nameStr = enterName.getText().toString();
        String unameStr = enterUname.getText().toString();
        String emailStr = enterEmail.getText().toString();
        String passStr = enterPass.getText().toString();
        String repStr=repeatPassword.getText().toString();

        if (repStr.equals(passStr)) {

            Contact c = new Contact();
            c.setName(nameStr);
            c.setUname(unameStr);
            c.setEmail(emailStr);
            c.setPassword(passStr);

            helper.addData(c);


            Toast.makeText(RegistrationActivity.this,
                    "Registration successful", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(RegistrationActivity.this,
                    "Passwords don't match", Toast.LENGTH_LONG).show();
        }


    }


}
