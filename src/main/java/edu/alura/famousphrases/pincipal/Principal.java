package edu.alura.famousphrases.pincipal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import edu.alura.famousphrases.models.*;

import edu.alura.famousphrases.repository.SerieFilmeRepository;
// import edu.alura.famousphrases.service.ConsumoAPI;
// import edu.alura.famousphrases.service.ConvierteDatos;

public class Principal {
    private Scanner scn = new Scanner(System.in);
    // private ConsumoAPI consumoApi = new ConsumoAPI();
    // private ConvierteDatos convierteDatos = new ConvierteDatos();

    // // nuestra variable json. va recibir la string de Consumo API
    // private String json;

    // // Constante para pedir los dados del consumo API
    // private final String API = "&apikey=53a8e07f";
    // private final String URL = "https://www.omdbapi.com/?t=";

    private SerieFilmeRepository repository;

    // private List<SerieFilme> series;

    public Principal(SerieFilmeRepository repository) {
        this.repository = repository;
    }

    public void initialize() {
        String r;
        do {
            String url = "";
            System.out.println("Ingrese el nombre de una serie o pelicula");
            String nombre = scn.nextLine();
            Optional<SerieFilme> sf = repository.findByNombreContainsIgnoreCase(nombre);
            if (!sf.isPresent()) {
                System.out.println("ingrese la url dle poster");
                url = scn.nextLine();
            }
            System.out.println("ingrese la frase");
            String frase = scn.nextLine();
            System.out.println("Ingrese quien la cito");
            String autor = scn.nextLine();
            SerieFilme s;
            Frase f;
            if (sf.isPresent()) {
                DatosFrase df = new DatosFrase(frase, autor);
                f = new Frase(df);
                s = sf.get();
            } else {
                DatosSerieFilme dsf = new DatosSerieFilme(nombre, url);
                s = new SerieFilme(dsf);
                DatosFrase df = new DatosFrase(frase, autor);
                f = new Frase(df);
            }
            List<Frase> fraseList = s.getFrases();
            if(fraseList == null) {
                fraseList = new ArrayList<Frase>();
            }
            fraseList.add(f);
            s.setFrases(fraseList);
            repository.save(s);
            System.out.println("Frase ingresada con sucesso");
            System.out.println("Deseas seguir ingresando");
            r = scn.nextLine();
        } while (r.toLowerCase().startsWith("s"));

    }
}
