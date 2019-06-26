package com.example.desafiolemobs.model;

import java.io.Serializable;

public class Livro implements Serializable {
    private String title;
    private double price;
    private String writer;
    private int image;
    private String lacamento;
    private Boolean comprado = true;
    private Boolean teste = true;

    public Boolean getTeste() {
        return teste;
    }

    public void setTeste(Boolean teste) {
        this.teste = teste;
    }

    public Livro(){

    }

    public Livro(String title, String writer, int image, String lacamento, double price, Boolean comprado) {
        this.title = title;
        this.writer = writer;
        this.image = image;
        this.lacamento = lacamento;
        this.price = price;
        this.comprado = comprado;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLacamento() {
        return lacamento;
    }

    public void setLacamento(String lacamento) {
        this.lacamento = lacamento;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getComprado() {
        return comprado;
    }

    public void setComprado(Boolean comprado) {
        this.comprado = comprado;
    }
}
