package com.sprint2.src.IA;

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
               analise qual o assunto da chamada, veja tambem quais foram
               os produtos citados da totvs e classifique se ele foi citado por algum problema,
                se foi citado por algum problema diga qual o problema: """ + textoCompleto.reuniaoCompleta(1);
    }

    @GetMapping("/chat")
    public Mono<Resposta> chat() throws SQLException {

        String mensagem = this.pergunta();

        return iaService.perguntar(mensagem)
                .map(respostaIA -> new Resposta(respostaIA));
    }
}

