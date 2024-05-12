package com.rayen.concerts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rayen.concerts.entities.Concert;
import com.rayen.concerts.entities.Genre;


@RepositoryRestResource(path = "rest")
public interface ConcertRepository extends JpaRepository<Concert, Long> {
	List<Concert> findByNomConcert(String nom);
    List<Concert> findByNomConcertContains(String nom);
    
    @Query("SELECT c FROM Concert c WHERE c.nomConcert LIKE %:nom AND c.prixConcert > :prix")
    List<Concert> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);
    
    @Query("SELECT c FROM Concert c WHERE c.genre = ?1")
    List<Concert> findByGenre(Genre genre);
    
    List<Concert> findByGenreIdGenre(Long id);
    
    List<Concert> findByOrderByNomConcertAsc();
    
    @Query("SELECT c FROM Concert c ORDER BY c.nomConcert ASC, c.prixConcert DESC")
    List<Concert> trierConcertsNomsPrix();
}