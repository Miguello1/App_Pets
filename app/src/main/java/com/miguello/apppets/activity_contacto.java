package com.miguello.apppets;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class activity_contacto extends AppCompatActivity {


    private TextInputEditText hint_nombre;
    private  TextInputEditText hint_email;
    private  TextInputEditText hint_mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        hint_nombre         = (TextInputEditText) findViewById(R.id.hint_nombre);
        hint_email          = (TextInputEditText) findViewById(R.id.hint_email);
        hint_mensaje        = (TextInputEditText) findViewById(R.id.hint_mensaje);

    }



}
