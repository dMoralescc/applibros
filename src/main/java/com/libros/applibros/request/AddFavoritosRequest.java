package com.libros.applibros.request;

import java.util.List;

public class AddFavoritosRequest {
    private String id;
    private String isbn;
    private String idusuario;
    private String fechafav;
    private int estado;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }
    public String getFechafav() {
        return fechafav;
    }
    public void setFechafav(String fechafav) {
        this.fechafav = fechafav;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }

    

}
