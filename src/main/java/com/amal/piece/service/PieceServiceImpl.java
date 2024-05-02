package com.amal.piece.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.amal.piece.entities.Piece;
import com.amal.piece.repos.PieceRepository;

@Service
public class PieceServiceImpl implements PieceService{
	@Autowired
	PieceRepository pieceRepository;


	@Override
	public Piece savePiece(Piece p) {
		return pieceRepository.save(p);
	}

	@Override
	public Piece updatePiece(Piece p) {
		return pieceRepository.save(p);
	}

	@Override
	public void deletePiece(Piece p) {
		pieceRepository.delete(p);
	}

	@Override
	public void deletePieceById(Long id) {
		pieceRepository.deleteById(id);	
	}

	@Override
	public Piece getPiece(Long id) {
		return pieceRepository.findById(id).get();
	}

	@Override
	public List<Piece> getAllPieces() {
		return pieceRepository.findAll();
	}

	@Override
	public Page<Piece> getAllPiecesParPage(int page, int size) {
		return pieceRepository.findAll(PageRequest.of(page, size));

	}
	

}
