package com.miguello.apppets;

import com.miguello.apppets.adapter.MascotasAdaptador;
import com.miguello.apppets.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by MIGUEL on 14/11/2016.
 */

public interface IMascotasLike {

    void generarLinearLayoutVertical();

    MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    void inicializarAdaptadorRV(MascotasAdaptador adaptador);

}
