package com.sprint2.src.ia.domain;

import reactor.core.publisher.Mono;

public class Resposta extends Prompt{

    private String resposta ;

     public Resposta(String resposta){
        this.resposta = resposta;
     }

    public String getResposta() {
        return resposta;
    }

}
