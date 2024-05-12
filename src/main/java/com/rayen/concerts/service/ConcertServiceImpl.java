package com.rayen.concerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rayen.concerts.entities.Concert;
import com.rayen.concerts.entities.Genre;
import com.rayen.concerts.repos.ConcertRepository;
import com.rayen.concerts.repos.GenreRepository;


@Service
public class ConcertServiceImpl implements ConcertService{
	
	@Autowired
    ConcertRepository concertRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@Override
    public Concert saveConcert(Concert concert) {
        return concertRepository.save(concert);
    }

    @Override
    public Concert updateConcert(Concert concert) {
        return concertRepository.save(concert);
    }

    @Override
    public void deleteConcert(Concert concert) {
        concertRepository.delete(concert);
    }

    @Override
    public void deleteConcertById(Long id) {
        concertRepository.deleteById(id);
    }

    @Override
    public Concert getConcert(Long id) {
        return concertRepository.findById(id).get();
    }

    @Override
    public List<Concert> getAllConcerts() {
        return concertRepository.findAll();
    }

	@Override
	public Page<Concert> getAllConcertsParPage(int page, int size) {
		return concertRepository.findAll(PageRequest.of(page, size));
	}

	@Override
    public List<Concert> findByNomConcert(String nom) {
        return concertRepository.findByNomConcert(nom);
    }

    @Override
    public List<Concert> findByNomConcertContains(String nom) {
        return concertRepository.findByNomConcertContains(nom);
    }

    @Override
    public List<Concert> findByNomPrix(String nom, Double prix) {
        return concertRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Concert> findByGenre(Genre genre) {
        return concertRepository.findByGenre(genre);
    }

    @Override
    public List<Concert> findByGenreIdGenre(Long id) {
        return concertRepository.findByGenreIdGenre(id);
    }

    @Override
    public List<Concert> findByOrderByNomConcertAsc() {
        return concertRepository.findByOrderByNomConcertAsc();
    }

	@Override
	public List<Concert> TrierConcertsNomsPrix() {
		return concertRepository.trierConcertsNomsPrix();
	}

	@Override
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}

}
