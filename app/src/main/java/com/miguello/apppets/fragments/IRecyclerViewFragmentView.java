package com.miguello.apppets.fragments;

import com.miguello.apppets.adapter.MascotasAdaptador;
import com.miguello.apppets.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by MIGUEL on 13/11/2016.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical ();

    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV (MascotasAdaptador adaptador);

}
