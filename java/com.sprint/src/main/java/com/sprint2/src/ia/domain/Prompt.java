package com.sprint2.src.ia.domain;

import com.sprint2.src.ia.application.IAService;
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
               e de uma solução para o problema em ate 300, uma recomendação que tenha haver com algum produto da totvs em ate 100 caracteres,
               retorne em formato json, sendo o item 1 nomeado: dores. Item 2: produto. Item 3: risco. Item 4: recomendacao """ + textoCompleto.reuniaoCompleta(718987);
    }

    @GetMapping("/chat")
    public Mono<Resposta> chat() throws SQLException {

        String mensagem = this.pergunta();
        Resposta resposta = new Resposta();

        return iaService.perguntar(mensagem)
                .map(respostaIA -> {resposta.setResposta(respostaIA);
                    return resposta;});
    }
}

