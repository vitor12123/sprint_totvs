package com.sprint2.src.infraestrutura;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class Tudo {
    private int id_con ;
    private String id_cliente ;
    private String nota_nps;
    private Date dt_conversa;

    ArrayList<Object> reunioes_id = new ArrayList<>();

    @GetMapping("/tudo")
    public ArrayList puxa_tot(int id) throws SQLException {
        ArrayList<Object> reunioes_id = new ArrayList<>();

        Connection conecao = null;
        String sql = String.format("SELECT * FROM reuniao WHERE numero = %s", id);

        try {
            conecao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teste1", "backend_sprint", "senha_do_backend");
            System.out.println(sql);
            ResultSet puxarReuniao = conecao.createStatement().executeQuery(sql);

            long currentTimeMillis = 1622548800000L;
            java.sql.Date sqlDate = new java.sql.Date(currentTimeMillis);

            while (puxarReuniao.next()) {
                int id_conv = puxarReuniao.getInt(1);
                String id_clie = puxarReuniao.getString(2);
                String nota = puxarReuniao.getString(3);
                Date dt_conv = puxarReuniao.getDate(5);

                id_con = id_conv;
                id_cliente = id_clie;
                nota_nps = nota;
                dt_conversa = dt_conv;

                reunioes_id.add(id_con);
                reunioes_id.add(id_cliente);
                reunioes_id.add(nota_nps);
                reunioes_id.add(dt_conversa);
            }

        } catch (SQLException eSQl) {
            System.out.println("erro ao tentar acessar o banco de dados " + eSQl.getMessage());
        } finally {
            if (conecao != null) {
                conecao.close();
            }
        }
        return reunioes_id;
    }

}