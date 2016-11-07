package com.miguello.apppets.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguello.apppets.R;
import com.miguello.apppets.adapter.MascotasAdaptador;
import com.miguello.apppets.pojo.Mascotas;

import java.util.ArrayList;


public class fragment_recyclerview extends Fragment {


    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_recyclerview, container, false);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity()); // llm es lineas layout manager
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);  // el 2 significa el número de columnas


        listaMascotas.setLayoutManager(llm); //Que el RecyclerView se comporte como LinearLayoutManager Vertical
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;

    }

    public void inicializarAdaptador(){

        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador); // aquí el RecyclerView ya contiene el adaptador por lo tanto la lista

    }


    public void inicializarListaMascotas(){ // es mejor crear este método afuera del OnCreated

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.bulldog_ingles_2,"Chandosin","0"));
        mascotas.add(new Mascotas(R.drawable.english_bulldog_about_to_sleep,"Beto","0"));
        mascotas.add(new Mascotas(R.drawable.gato_mal_olor,"Bigotes","0"));
        mascotas.add(new Mascotas(R.drawable.hamster_eating_tomato_b5cgk7,"Glotón","0"));
        mascotas.add(new Mascotas(R.drawable.maxresdefault,"Millo","0"));

    }

}
