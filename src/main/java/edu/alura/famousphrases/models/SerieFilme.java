package edu.alura.famousphrases.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "seriesfilmes")
public class SerieFilme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String poster;
    @OneToMany(mappedBy = "serieFilme", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<Frase> frases;

    public SerieFilme() {
    }

    public SerieFilme(DatosSerieFilme dsf) {
        this.nombre = dsf.nombre();
        this.poster = dsf.poster();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<Frase> getFrases() {
        return frases;
    }

    public void setFrases(List<Frase> frases) {
        this.frases = frases;
        for (Frase frase : this.frases) {
            frase.setSerieFilme(this);
        }
    }

}
