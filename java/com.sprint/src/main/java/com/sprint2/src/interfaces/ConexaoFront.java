package com.sprint2.src.interfaces;

import com.sprint2.src.domain.cliente.InfoCliente;
import com.sprint2.src.dao.Consulta;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ConexaoFront extends InfoCliente {
    @PostMapping("/login")
    public boolean login(@RequestBody ConexaoFront json) throws SQLException, InterruptedException {

        setEmail(json.getEmail());

        String e = json.getEmail();
        String s = json.getSenha();

        System.out.println(getEmail());

        return Consulta.consultaEmail(e,s);
    }

}
