package com.joaodddev.movieapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDTO {
    private Long id;
    private String title;
    private String synopsis;
    private String genre;
    private Integer releaseYear;
    private String director;
    private Integer duration;
    private Double imdbRating;
    private String posterUrl;
}