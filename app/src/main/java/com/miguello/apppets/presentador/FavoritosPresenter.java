package com.miguello.apppets.presentador;

import android.content.Context;

import com.miguello.apppets.IMascotasLike;
import com.miguello.apppets.db.ConstructorMascotas;
import com.miguello.apppets.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by MIGUEL on 14/11/2016.
 */

public class FavoritosPresenter implements IFavoritosPresenter{

    private IMascotasLike iMascotasLike;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;


    public FavoritosPresenter(IMascotasLike iMascotasLike, Context context) {
        this.iMascotasLike = iMascotasLike;
        this.context = context;
        obtenerMascotasFavoritasDB();
    }

    @Override
    public void obtenerMascotasFavoritasDB() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotasFavoritas();
        mostrarMascotasFavoritasRV();
    }

    @Override
    public void mostrarMascotasFavoritasRV() {
        iMascotasLike.inicializarAdaptadorRV(iMascotasLike.crearAdaptador(mascotas));
        iMascotasLike.generarLinearLayoutVertical();
    }

}
