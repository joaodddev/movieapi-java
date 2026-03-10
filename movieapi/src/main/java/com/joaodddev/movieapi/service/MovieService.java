package com.joaodddev.movieapi.service;

import com.joaodddev.movieapi.dto.MovieRequestDTO;
import com.joaodddev.movieapi.dto.MovieResponseDTO;
import com.joaodddev.movieapi.model.Movie;
import com.joaodddev.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    
    // Converter Entity para DTO (resposta)
    private MovieResponseDTO convertToDTO(Movie movie) {
        return new MovieResponseDTO(
            movie.getId(),
            movie.getTitle(),
            movie.getSynopsis(),
            movie.getGenre(),
            movie.getReleaseYear(),
            movie.getDirector(),
            movie.getDuration(),
            movie.getImdbRating(),
            movie.getPosterUrl()
        );
    }
    
    // Converter DTO (requisição) para Entity
    private Movie convertToEntity(MovieRequestDTO dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setSynopsis(dto.getSynopsis());
        movie.setGenre(dto.getGenre());
        movie.setReleaseYear(dto.getReleaseYear());
        movie.setDirector(dto.getDirector());
        movie.setDuration(dto.getDuration());
        movie.setImdbRating(dto.getImdbRating());
        movie.setPosterUrl(dto.getPosterUrl());
        return movie;
    }
    
    // Listar todos os filmes
    public List<MovieResponseDTO> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Buscar filme por ID
    public Optional<MovieResponseDTO> findById(Long id) {
        return movieRepository.findById(id)
                .map(this::convertToDTO);
    }
    
    // Salvar novo filme
    @Transactional
    public MovieResponseDTO save(MovieRequestDTO movieDTO) {
        // Verificar se já existe filme com mesmo título
        if (movieRepository.existsByTitleIgnoreCase(movieDTO.getTitle())) {
            throw new RuntimeException("Já existe um filme cadastrado com este título");
        }
        
        Movie movie = convertToEntity(movieDTO);
        Movie savedMovie = movieRepository.save(movie);
        return convertToDTO(savedMovie);
    }
    
    // Atualizar filme existente
    @Transactional
    public Optional<MovieResponseDTO> update(Long id, MovieRequestDTO movieDTO) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(movieDTO.getTitle());
                    movie.setSynopsis(movieDTO.getSynopsis());
                    movie.setGenre(movieDTO.getGenre());
                    movie.setReleaseYear(movieDTO.getReleaseYear());
                    movie.setDirector(movieDTO.getDirector());
                    movie.setDuration(movieDTO.getDuration());
                    movie.setImdbRating(movieDTO.getImdbRating());
                    movie.setPosterUrl(movieDTO.getPosterUrl());
                    
                    Movie updatedMovie = movieRepository.save(movie);
                    return convertToDTO(updatedMovie);
                });
    }
    
    // Deletar filme
    @Transactional
    public boolean delete(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Buscar filmes por título
    public List<MovieResponseDTO> findByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Buscar filmes por gênero
    public List<MovieResponseDTO> findByGenre(String genre) {
        return movieRepository.findByGenreIgnoreCase(genre)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Buscar filmes por ano
    public List<MovieResponseDTO> findByYear(Integer year) {
        return movieRepository.findByReleaseYear(year)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Buscar filmes com nota mínima
    public List<MovieResponseDTO> findByMinimumRating(Double rating) {
        return movieRepository.findByMinimumRating(rating)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}