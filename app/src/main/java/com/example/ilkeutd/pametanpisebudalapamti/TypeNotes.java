package com.example.ilkeutd.pametanpisebudalapamti;

import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TypeNotes extends AppCompatActivity {



    EditText Title;
    EditText Notes;
    Button SaveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button SaveButton= (Button)findViewById(R.id.SaveButton);

    }

    public void SaveNotes(View view){

        EditText Title=(EditText)findViewById(R.id.editText1);
        EditText Notes=(EditText)findViewById(R.id.editText2);

        Intent intent = new Intent(TypeNotes.this, MainActivity.class);
        intent.putExtra("mTitle", Title.getText().toString());
        intent.putExtra("mNotes", Notes.getText().toString());

        startActivity(intent);
    }

}