package com.amal.piece.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amal.piece.entities.Piece;

public interface PieceRepository extends JpaRepository<Piece, Long> {

}
