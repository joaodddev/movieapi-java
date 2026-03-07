package com.joaodddev.movieapi.service;

import com.joaodddev.movieapi.dto.MovieResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    private final String API_KEY = "80a4a132";

    public MovieResponse buscarFilmes(String nome) {

        String url = "http://www.omdbapi.com/?s=" + nome + "&apikey=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, MovieResponse.class);
    }
}