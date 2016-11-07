package com.miguello.apppets.adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguello.apppets.R;
import com.miguello.apppets.pojo.Perfil_chandosin;

import java.util.ArrayList;

/**
 * Created by MIGUEL on 07/11/2016.
 */

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder> {

    ArrayList<Perfil_chandosin> perfil;


    public PerfilAdapter (ArrayList<Perfil_chandosin> perfil){
        this.perfil = perfil;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_chandosin,parent,false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder perfilViewHolder, int position) {

        Perfil_chandosin perfiles = perfil.get(position);
        perfilViewHolder.imgFoto.setImageResource(perfiles.getFoto());
        perfilViewHolder.tvnumerolikes.setText(perfiles.getLike());
    }

    @Override
    public int getItemCount() {
        return perfil.size();
    }


    public static class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvnumerolikes;

        public PerfilViewHolder(View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.img_chandosin_perfil);
            tvnumerolikes = (TextView) itemView.findViewById(R.id.tv_numerolikes);

        }
    }

}
