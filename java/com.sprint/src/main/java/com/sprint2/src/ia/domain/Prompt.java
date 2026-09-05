package com.sprint2.src.IA.domain;

import com.sprint2.src.IA.application.IAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.sql.SQLException;

@RestController
public class Prompt {

    @Autowired
    private IAService iaService;

    @Autowired
    private TextoCompleto textoCompleto;

    public String pergunta() throws SQLException {
        return """
               analize qual as dores retratadas na reunião em ate 120 caracteres, 
               diga se tem algum produto da TOTVS envolvido na chamada se sim diga qual, 
               identifique possiveis riscos se houver algum em ate 120 caracteres,
               e de uma solução para o problema, uma recomendação que tenha haver com algum produto da totvs em ate 350 caracteres""" + textoCompleto.reuniaoCompleta(1);
    }

    @GetMapping("/chat")
    public Mono<Resposta> chat() throws SQLException {

        String mensagem = this.pergunta();

        return iaService.perguntar(mensagem)
                .map(respostaIA -> new Resposta(respostaIA));
    }
}

