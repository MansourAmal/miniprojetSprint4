package com.amal.piece.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amal.piece.entities.Piece;
import com.amal.piece.service.PieceService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PieceRESTController {
	@Autowired
	PieceService pieceService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Piece> getAllPieces() {
	return pieceService.getAllPieces();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Piece getPieceById(@PathVariable("id") Long id) {
	return pieceService.getPiece(id);
	 }

	@RequestMapping(method = RequestMethod.POST)
	public Piece createProduit(@RequestBody Piece piece) {
	return pieceService.savePiece(piece);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Piece updatePiece(@RequestBody Piece piece) {
	return pieceService.updatePiece(piece);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePiece(@PathVariable("id") Long id)
	{
		pieceService.deletePieceById(id);
	}
	
	@RequestMapping(value="/pieceG/{idG}",method = RequestMethod.GET)
	public List<Piece> getPiecesByGId(@PathVariable("idG") Long idG) {
	return pieceService.findByGenreIdG(idG);
	}
	


}
