package com.sprint2.src.IA;

import com.sprint2.src.dataBase.GuardaInfo;
import com.sprint2.src.dataBase.Filtro;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class teste {

    private Filtro info;

    @GetMapping("/definir/{id}")
    public GuardaInfo definir(@PathVariable int id) throws SQLException {

        info = new Filtro();

        return info.filtrando(id);
    }
}
