package com.sprint2.src.ia.domain;

import com.sprint2.src.infraestrutura.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TextoCompleto {

    public String reuniaoCompleta(int id) throws SQLException {
        return new Filtro().filtrando(id).getTranscricao();
    }
}
