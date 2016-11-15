package com.miguello.apppets.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.miguello.apppets.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by MIGUEL on 13/11/2016.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaMascota   = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTAS + "(" +
                                        ConstantesBD.TABLE_MASCOTAS_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBD.TABLE_MASCOTAS_NOMBRE  + " TEXT, "     +
                                        ConstantesBD.TABLE_MASCOTAS_FOTO    + " INTEGER"    +
                                        ")";

        String queryCrearTablaLikes     = "CREATE TABLE " + ConstantesBD.TABLE_LIKES_MASCOTAS + "(" +
                                        ConstantesBD.TABLE_LIKES_MASCOTAS_ID            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTA    + " INTEGER, "          +
                                        ConstantesBD.TABLE_LIKES_MASCOTAS_LIKES         + " INTEGER, "          +
                                        "FOREIGN KEY (" + ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTA + ") "   +
                                        "REFERENCES " + ConstantesBD.TABLE_MASCOTAS + "(" + ConstantesBD.TABLE_MASCOTAS_ID + ")" +
                                        ")";

        sqLiteDatabase.execSQL(queryCrearTablaMascota);
        sqLiteDatabase.execSQL(queryCrearTablaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_MASCOTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_LIKES_MASCOTAS);
        onCreate(sqLiteDatabase);
    }


    public ArrayList<Mascotas> obtenerTodasMascotas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_MASCOTAS;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        while (registros.moveToNext()){

            Mascotas mascotaActual= new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT (" + ConstantesBD.TABLE_LIKES_MASCOTAS_LIKES + ") as likes " +
                                " FROM "    + ConstantesBD.TABLE_LIKES_MASCOTAS     +
                                " WHERE "   + ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTA  + "=" + mascotaActual.getId();

            Cursor registrosLikes = sqLiteDatabase.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setLike(registrosLikes.getInt(0));
            } else {
                mascotaActual.setLike(0);
            }

            mascotas.add(mascotaActual);
        }

        sqLiteDatabase.close();
        return mascotas;
    }


    public void insertarMascota (ContentValues contentValues){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBD.TABLE_MASCOTAS,null,contentValues);
        sqLiteDatabase.close();
    }


    public void insertarLike(ContentValues contentValues){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBD.TABLE_LIKES_MASCOTAS,null,contentValues);
        sqLiteDatabase.close();
    }

    public int obtenerLikeMascota (Mascotas mascotas){

        int likes = 0;

        String query =  "SELECT COUNT(" + ConstantesBD.TABLE_LIKES_MASCOTAS_LIKES+ ")" +
                        " FROM "        + ConstantesBD.TABLE_LIKES_MASCOTAS     +
                        " WHERE "       + ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTA  + "=" + mascotas.getId();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        sqLiteDatabase.close();
        return likes;
    }



    public ArrayList<Mascotas> obtenerMascotasFavoritas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String query =  "SELECT m.*, (SELECT COUNT ("   +   ConstantesBD.TABLE_LIKES_MASCOTAS_LIKES   +   ")"     +
                        " FROM "    + ConstantesBD.TABLE_LIKES_MASCOTAS             +
                        " WHERE "   + ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTA  + "=m.id) as likes"     +
                        " FROM "    + ConstantesBD.TABLE_MASCOTAS                   +" m"                   +
                        " ORDER BY likes DESC"  +
                        " LIMIT 5";

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotas.add(mascotaActual);

        }

        sqLiteDatabase.close();
        return mascotas;
    }


}