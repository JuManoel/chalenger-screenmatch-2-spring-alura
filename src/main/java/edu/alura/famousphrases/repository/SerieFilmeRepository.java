package edu.alura.famousphrases.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alura.famousphrases.models.SerieFilme;

public interface SerieFilmeRepository extends JpaRepository<SerieFilme, Integer>{
    Optional<SerieFilme> findByNombreContainsIgnoreCase(String titulo);
    
}
