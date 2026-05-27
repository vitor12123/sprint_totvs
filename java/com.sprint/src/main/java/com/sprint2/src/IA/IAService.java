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

    public String pergunta(String mensagem) {

        WebClient client = WebClient.create();

        try{
            Map<String,Object> normalizacaoMensagem= Map.of(
            "contents", List.of(
                "parts", List.of(
                            Map.of("text",mensagem)
                            )
                    )
            );
        }
        catch (){

        }

    }

}
