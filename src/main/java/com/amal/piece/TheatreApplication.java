package com.amal.piece;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amal.piece.entities.Piece;
import com.amal.piece.service.PieceService;

@SpringBootApplication
public class TheatreApplication implements CommandLineRunner{
	@Autowired
	PieceService pieceService;

	public static void main(String[] args) {
		SpringApplication.run(TheatreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		pieceService.savePiece(new Piece("romio et juliette" ,"william sheackspar",new Date()));
		pieceService.savePiece(new Piece("Antigone" ,"Jean Anouilh",new Date()));
		pieceService.savePiece(new Piece("Cyrano de Bergerac " ,"Edmond Rostand",new Date()));

		
	}

}
