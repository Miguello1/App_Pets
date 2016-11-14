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
import com.miguello.apppets.presentador.IRecyclerViewFragmentPresenter;
import com.miguello.apppets.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class fragment_recyclerview extends Fragment implements IRecyclerViewFragmentView {


    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_recyclerview, container, false);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_mascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;

    }



    /*public void inicializarListaMascotas(){ // es mejor crear este método afuera del OnCreated

       esta parte la mandamos al ConstructorMascotas

    }*/


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity()); // llm es lineas layout manager
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);  // el 2 significa el número de columnas

        listaMascotas.setLayoutManager(llm); //Que el RecyclerView se comporte como LinearLayoutManager Vertical
    }

    @Override
    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotasAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador); // aquí el RecyclerView ya contiene el adaptador por lo tanto la lista
    }


}
