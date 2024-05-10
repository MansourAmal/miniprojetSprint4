package com.amal.piece.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amal.piece.entities.Genre;

public interface GenreRepository  extends JpaRepository<Genre, Long> {

}
