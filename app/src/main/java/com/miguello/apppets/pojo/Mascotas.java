package com.miguello.apppets.pojo;



public class Mascotas {

    private int id;
    private String nombre;
    private int foto;
    private int like;


    public Mascotas(int foto, String nombre, int like){

        this.foto   = foto;
        this.nombre = nombre;
        this.like   = like;
    }

    public Mascotas() {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLike() { return like; }

    public void setLike(int like) { this.like = like; }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }
}
