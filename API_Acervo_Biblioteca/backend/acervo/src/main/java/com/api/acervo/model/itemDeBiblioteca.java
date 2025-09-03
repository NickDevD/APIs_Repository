package com.api.acervo.model;

public class itemDeBiblioteca {
    private String titulo;
    private String autor;
    private int registro;

    public itemDeBiblioteca(String titulo, String autor, int registro){
        this.titulo = titulo;
        this.autor = autor;
        this.registro = registro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }
}
