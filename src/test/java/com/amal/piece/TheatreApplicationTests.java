package com.amal.piece;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

import com.amal.piece.entities.Piece;
import com.amal.piece.repos.PieceRepository;
import com.amal.piece.service.PieceService;

@SpringBootTest
class TheatreApplicationTests {

	@Autowired
	private PieceRepository pieceRepository;
	
	@Autowired
	PieceService pieceService;
	@Test
	 public void testFindByNomPiecetContains()
	 {
		 Page<Piece> prods =pieceService.getAllPiecesParPage(0,2);
		 System.out.println(prods.getSize());
		 System.out.println(prods.getTotalElements());
		 System.out.println(prods.getTotalPages());
		 prods.getContent().forEach(p -> {System.out.println(p.toString());
		});
		 /*ou bien
		 for (Piece p : pieces)
		 {
		 System.out.println(p);
		 } */
	 }
	
	@Test
	public void testCreatePiece() {
		Piece piece = new Piece("hamlet","william sheakspear",new Date());
	pieceRepository.save(piece);
	}
	@Test
	public void testFindPiece()
	{
		Piece p = pieceRepository.findById(2L).get(); 
		System.out.println(p);
	}
	
	@Test
	public void testUpdatePiece()
	{
		Piece p = pieceRepository.findById(2L).get();
		p.setAuteurPiece("william");;
		pieceRepository.save(p);
	}
	@Test
	public void testDeletePiece()
	{
		pieceRepository.deleteById(2L);;
	}
	 
	@Test
	public void testListerTousPieces()
	{
		List<Piece> pieces = pieceRepository.findAll();
		for (Piece p : pieces)
		{
		System.out.println(p);
		}
	}
	
	 

	



}
