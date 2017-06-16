package com.example.gerso.amigosseupauloprotetor.activity.models;

/**
 * Created by gerso on 6/15/2017.
 */

public class Novidade {
    String tituloNovidade;
    int imageNovidade;

    public Novidade(String tituloNovidade, int imageNovidade) {
        this.tituloNovidade = tituloNovidade;
        this.imageNovidade = imageNovidade;
    }

    public String getTituloNovidade() {
        return tituloNovidade;
    }

    public void setTituloNovidade(String tituloNovidade) {
        this.tituloNovidade = tituloNovidade;
    }

    public int getImageNovidade() {
        return imageNovidade;
    }

    public void setImageNovidade(int imageNovidade) {
        this.imageNovidade = imageNovidade;
    }
}
