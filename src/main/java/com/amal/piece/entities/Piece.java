package com.amal.piece.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Piece {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPiece;
	private String nomPiece;
	private String auteurPiece;
	private Date dateCreation;
	@ManyToOne
	private Genre genre;
	
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Piece(String nomPiece, String auteurPiece, Date dateCreation) {
		super();
		this.nomPiece = nomPiece;
		this.auteurPiece = auteurPiece;
		this.dateCreation = dateCreation;
	}
	public Piece() {
		super();
	}
	public Long getIdPiece() {
		return idPiece;
	}
	public void setIdPiece(Long idPiece) {
		this.idPiece = idPiece;
	}
	public String getNomPiece() {
		return nomPiece;
	}
	public void setNomPiece(String nomPiece) {
		this.nomPiece = nomPiece;
	}
	public String getAuteurPiece() {
		return auteurPiece;
	}
	public void setAuteurPiece(String auteurPiece) {
		this.auteurPiece = auteurPiece;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Piece [idPiece=" + idPiece + ", nomPiece=" + nomPiece + ", auteurPiece=" + auteurPiece
				+ ", dateCreation=" + dateCreation + "]";
	}
	
	
	


}
