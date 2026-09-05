package com.sprint2.src.IA.domain;

import com.sprint2.src.infraestrutura.GuardaInfo;
import com.sprint2.src.infraestrutura.Filtro;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class TextoCompleto {

    private Filtro info;

    @GetMapping("/definir/{id}")
    public GuardaInfo definir(@PathVariable int id) throws SQLException {

        info = new Filtro();

        return info.filtrando(id);
    }

    public String reuniaoCompleta(int id) throws SQLException {
        return new Filtro().filtrando(id).getTranscricao();
    }
}
