package com.miguello.apppets.pojo;



public class Perfil_chandosin {

    private int foto;
    private String like;


    public Perfil_chandosin(int foto, String like){

        this.foto   = foto;
        this.like   = like;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getLike() { return like; }

    public void setLike(String like) { this.like = like; }

}

