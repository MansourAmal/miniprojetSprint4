package com.amal.piece.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPiece", types = { Piece.class })
public interface PieceProjection {
	public String getNomPiece();

}
