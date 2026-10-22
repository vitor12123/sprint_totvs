package com.sprint2.src.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sprint2.src.dao.PegaRelatorioIa;
import com.sprint2.src.domain.model.TratamentoJson;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ReuniaoRepo {

    private final TratamentoJson tratamentoJson;

    public ReuniaoRepo(TratamentoJson tratamentoJson) {
        this.tratamentoJson = tratamentoJson;
    }

    @GetMapping("/repo/{id}")
    public Map<String, Object> dadosRepoEspecifico(@PathVariable int id) throws SQLException, JsonProcessingException {

        System.out.println("definiu o id: " + id);

        PegaRelatorioIa pegaRelatorioIa = new PegaRelatorioIa();

        // Só chama o Gemini se essa reunião ainda não tiver relatório salvo
        if (pegaRelatorioIa.existeRelatorio(id)) {
            System.out.println("relatorio ja existe, nao chamou o Gemini");
        } else {
            tratamentoJson.gerarRelatorio(id);
        }

        System.out.println("chegou no front");

        return pegaRelatorioIa.filtro_para_RepoEspecifico(id);
    }
}