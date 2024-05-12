package com.rayen.concerts.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rayen.concerts.entities.Concert;
import com.rayen.concerts.entities.Genre;

public interface ConcertService {
    Concert saveConcert(Concert concert);
    Concert updateConcert(Concert concert);
    void deleteConcert(Concert concert);
    void deleteConcertById(Long id);
    Concert getConcert(Long id);
    List<Concert> getAllConcerts();
    
    Page<Concert> getAllConcertsParPage(int page, int size);
    
    List<Concert> findByNomConcert(String nom);

    List<Concert> findByNomConcertContains(String nom);

    List<Concert> findByNomPrix(String nom, Double prix);

    List<Concert> findByGenre(Genre categorie);

    List<Concert> findByGenreIdGenre(Long id);

    List<Concert> findByOrderByNomConcertAsc();
    
    List<Concert> TrierConcertsNomsPrix();
    
    List<Genre> getAllGenres();

}
