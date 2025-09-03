package com.api.acervo.model;

public class Livro extends itemDeBiblioteca {
    private int isbn;

    public Livro(String titulo, String autor, int isbn, int registro){
        super(titulo, autor, registro);
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
