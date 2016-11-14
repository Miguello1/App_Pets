package com.miguello.apppets;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class activity_contacto extends AppCompatActivity implements View.OnClickListener{


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

        Button enviar   =  (Button) findViewById(R.id.enviar);
        hint_nombre         = (TextInputEditText) findViewById(R.id.hint_nombre);
        hint_email          = (TextInputEditText) findViewById(R.id.hint_email);
        hint_mensaje        = (TextInputEditText) findViewById(R.id.hint_mensaje);

        enviar.setOnClickListener(this);
    }


    public void enviarEmail (View v){
        EnviarMail send = new EnviarMail(this,  hint_email.getText().toString().trim(),
                                                hint_nombre.getText().toString().trim(),
                                                hint_mensaje.getText().toString().trim());
        send.execute();
    }

    @Override
    public void onClick(View v) {

        enviarEmail(v);
    }

}
