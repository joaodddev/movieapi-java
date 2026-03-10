package com.joaodddev.movieapi.repository;

import com.joaodddev.movieapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    // Buscar filmes por título (ignorando maiúsculas/minúsculas)
    List<Movie> findByTitleContainingIgnoreCase(String title);
    
    // Buscar filmes por gênero
    List<Movie> findByGenreIgnoreCase(String genre);
    
    // Buscar filmes por ano de lançamento
    List<Movie> findByReleaseYear(Integer year);
    
    // Buscar filmes por diretor
    List<Movie> findByDirectorContainingIgnoreCase(String director);
    
    // Query personalizada para buscar filmes com nota maior que um valor
    @Query("SELECT m FROM Movie m WHERE m.imdbRating >= :rating")
    List<Movie> findByMinimumRating(@Param("rating") Double rating);
    
    // Buscar filmes por gênero e ano
    List<Movie> findByGenreIgnoreCaseAndReleaseYear(String genre, Integer year);
    
    // Verificar se existe filme com o mesmo título (para evitar duplicatas)
    boolean existsByTitleIgnoreCase(String title);
}