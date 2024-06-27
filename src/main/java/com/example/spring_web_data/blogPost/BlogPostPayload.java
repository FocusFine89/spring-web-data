package com.example.spring_web_data.blogPost;

public class BlogPostPayload {
    //Attributi
    private String titolo;
    private String categoria;
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;

    //Costruttori

    public BlogPostPayload(String titolo, String categoria, String contenuto, int tempoDiLettura, int autoreId) {
        this.titolo = titolo;
        this.categoria = categoria;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.autoreId = autoreId;
    }


    //Metodi

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

    public void setTempoDiLettura(int tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }

    public int getAutoreId() {
        return autoreId;
    }

    public void setAutoreId(int autoreId) {
        this.autoreId = autoreId;
    }

    @Override
    public String toString() {
        return "BlogPostPayload{" +
                "autoreId=" + autoreId +
                ", tempoDiLettura=" + tempoDiLettura +
                ", contenuto='" + contenuto + '\'' +
                ", categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
