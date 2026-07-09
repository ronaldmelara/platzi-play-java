package com.platzi.play.web.controller;


import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll(){
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a movie by its ID",
            description = "Retrieve a movie's details by providing its unique ID. Returns 404 if the movie is not found.",
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Movie found"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> getById(@Parameter(description = "Identificador de la pelicula. Example: 7") @PathVariable  long id){
        MovieDto movieDto = this.movieService.getById(id);
        if(movieDto == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(movieDto);
    }


    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto){
        // Implement the logic to add a new movie
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.save(movieDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody @Valid UpdateMovieDto movieDto){
        // Implement the logic to update an existing movie
        return ResponseEntity.ok(this.movieService.update(id, movieDto));
    }
}
