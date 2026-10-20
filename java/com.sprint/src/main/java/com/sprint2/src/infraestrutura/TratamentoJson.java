package com.sprint2.src.infraestrutura;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint2.src.ia.domain.Prompt;
import com.sprint2.src.ia.domain.Resposta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class TratamentoJson{

    private String dadoTratado;
    private Prompt prompt;
    private ArrayList<String> jsonSeparado = new ArrayList<>();

    public TratamentoJson(Prompt prompt){
        this.prompt = prompt;
    }

    public String tratamentoDado() throws SQLException{

        dadoTratado = new Resposta(prompt.chat()).getResposta();

        if(dadoTratado != null){
            dadoTratado = dadoTratado.replace("\\n", "").replace("\\", "");
            dadoTratado = dadoTratado
                    .replace("```json", "")
                    .replace("```", "")
                    .trim();

            return dadoTratado;
        }
        return "vazio" ;
    }

    public ArrayList<String> separamentoDado() throws JsonProcessingException, SQLException {
        ObjectMapper mapeador = new ObjectMapper();

        JsonNode json = mapeador.readTree(tratamentoDado());

        jsonSeparado.add(json.path("dores").asText(""));
        jsonSeparado.add(json.path("produto").asText(""));
        jsonSeparado.add(json.path("risco").asText(""));
        jsonSeparado.add(json.path("solucao").asText(""));
        jsonSeparado.add(json.path("grau_urgencia").asText(""));

        return jsonSeparado;
    }

    @GetMapping("/dadoFinal")
    public ArrayList<String> dadoFinal() throws SQLException, JsonProcessingException {
        return separamentoDado();
    }

}
