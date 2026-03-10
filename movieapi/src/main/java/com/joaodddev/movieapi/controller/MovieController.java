package com.joaodddev.movieapi.controller;

import com.joaodddev.movieapi.dto.MovieRequestDTO;
import com.joaodddev.movieapi.dto.MovieResponseDTO;
import com.joaodddev.movieapi.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {
    
    @Autowired
    private MovieService movieService;
    
    // GET - Listar todos os filmes
    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>> findAll() {
        List<MovieResponseDTO> movies = movieService.findAll();
        return ResponseEntity.ok(movies);
    }
    
    // GET - Buscar filme por ID
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> findById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // POST - Criar novo filme
    @PostMapping
    public ResponseEntity<MovieResponseDTO> create(@Valid @RequestBody MovieRequestDTO movieDTO) {
        try {
            MovieResponseDTO createdMovie = movieService.save(movieDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    // PUT - Atualizar filme existente
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> update(
            @PathVariable Long id, 
            @Valid @RequestBody MovieRequestDTO movieDTO) {
        return movieService.update(id, movieDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // DELETE - Remover filme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (movieService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // GET - Buscar por título
    @GetMapping("/search")
    public ResponseEntity<List<MovieResponseDTO>> searchByTitle(
            @RequestParam String title) {
        List<MovieResponseDTO> movies = movieService.findByTitle(title);
        return ResponseEntity.ok(movies);
    }
    
    // GET - Filtrar por gênero
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieResponseDTO>> findByGenre(
            @PathVariable String genre) {
        List<MovieResponseDTO> movies = movieService.findByGenre(genre);
        return ResponseEntity.ok(movies);
    }
    
    // GET - Filtrar por ano
    @GetMapping("/year/{year}")
    public ResponseEntity<List<MovieResponseDTO>> findByYear(
            @PathVariable Integer year) {
        List<MovieResponseDTO> movies = movieService.findByYear(year);
        return ResponseEntity.ok(movies);
    }
    
    // GET - Filtrar por nota mínima
    @GetMapping("/rating")
    public ResponseEntity<List<MovieResponseDTO>> findByMinimumRating(
            @RequestParam Double min) {
        List<MovieResponseDTO> movies = movieService.findByMinimumRating(min);
        return ResponseEntity.ok(movies);
    }
}