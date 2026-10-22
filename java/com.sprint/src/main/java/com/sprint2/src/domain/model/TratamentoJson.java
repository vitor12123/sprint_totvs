package com.sprint2.src.domain.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint2.src.dao.InsereRespostaDao;
import com.sprint2.src.ia.domain.Prompt;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class TratamentoJson {

    private final Prompt prompt;

    // O Spring injeta o Prompt (com IAService e TextoCompleto já preenchidos)
    public TratamentoJson(Prompt prompt) {
        this.prompt = prompt;
    }

    public String tratamentoDado(int idReuniao) throws SQLException {

        System.out.println("puxou a classe tratamento de dados");

        String dadoTratado = prompt.chat(idReuniao);

        System.out.println("resposta crua do Gemini: " + dadoTratado);

        if (dadoTratado != null) {
            return dadoTratado
                    .replace("```json", "")
                    .replace("```", "")
                    .trim();
        }
        return "vazio";
    }

    public ArrayList<String> gerarRelatorio(int idReuniao) throws JsonProcessingException, SQLException {
        ObjectMapper mapeador = new ObjectMapper();

        System.out.println("puxou a classe separamento de dados, esta pronto para ir pro front");

        JsonNode json = mapeador.readTree(tratamentoDado(idReuniao));

        // Lista nova a cada chamada (antes era um campo e acumulava dados de requisições anteriores)
        ArrayList<String> jsonSeparado = new ArrayList<>();
        jsonSeparado.add(json.path("dores").asText(""));
        jsonSeparado.add(json.path("produto").asText(""));
        jsonSeparado.add(json.path("risco").asText(""));
        jsonSeparado.add(json.path("solucao").asText(""));
        jsonSeparado.add(json.path("grau_urgencia").asText(""));

        if (jsonSeparado.get(0).isBlank()) {
            // Não salva relatório vazio: senão o "ja inserido!" impede de gerar de novo depois
            System.out.println("JSON do Gemini veio sem os campos esperados, relatorio NAO foi salvo");
            return jsonSeparado;
        }

        new InsereRespostaDao().inserir(idReuniao, jsonSeparado.get(0), jsonSeparado.get(2),
                jsonSeparado.get(1), jsonSeparado.get(3), jsonSeparado.get(4));

        System.out.println("guardou o relatorio");

        return jsonSeparado;
    }
}
