package com.miguello.apppets;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.button);

        listaMascotas = (RecyclerView) findViewById(R.id.rv_mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this); // llm es lineas layout manager
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);  // el 2 significa el número de columnas


        listaMascotas.setLayoutManager(llm); //Que el RecyclerView se comporte como LinearLayoutManager Vertical
        inicializarListaMascotas();
        inicializarAdaptador();


        /*

        Esta parte es un ejemplo para una ListView, no es de este ejercicio

        ArrayList<String> nombreMascota = new ArrayList<>(); // crea una nueva lista según los nombres de la anterior lista
        for (Mascotas mascota: mascotas){
            nombreMascota.add(mascota.getNombre()); // obtener el nombre de la lista de mascotas
        }*/

    }

    public void inicializarAdaptador(){

        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador); // aquí el RecyclerView ya contiene el adaptador por lo tanto la lista

    }


    public void inicializarListaMascotas(){ // es mejor crear este método afuera del OnCreated

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.bulldog_ingles_2,"Chandosin"));
        mascotas.add(new Mascotas(R.drawable.english_bulldog_about_to_sleep,"Beto"));
        mascotas.add(new Mascotas(R.drawable.gato_mal_olor,"Bigotes"));
        mascotas.add(new Mascotas(R.drawable.hamster_eating_tomato_b5cgk7,"Glotón"));
        mascotas.add(new Mascotas(R.drawable.maxresdefault,"Millo"));

    }



    public void iraMascotasLike (View v){
        Intent intent = new Intent(this, MascotasLike.class);
        startActivity(intent);
    }

}
