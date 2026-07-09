package com.platzi.play.web.controller;

import com.platzi.play.domain.dto.SuggestRequestDto;
import com.platzi.play.domain.service.PlatziPlayAIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ia")
public class HelloController {
    private final String plataform;

    private final PlatziPlayAIService aiService;
    public HelloController(@Value("${spring.application.name}") String plataform, PlatziPlayAIService aiService){
        this.aiService = aiService;
        this.plataform = plataform;
    }
    @GetMapping("/hello")
    public String hello(){
        return this.aiService.generateGreating(plataform);
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto userPreference){
        return ResponseEntity.ok(this.aiService.generateMovieSuggestion(userPreference.userPreference()));
    }
}
