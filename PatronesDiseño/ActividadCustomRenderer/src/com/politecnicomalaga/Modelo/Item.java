package com.politecnicomalaga.Modelo;

import java.time.LocalDate;

public class Item {
    private String titulo;
    private LocalDate fecha;
    private String texto;
    private String tema;

    public Item(String titulo, LocalDate fecha, String texto, String tema) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.texto = texto;
        this.tema = tema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.titulo = autor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTema() {return tema; }
}
