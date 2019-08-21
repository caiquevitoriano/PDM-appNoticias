package com.example.appnoticias.Model;

import android.app.Activity;

import java.io.Serializable;

public class Noticia implements Serializable {
    private String titulo;
    private String link;
    private String data;
    private String descricao;
    private String conteudo;

    public Noticia() {
    }

    public Noticia(String titulo, String link, String data, String descricao, String conteudo) {
        this.titulo = titulo;
        this.link = link;
        this.data = data;
        this.descricao = descricao;
        this.conteudo = conteudo;
    }

    public Noticia(Activity activity, String titulo, String link, String data, String descricao) {
    }

    public Noticia(String titulo, String link, String data, String descricao) {
        this.titulo = titulo;
        this.link = link;
        this.data = data;
        this.descricao = descricao;
    }

    public Noticia(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", link='" + link + '\'' +
                ", data='" + data + '\'' +
                ", descricao='" + descricao + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
