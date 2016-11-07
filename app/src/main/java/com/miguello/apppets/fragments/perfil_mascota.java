package com.miguello.apppets.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguello.apppets.R;
import com.miguello.apppets.adapter.MascotasAdaptador;
import com.miguello.apppets.adapter.PerfilAdapter;
import com.miguello.apppets.pojo.Mascotas;
import com.miguello.apppets.pojo.Perfil_chandosin;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


public class perfil_mascota extends Fragment {


    ArrayList<Perfil_chandosin> perfil;
    private RecyclerView listaMascotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);


        CircularImageView circularImageView = (CircularImageView) v.findViewById (R.id.circulaimg);
        // Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.colorPrimary));
        circularImageView.setBorderWidth(10);
        // Add Shadow with default param
        circularImageView.addShadow();
        // or with custom param
        circularImageView.setShadowRadius(10);
        circularImageView.setShadowColor(Color.DKGRAY);



        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_mascotasperfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);  // el 2 significa el número de columnas

        listaMascotas.setLayoutManager(glm); //Que el RecyclerView se comporte como LinearLayoutManager Vertical
        inicializarListaPerfiles();
        inicializarAdaptador();

        return v;

    }


    public void inicializarAdaptador(){

        PerfilAdapter adaptador = new PerfilAdapter(perfil);
        listaMascotas.setAdapter(adaptador); // aquí el RecyclerView ya contiene el adaptador por lo tanto la lista

    }


    public void inicializarListaPerfiles(){ // es mejor crear este método afuera del OnCreated

        perfil = new ArrayList<Perfil_chandosin>();

        perfil.add(new Perfil_chandosin(R.drawable.bulldog_ingles_2,"5"));
        perfil.add(new Perfil_chandosin(R.drawable.cachorros_bulldog_ingles_fca_buoncherny_d_nq_np_242621_mla20821369197_072016_f,"3"));
        perfil.add(new Perfil_chandosin(R.drawable.cachorros_bulldog_ingles_inscritos_d_nq_np_510411_mlc20530565001_122015_f,"7"));
        perfil.add(new Perfil_chandosin(R.drawable.fotos_bulldog_ingles_cachorros_0,"15"));
        perfil.add(new Perfil_chandosin(R.drawable.fotos_bulldog_ingles_cachorros_3,"2"));
        perfil.add(new Perfil_chandosin(R.drawable.fotos_bulldog_ingles_cachorros_4,"4"));

    }

}
