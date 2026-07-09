package com.platzi.play.domain.service;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las películas que existan dentro de la plataforma")
    public List<MovieDto> getAll(){

        return movieRepository.getAll();
    }

    public MovieDto getById(long id){
        return movieRepository.getById(id);
    }

    public MovieDto save(MovieDto movieDto){
        return movieRepository.save(movieDto);
    }

    public MovieDto update(long id, UpdateMovieDto movieDto){
        return movieRepository.update(id, movieDto);
    }
}
