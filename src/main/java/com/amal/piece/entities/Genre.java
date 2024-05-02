package com.amal.piece.entities;

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
	private Long idG;
	private String nomG;
	private String descriptionG;
	
	@JsonIgnore
	@OneToMany(mappedBy = "genre")
	private List<Piece> pieces;
	public Genre(String nomG, String descriptionG, List<Piece> pieces) {
		super();
		this.nomG = nomG;
		this.descriptionG = descriptionG;
		this.pieces = pieces;
	}
	public Genre() {
		super();
	}
	public Long getIdG() {
		return idG;
	}
	public void setIdG(Long idG) {
		this.idG = idG;
	}
	public String getNomG() {
		return nomG;
	}
	public void setNomG(String nomG) {
		this.nomG = nomG;
	}
	public String getDescriptionG() {
		return descriptionG;
	}
	public void setDescriptionG(String descriptionG) {
		this.descriptionG = descriptionG;
	}
	public List<Piece> getPieces() {
		return pieces;
	}
	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}
	



}
