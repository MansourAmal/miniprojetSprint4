package com.amal.piece;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

import com.amal.piece.entities.Genre;
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
	
	@Test
	public void testFindByNomPiece()
	{
		List<Piece> pieces = pieceRepository.findByNomPiece("Hamlet");
		for (Piece p : pieces)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testFindByNomPieceContains()
	{
		List<Piece> pieces = pieceRepository.findByNomPieceContains("A");
		for (Piece p : pieces)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByNomAuteur()
	{
		List<Piece> prods = pieceRepository.findByNomAuteur("Hamlet", "william");
		for (Piece p : prods)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testfindByGenre()
	{
		Genre gen = new Genre();
		gen.setIdG(1L);
		List<Piece> pieces = pieceRepository.findByGenre(gen);
		for (Piece p : pieces)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void findByGenreIdG()
	{
		List<Piece> prods = pieceRepository.findByGenreIdG(1L);
		for (Piece p : prods)
		{
			System.out.println(p);
		}
	 }
	
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
		List<Piece> prods = pieceRepository.findByOrderByNomPieceAsc();
		for (Piece p : prods)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void testTrierPiecesNomsAuteur()
	{
		List<Piece> prods = pieceRepository.trierPiecesNomsAuteur();
		for (Piece p : prods)
		{
			System.out.println(p);
		}
	}



	
	

	
	 

	



}
