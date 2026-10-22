package com.sprint2.src;

import com.sprint2.src.dao.Filtro;
import com.sprint2.src.domain.model.GuardaInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SrcApplicationTests {

	@Test
	void testarFiltro() throws SQLException {

		Filtro filtro = new Filtro();

		GuardaInfo resultado = filtro.filtrando(835960);

		System.out.println(resultado.getTranscricao());

		assertNotNull(resultado);
	}

}
