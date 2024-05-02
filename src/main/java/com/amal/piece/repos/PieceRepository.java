package com.amal.piece.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.amal.piece.entities.Genre;
import com.amal.piece.entities.Piece;

@RepositoryRestResource(path ="rest")
public interface PieceRepository extends JpaRepository<Piece, Long> {
	List<Piece> findByNomPiece(String nom);
	List<Piece> findByNomPieceContains(String nom);
	@Query("select p from Piece p where p.nomPiece like %?1 and p.auteurPiece > ?2")
	List<Piece> findByNomAuteur (@Param("nom")  String nom,@Param("Auteur")  String auteur);
	
	@Query("select p from Piece p where p.genre = ?1")
	List<Piece> findByGenre (Genre genre);
	
	List<Piece> findByGenreIdG(Long id);
	
	List<Piece> findByOrderByNomPieceAsc();
	
	@Query("select p from Piece p order by p.nomPiece ASC, p.auteurPiece DESC")
	List<Piece> trierPiecesNomsAuteur ();





}
