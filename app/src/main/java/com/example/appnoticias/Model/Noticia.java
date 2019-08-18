package com.example.appnoticias.Model;

public class Noticia {
    private String titulo;
    private String link;
    private String data;

    public Noticia() {
    }

    public Noticia(String titulo, String link, String data) {
        this.titulo = titulo;
        this.link = link;
        this.data = data;
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

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", link='" + link + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
