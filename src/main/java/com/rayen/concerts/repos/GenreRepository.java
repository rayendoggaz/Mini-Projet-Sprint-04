package com.rayen.concerts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayen.concerts.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
