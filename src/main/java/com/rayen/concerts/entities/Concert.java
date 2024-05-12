package com.rayen.concerts.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Concert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConcert;
	
	@NotNull
	@Size(min = 4,max = 15)
	private String nomConcert;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixConcert;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent
	private Date dateConcert;

	@ManyToOne
	private Genre genre;
	
	public Concert() {
		super();
	}
	
	public Concert(String nomConcert, Double prixConcert, Date dateConcert) {
		super();
		this.nomConcert = nomConcert;
		this.prixConcert = prixConcert;
		this.dateConcert = dateConcert;
	}


	public Long getIdConcert() {
		return idConcert;
	}
	
	public void setIdConcert(Long idConcert) {
		this.idConcert = idConcert;
	}
	
	public String getNomConcert() {
		return nomConcert;
	}
	
	public void setNomConcert(String nomConcert) {
		this.nomConcert = nomConcert;
	}
	
	public Double getPrixConcert() {
		return prixConcert;
	}
	
	public void setPrixConcert(Double prixConcert) {
		this.prixConcert = prixConcert;
	}
	
	public Date getDateConcert() {
		return dateConcert;
	}
	
	public void setDateConcert(Date dateConcert) {
		this.dateConcert = dateConcert;
	}

	@Override
	public String toString() {
		return "Concert [idConcert=" + idConcert + ", nomConcert=" + nomConcert + ", prixConcert=" + prixConcert
				+ ", dateConcert=" + dateConcert + "]";
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
