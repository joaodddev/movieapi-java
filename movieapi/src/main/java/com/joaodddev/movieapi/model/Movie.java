package com.joaodddev.movieapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 200)
    private String title;
    
    @Column(length = 1000)
    private String synopsis;
    
    @Column(nullable = false, length = 100)
    private String genre;
    
    @Column(name = "release_year")
    private Integer releaseYear;
    
    @Column(length = 150)
    private String director;
    
    private Integer duration;
    
    @Column(name = "imdb_rating")
    private Double imdbRating;
    
    @Column(name = "poster_url", length = 500)
    private String posterUrl;
}