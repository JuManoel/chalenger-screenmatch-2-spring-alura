package edu.alura.famousphrases.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alura.famousphrases.dto.SerieFilmeDTO;
import edu.alura.famousphrases.models.Frase;
import edu.alura.famousphrases.models.SerieFilme;
import edu.alura.famousphrases.repository.SerieFilmeRepository;

@Service
public class SerieFilmeService {
    @Autowired
    private SerieFilmeRepository serieRepository;

    public SerieFilmeDTO mostrarSerieFilme() {
        List<SerieFilme> seriesFilmes = serieRepository.findAll();
        Random rdn = new Random();
        int s = rdn.nextInt(seriesFilmes.size());
        SerieFilme sf = seriesFilmes.get(s);
        var frases = sf.getFrases();
        int f = rdn.nextInt(frases.size());
        Frase fra = frases.get(f);
        return new SerieFilmeDTO(s, sf.getNombre(), sf.getPoster(), fra.getFrase(), fra.getAutor());

    }
}
