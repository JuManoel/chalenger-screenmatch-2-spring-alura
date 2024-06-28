package edu.alura.famousphrases.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "frases")
public class Frase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String frase;
    private String autor;
    @ManyToOne
    private SerieFilme serieFilme;

    public Frase() {
    }

    public Frase(DatosFrase dase) {
        this.frase = dase.frase();
        this.autor = dase.autor();
    }

    public SerieFilme getSerieFilme() {
        return serieFilme;
    }

    public void setSerieFilme(SerieFilme serieFilme) {
        this.serieFilme = serieFilme;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
