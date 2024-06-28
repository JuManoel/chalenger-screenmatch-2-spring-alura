package edu.alura.famousphrases.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.alura.famousphrases.dto.SerieFilmeDTO;
import edu.alura.famousphrases.service.SerieFilmeService;

@RestController
@RequestMapping("/series")
public class SerieFilmeControler {
    @Autowired
    private SerieFilmeService serieFilmeService;
    @GetMapping("/frases")
    public SerieFilmeDTO mostrarSerieFilme() {
        return serieFilmeService.mostrarSerieFilme();
    }
}
