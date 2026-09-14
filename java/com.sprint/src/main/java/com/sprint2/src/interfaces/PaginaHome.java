package com.sprint2.src.interfaces;

import com.sprint2.src.cliente.domain.InfoCliente;
import com.sprint2.src.infraestrutura.Consulta;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PaginaHome extends InfoCliente {
    @GetMapping("/pessoa")
    public ArrayList<String> dadosPessoa() throws SQLException {
        return Consulta.consultaLinha(getEmail());
    }
}
