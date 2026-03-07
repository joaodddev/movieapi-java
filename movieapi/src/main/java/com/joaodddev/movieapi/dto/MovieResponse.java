package com.joaodddev.movieapi.dto;

import lombok.Data;
import java.util.List;

@Data
public class MovieResponse {

    private List<Movie> Search;
    private String totalResults;
    private String Response;

    @Data
    public static class Movie {
        private String Title;
        private String Year;
        private String imdbID;
        private String Type;
        private String Poster;
    }
}