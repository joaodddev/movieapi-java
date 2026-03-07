package com.joaodddev.movieapi.controller;

import com.joaodddev.movieapi.dto.MovieResponse;
import com.joaodddev.movieapi.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public MovieResponse buscar(@RequestParam String nome) {
        return service.buscarFilmes(nome);
    }
}
