package com.sprint2.src.IA;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IAService {

    @Value("${gemini.api.key}")
    private String apiIA;

    private static final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";

    public String perguntar(String mensagem) {

        WebClient client = WebClient.create();

        try{
            Map<String,Object> normalizacaoMensagem= Map.of(
            "contents", List.of(
                "parts", List.of(
                            Map.of("text",mensagem)
                            )
                    )
            );

            Map resposta = client.post()
                    .uri(GEMINI_URL + "?key=" + apiIA)
                    .header("Content-Type", "application/json")
                    .bodyValue(normalizacaoMensagem)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();


            return extrairTexto(resposta);
        }
        catch (Exception e){
            return "Erro ao conectar com o Gemini: " + e.getMessage();
        }

    }

    private String extrairTexto(Map resposta) {
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
