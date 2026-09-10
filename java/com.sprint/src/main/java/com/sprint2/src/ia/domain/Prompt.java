package com.sprint2.src.ia.domain;

import com.sprint2.src.ia.application.IAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
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
               e de uma solução para o problema em ate 300, uma recomendação que tenha haver com algum produto da totvs em ate 100 caracteres,
               retorne em formato json, sendo o item 1 nomeado: dores. Item 2: produto. Item 3: risco. Item 4: recomendacao, segue o texto: """ + textoCompleto.reuniaoCompleta(835960);
    }

    public String chat() throws SQLException {

        String mensagem = pergunta();

        return iaService.perguntar(mensagem).block();
    }

}

