package com.sprint2.src.IA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class Prompt {
    @Autowired
    private IAService iaService;

    @Autowired
    private TextoCompleto textoCompleto;

    public String pergunta() throws SQLException {
        return """
                gemini analise qual o assunto da chamada, veja tambem quais foram
                os produtos citados da TOTVS e classifique se ele foi citado por algum problema,
                 se foi citado por algum problema diga qual o problema: """ + textoCompleto.reuniaoCompleta(12);
    }

    @PostMapping("/chat")
    public Resposta chat() throws SQLException {

        String mensagem = this.pergunta();

        String respostaIA =iaService.perguntar(mensagem);

        return new Resposta(respostaIA);
    }

}
