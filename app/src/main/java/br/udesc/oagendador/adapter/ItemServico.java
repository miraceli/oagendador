package br.udesc.oagendador.adapter;

import android.net.Uri;

import java.io.Serializable;

public class ItemServico implements Serializable {

    private String titulo;

    private String descricao;

    private String valor;

    private String horario;

    private Uri imagem;

    public ItemServico(String titulo, String descricao, String valor, String horario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
        this.horario = horario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getValor() {
        return valor;
    }

    public String getHorario() {
        return horario;
    }

    public Uri getImagem() {
        return imagem;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setImagem(Uri imagem) {
        this.imagem = imagem;
    }
}
