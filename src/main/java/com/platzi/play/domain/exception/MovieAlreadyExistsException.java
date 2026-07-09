package com.platzi.play.domain.exception;

import com.platzi.play.persistence.entity.MovieEntity;

public class MovieAlreadyExistsException extends RuntimeException{

    public MovieAlreadyExistsException(String movieTitle) {
        super("Movie with title '" + movieTitle + "' already exists.");
    }
}
