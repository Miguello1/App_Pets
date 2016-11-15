package com.miguello.apppets.db;

import android.content.ContentValues;
import android.content.Context;

import com.miguello.apppets.R;
import com.miguello.apppets.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by MIGUEL on 13/11/2016.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;


    public ConstructorMascotas(Context context) {

        this.context = context;
    }


    public ArrayList<Mascotas> obtenerDatos(){
        /*ArrayList<Mascotas> mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.bulldog_ingles_2,"Chandosin","0"));
        mascotas.add(new Mascotas(R.drawable.english_bulldog_about_to_sleep,"Beto","0"));
        mascotas.add(new Mascotas(R.drawable.gato_mal_olor,"Bigotes","0"));
        mascotas.add(new Mascotas(R.drawable.hamster_eating_tomato_b5cgk7,"Glotón","0"));
        mascotas.add(new Mascotas(R.drawable.maxresdefault,"Millo","0"));

        return mascotas;*/

        BaseDatos sqLiteDatabase = new BaseDatos(context);
        insertarTresMascotas(sqLiteDatabase);
        return sqLiteDatabase.obtenerTodasMascotas();
    }

    private void insertarTresMascotas (BaseDatos sqLiteDatabase){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Chandosin");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.bulldog_ingles_2);
                sqLiteDatabase.insertarMascota(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Beto");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.english_bulldog_about_to_sleep);
                sqLiteDatabase.insertarMascota(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Bigotes");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.gato_mal_olor);
                sqLiteDatabase.insertarMascota(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Glotón");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.hamster_eating_tomato_b5cgk7);
        sqLiteDatabase.insertarMascota(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Millo");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.maxresdefault);
        sqLiteDatabase.insertarMascota(contentValues);


    }


    public void darLike(Mascotas mascotas){
        BaseDatos sqLiteDatabase = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTA, mascotas.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_MASCOTAS_LIKES, LIKE);
        sqLiteDatabase.insertarLike(contentValues);
    }


    public int obtenerLikesMascota(Mascotas mascotas){
        BaseDatos sqLiteDatabase = new BaseDatos(context);
        return sqLiteDatabase.obtenerLikeMascota(mascotas);
    }


    public ArrayList<Mascotas> obtenerMascotasFavoritas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        BaseDatos sqLiteDatabase = new BaseDatos(context);
        mascotas = sqLiteDatabase.obtenerMascotasFavoritas();
        return mascotas;
    }


}
