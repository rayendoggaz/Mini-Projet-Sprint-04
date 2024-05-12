package com.rayen.concerts.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenre;

    private String nomGenre;

    private String descriptionGenre;

    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    private List<Concert> concerts;

    public Genre(String nomGenre, String descriptionGenre, List<Concert> concerts) {
        super();
        this.nomGenre = nomGenre;
        this.descriptionGenre = descriptionGenre;
        this.concerts = concerts;
    }

    public Long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
    }

    public String getNomGenre() {
        return nomGenre;
    }

    public void setNomGenre(String nomGenre) {
        this.nomGenre = nomGenre;
    }

    public String getDescriptionGenre() {
        return descriptionGenre;
    }

    public void setDescriptionGenre(String descriptionGenre) {
        this.descriptionGenre = descriptionGenre;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }
}
