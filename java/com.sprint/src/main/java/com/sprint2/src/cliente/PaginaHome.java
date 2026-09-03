package com.sprint2.src.cliente;

import com.sprint2.src.dataBase.Consulta;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "https://localhost:5173")
public class PaginaHome extends InfoCliente {

    @GetMapping("/pessoa")
    public ArrayList<String> dadosPessoa() throws SQLException {
        System.out.println("4");
        return Consulta.consultaLinha(getEmail());
    }

}
