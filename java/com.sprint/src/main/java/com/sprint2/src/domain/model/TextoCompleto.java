package com.sprint2.src.domain.model;

import com.sprint2.src.dao.Filtro;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TextoCompleto {

    public String reuniaoCompleta(int id) throws SQLException {
        return new Filtro().filtrando(id).getTranscricao();
    }
}
