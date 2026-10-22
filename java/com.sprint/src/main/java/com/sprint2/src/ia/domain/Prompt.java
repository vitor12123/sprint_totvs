package com.sprint2.src.ia.domain;

import com.sprint2.src.domain.model.TextoCompleto;
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

    // O id agora é passado como parâmetro (o Prompt é um bean único, compartilhado entre requisições)
    public String pergunta(int idReuniao) throws SQLException {

        String transcricao = textoCompleto.reuniaoCompleta(idReuniao);

        if (transcricao == null || transcricao.isBlank()) {
            throw new IllegalStateException("Nenhuma transcrição encontrada no banco para a reunião " + idReuniao);
        }

        return """
               Analise a transcrição de reunião abaixo e responda APENAS com um objeto JSON, exatamente com estas 5 chaves no primeiro nível:
               {
                 "dores": "dores do cliente retratadas na reunião, em até 120 caracteres",
                 "produto": "produto da TOTVS envolvido na chamada, ou 'nenhum'",
                 "risco": "possíveis riscos, em até 120 caracteres, ou 'nenhum'",
                 "solucao": "solução para o problema, em até 300 caracteres, com uma recomendação de produto TOTVS",
                 "grau_urgencia": "urgência de 0 a 10 de acordo com as dores, como String com no máximo 2 casas decimais"
               }
               Não use outras chaves, não aninhe objetos e não use listas.
               Transcrição: """ + transcricao;
    }

    public String chat(int idReuniao) throws SQLException {

        System.out.println("puxou a classe do prompt e provavelmente foi para o gemini fazer o trabalho");

        String mensagem = pergunta(idReuniao);

        return iaService.perguntar(mensagem).block();
    }

}