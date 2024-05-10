package com.amal.piece.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amal.piece.entities.Genre;
import com.amal.piece.entities.Piece;

public interface PieceService {
	
	Piece savePiece(Piece p);
	Piece updatePiece(Piece p);
	void deletePiece(Piece p);
	void deletePieceById(Long id);
	Piece getPiece(Long id);
	List<Piece> getAllPieces();
	Page<Piece> getAllPiecesParPage(int page, int size);
	List<Piece> findByNomPiece(String nom);
	List<Piece> findByNomPieceContains(String nom);
	List<Piece> findByNomAuteur (String nom,String auteur);
	List<Piece> findByGenre (Genre genre);
	List<Piece> findByGenreIdG(Long id);
	List<Piece> findByOrderByNomPieceAsc();
	List<Piece> trierPiecesNomsAuteur ();
	
	List<Genre> getAllGenres(); 

}
