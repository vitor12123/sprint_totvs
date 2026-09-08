package com.sprint2.src.ia.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Resposta {

    private String resposta;

     public void setResposta(String resposta){
        this.resposta = resposta;
     }

    @GetMapping("/resposta")
    public String getResposta() {
        return resposta;
    }

}
