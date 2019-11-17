package br.udesc.oagendador.adapter;

import java.io.Serializable;

public class ItemHorarioSalao implements Serializable {

    private int indice;

    private String titulo;

    private String horarioEntrada;

    private String horarioSaida;

    public ItemHorarioSalao(int indice, String titulo) {
        this.indice = indice;
        this.titulo = titulo;
    }

    public int getIndice() {
        return indice;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
}
