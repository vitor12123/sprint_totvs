package com.sprint2.src.domain.ia;

import com.sprint2.src.ia.domain.Prompt;

public class Resposta extends Prompt {

    private String resposta ;

     public Resposta(String resposta){
        this.resposta = resposta;
     }

    public String getResposta() {
        return resposta;
    }

}
