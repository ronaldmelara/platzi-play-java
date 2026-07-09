package com.platzi.play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;


@AiService
public interface PlatziPlayAIService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de gestión de películas {{plataform}}. Usa menos de 120 caracteres y hazlo con un estilo amigable.
            """)
    String generateGreating(@V("plataform") String plataform);

    @SystemMessage("""
            Eres un asistente de recomendación de películas. 
            Tu tarea es generar una sugerencia de película basada en el mensaje del usuario.
            La respuesta debe ser breve, amigable y contener el título de la película y una breve descripción. Debess recomendar maximo 3 peliculas. No incluyas
            películas que estén por fuera de la plataforma PlatziPlay
            """)
    String generateMovieSuggestion(@UserMessage String userMessage);
}
