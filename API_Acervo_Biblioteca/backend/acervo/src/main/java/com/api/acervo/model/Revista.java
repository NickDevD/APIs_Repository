package com.api.acervo.model;

public class Revista extends itemDeBiblioteca{
    int volume;

    public Revista(String titulo, String autor, int registro, int volume){
        super(titulo, autor, registro);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
