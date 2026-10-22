package com.sprint2.src.ia.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Service
public class IAService {

    @Value("${gemini.api.key}")
    private String apiIA;

    private String GEMINI_URL;

    public Mono<String> perguntar(String mensagem) {

        WebClient client = WebClient.create();

        try {

            GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                    + apiIA;

            Map<String, Object> normalizacaoMensagem = Map.of(
                    "contents", List.of(
                            Map.of("parts", List.of(
                                    Map.of("text", mensagem)
                            ))
                    ),
                    // Obriga o Gemini a responder só com JSON (sem ```json, sem texto antes/depois)
                    "generationConfig", Map.of("responseMimeType", "application/json")
            );

            return client.post()
                    .uri(GEMINI_URL)
                    .header("Content-Type", "application/json")
                    .bodyValue(normalizacaoMensagem)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .map(resposta -> extrairTexto(resposta))
                    .doOnError(WebClientResponseException.class, e ->
                            System.out.println("Erro do Gemini: " + e.getResponseBodyAsString()));

        } catch (Exception e) {
            return Mono.just("Erro ao montar a requisição: " + e.getMessage());
        }
    }

    private String extrairTexto(Map resposta) {

        if (resposta == null) {
            return "Resposta vazia do Gemini.";
        }

        try {

            List candidates = (List) resposta.get("candidates");
            Map candidate = (Map) candidates.get(0);

            Map content = (Map) candidate.get("content");
            List parts = (List) content.get("parts");

            Map part = (Map) parts.get(0);

            return (String) part.get("text");

        } catch (Exception e) {
            return "Nao consegui entender a resposta do Gemini.";
        }
    }
}