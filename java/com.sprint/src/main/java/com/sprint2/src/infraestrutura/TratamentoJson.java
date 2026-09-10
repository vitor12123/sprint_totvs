package com.sprint2.src.infraestrutura;

import com.sprint2.src.ia.domain.Prompt;
import com.sprint2.src.ia.domain.Resposta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class TratamentoJson{

    private String dadoTratado;
    private Prompt prompt;

    public TratamentoJson(Prompt prompt){
        this.prompt = prompt;
    }

    public String tratamentoDado() throws SQLException{

        dadoTratado = new Resposta(prompt.chat()).getResposta();

        if(dadoTratado != null){
            dadoTratado = dadoTratado.replace("\\n", "").replace("\\", "");
            return dadoTratado;
        }
        return "vazio" ;
    }

    @GetMapping("/dadoFinal")
    public String dadoFinal() throws SQLException{
        return tratamentoDado();
    }

}
