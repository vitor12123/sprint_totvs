package com.sprint2.src.interfaces;

import com.sprint2.src.infraestrutura.GuardaInfo;
import com.sprint2.src.infraestrutura.Tudo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Clientes {

    @GetMapping("/cliente")
    public ArrayList<ArrayList<Object>> dadosPessoa() throws SQLException {

        Tudo tudo = new Tudo();

        ArrayList<ArrayList<Object>> listaTodasReu = new ArrayList<>();

        
        for (int i = 1; i < 1128; i++) {
            ArrayList<Object> porReu = tudo.puxa_tot(i);

            if (porReu.size() == 4) {
                listaTodasReu.add(porReu);
            }
        }

        System.out.println(listaTodasReu);

        return listaTodasReu;
    }
}
