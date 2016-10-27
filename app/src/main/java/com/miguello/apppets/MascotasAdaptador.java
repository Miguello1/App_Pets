package com.miguello.apppets;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ts on 27/10/2016.
 */

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotaViewHolder> {

    ArrayList<Mascotas> mascotas;
    Activity activity;
    int click = 0;


    public MascotasAdaptador (ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas; //la primera "mascotas" es el objeto global que tenemos en esta clase y la segunda "mascotas" es la lista con los elementos del main activity
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {// darle vida al layout card view. infla el layout y lo pasará al ViewHolder para que obtenga los views
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false); // conectar con el layout del cardview - cual es el layout que estará reciclando el RecyclerView
        return new MascotaViewHolder(v); // se esta pasando el layout inflado del cardview al MascotasViewHolder, para que pueda tomar cada elemento
    }


    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) { // asocia cada elemento de la lista con cada view
        // pasar la lista al ViewHolder es decir settear, invoca los elementos de la lista y obtiene la posición del elemento
        final Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto()); // setteando la foto
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre()); //setteando el nombre
        mascotaViewHolder.tvnumerolikes.setText("+0");

        mascotaViewHolder.btnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Like" + mascota.getNombre(),Toast.LENGTH_SHORT).show();
                click++;
                mascotaViewHolder.tvnumerolikes.setText("+"+click);
            }
        });

    }


    @Override
    public int getItemCount() { //cantidad de elementos que contiene la lista
        return mascotas.size();
    }





    public static class MascotaViewHolder extends RecyclerView.ViewHolder { // la clase inner para poder conectar los datos de la lista con los de los items en el card view

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnlike;
        private TextView tvnumerolikes;

        public MascotaViewHolder(View itemView) { // (View itemview) significa que esta recibiendo un view es decir (v)
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.img_macota);
            tvNombreCV  = (TextView) itemView.findViewById(R.id.tv_nombremascota);
            btnlike     = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvnumerolikes = (TextView) itemView.findViewById(R.id.tv_numerolikes);

        }
    }

}
