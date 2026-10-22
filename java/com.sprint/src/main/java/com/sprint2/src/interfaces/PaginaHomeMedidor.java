package com.sprint2.src.interfaces;

import com.sprint2.src.dao.ConsultaNota;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PaginaHomeMedidor {

    @GetMapping("/home/medidor")
    public ArrayList<Integer> dadosPessoa() throws SQLException {

        ConsultaNota listaNotas = new ConsultaNota();
        listaNotas.consultaMediaNT();

        return ConsultaNota.getListaNotas();
    }

}
