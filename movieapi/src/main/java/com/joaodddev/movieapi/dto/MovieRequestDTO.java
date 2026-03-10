package com.joaodddev.movieapi.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequestDTO {
    
    @NotBlank(message = "Título é obrigatório")
    @Size(min = 1, max = 200, message = "Título deve ter entre 1 e 200 caracteres")
    private String title;
    
    @Size(max = 1000, message = "Sinopse deve ter no máximo 1000 caracteres")
    private String synopsis;
    
    @NotBlank(message = "Gênero é obrigatório")
    @Size(max = 100, message = "Gênero deve ter no máximo 100 caracteres")
    private String genre;
    
    @Min(value = 1888, message = "Ano deve ser maior ou igual a 1888")
    @Max(value = 2026, message = "Ano deve ser menor ou igual a 2026")
    private Integer releaseYear;
    
    @Size(max = 150, message = "Diretor deve ter no máximo 150 caracteres")
    private String director;
    
    @Min(value = 1, message = "Duração deve ser no mínimo 1 minuto")
    @Max(value = 500, message = "Duração deve ser no máximo 500 minutos")
    private Integer duration;
    
    @DecimalMin(value = "0.0", message = "Nota deve ser no mínimo 0.0")
    @DecimalMax(value = "10.0", message = "Nota deve ser no máximo 10.0")
    private Double imdbRating;
    
    @Pattern(regexp = "^(http|https)://.*$", message = "URL da imagem deve ser válida")
    private String posterUrl;
}