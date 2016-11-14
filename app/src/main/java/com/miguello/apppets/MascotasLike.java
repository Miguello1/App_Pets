package com.miguello.apppets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.miguello.apppets.adapter.MascotasAdaptador;
import com.miguello.apppets.pojo.Mascotas;

import java.util.ArrayList;

public class MascotasLike extends AppCompatActivity {


    ArrayList<Mascotas> mascotaslike;
    private RecyclerView listaMascotaslike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_like);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaMascotaslike = (RecyclerView) findViewById(R.id.rv_mascotaslike);

        LinearLayoutManager llm = new LinearLayoutManager(this); // llm es lineas layout manager
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotaslike.setLayoutManager(llm); //Que el RecyclerView se comporte como LinearLayoutManager Vertical
        //inicializarListaMascotaslike();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {

        MascotasAdaptador adaptador = new MascotasAdaptador(mascotaslike, this);
        listaMascotaslike.setAdapter(adaptador); // aquí el RecyclerView ya contiene el adaptador por lo tanto la lista
    }

    /*public void inicializarListaMascotaslike(){ // es mejor crear este método afuera del OnCreated

        mascotaslike = new ArrayList<Mascotas>();

        mascotaslike.add(new Mascotas(R.drawable.english_bulldog_about_to_sleep,"Beto",5));
        mascotaslike.add(new Mascotas(R.drawable.hamster_eating_tomato_b5cgk7,"Glotón",1));
        mascotaslike.add(new Mascotas(R.drawable.bulldog_ingles_2,"Chandosin",10));
        mascotaslike.add(new Mascotas(R.drawable.maxresdefault,"Millo",7));
        mascotaslike.add(new Mascotas(R.drawable.gato_mal_olor,"Bigotes",3));

    }*/


}