package com.platzi.play.domain.dto;

import com.platzi.play.domain.Genre;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank( message = "Title is required")
    String title,

    @PastOrPresent(message = "Release date must be in the past or present")
    LocalDate releaseDate,

    @Min(value = 0, message = "Duration must be greater than or equal to 0")
    @Max(value = 5, message = "Duration must be less than or equal to 5 ")
    Double rating

) {

}
