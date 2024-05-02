package com.amal.piece.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amal.piece.entities.Piece;
import com.amal.piece.service.PieceService;


@Controller
public class PieceController {
	
	@Autowired
	PieceService pieceService;
	 @RequestMapping("/listePieces")
	public String listePieces(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		  
		Page<Piece> pieces = pieceService.getAllPiecesParPage(page, size);
		modelMap.addAttribute("pieces", pieces);
		modelMap.addAttribute("pages", new int[pieces.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listePieces";
	}
	 
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createPiece";
	}
	
	@RequestMapping("/savePiece")
	public String savePiece(@ModelAttribute("piece") Piece piece, 
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 piece.setDateCreation(dateCreation);
	 
		Piece savePiece = pieceService.savePiece(piece);
		String msg ="piece enregistré avec Id "+savePiece.getIdPiece();
		modelMap.addAttribute("msg", msg);
		return "createPiece";
	}
	
	 
	 @RequestMapping("/supprimerPiece")
	public String supprimerPiece(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{ 
		pieceService.deletePieceById(id);
		Page<Piece> pieces = pieceService.getAllPiecesParPage(page, size);
		modelMap.addAttribute("pieces", pieces);
		modelMap.addAttribute("pages", new int[pieces.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listePieces";
	}
	 
	 
	 @RequestMapping("/modifierPiece")
	public String editerPiece(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Piece p= pieceService.getPiece(id);
		modelMap.addAttribute("piece", p);
		return "editerPiece";
	}
	 
	@RequestMapping("/updatePiece")
	public String updatePiece(@ModelAttribute("piece") Piece piece, @RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 piece.setDateCreation(dateCreation);
	 
		 pieceService.updatePiece(piece);
		 List<Piece> pieces = pieceService.getAllPieces();
		 modelMap.addAttribute("pieces", pieces);
		 return "listePieces";
	}

}
