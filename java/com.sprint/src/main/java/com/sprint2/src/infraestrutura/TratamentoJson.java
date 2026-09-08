package com.sprint2.src.infraestrutura;

import com.sprint2.src.ia.domain.Resposta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TratamentoJson {

    Resposta dado = new Resposta();
    String dadoTratado = dado.getResposta();

    public String TratamentoDado() {
        if(dadoTratado != null){
            dadoTratado = dadoTratado.replace("\\n", "").replace("\\", "");
            return dadoTratado;
        }
        else{
            return "vazio";
        }
    }

    @GetMapping("/dadoTratado")
    public String getDadoTratado() {
        return dadoTratado;
    }

}
