package com.amal.piece.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amal.piece.entities.Genre;
import com.amal.piece.entities.Piece;
import com.amal.piece.service.PieceService;

import jakarta.validation.Valid;


@Controller
public class PieceController {
	
	@Autowired
	PieceService pieceService;
	
	@GetMapping(value = "/") 
	public String welcome() { 
	return "index"; 
	} 
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
	public String showCreate(ModelMap modelMap)
	{
		List<Genre> Gen = pieceService.getAllGenres();
		modelMap.addAttribute("piece", new Piece());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("genres", Gen);
		return "formPiece";
	}
	
	@RequestMapping("/savePiece")
	public String savePiece(@Valid Piece piece, BindingResult bindingResult,
			@RequestParam (name="page",defaultValue = "0") int page, 
			@RequestParam (name="size",defaultValue = "2") int size) { 
			int currentPage; 
			boolean isNew = false;
			if (bindingResult.hasErrors()) return "formPiece";
			if (piece.getIdPiece()==null) 
				isNew=true;
			pieceService.savePiece(piece);
			if (isNew)  
			{ 
			Page<Piece> prods = pieceService.getAllPiecesParPage(page, size); 
			currentPage = prods.getTotalPages()-1; 
			} 
			else  
				currentPage=page;
			return ("redirect:/listePieces?page="+currentPage+"&size="+size);
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
	public String editerPiece(@RequestParam("id") Long id,ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Piece p= pieceService.getPiece(id);
		List<Genre> Gen = pieceService.getAllGenres();
		modelMap.addAttribute("piece", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("genres", Gen);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "formPiece";
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
