package com.sprint2.src.dataBase;

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
    private int id_reuniao;
    private Date dt_conversa;
    private String tr_conversa;

    GuardaInfo infoPuxada = new GuardaInfo(id_con,id_cliente,id_reuniao,dt_conversa,tr_conversa);

    ArrayList<Object> reunioes_id = new ArrayList<>();

    @GetMapping("/puxar_tudo")
    public ArrayList puxa_tot() throws SQLException {

        Connection conecao = null;

        try {
            conecao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/totvs", "root", "vitor784!");
            ResultSet puxarReuniao = conecao.createStatement().executeQuery("SELECT * FROM conv");

            long currentTimeMillis = 1622548800000L;
            java.sql.Date sqlDate = new java.sql.Date(currentTimeMillis);

            while (puxarReuniao.next()) {
                int id_conv = puxarReuniao.getInt(1);
                String id_clie = puxarReuniao.getString(2);
                int id_meet = puxarReuniao.getInt(3);
                Date dt_conv = puxarReuniao.getDate(4);
                String tr_conv = puxarReuniao.getString(5);

                id_con = id_conv;
                id_cliente = id_clie;
                id_reuniao = id_meet;
                dt_conversa = dt_conv;
                tr_conversa = tr_conv;

                reunioes_id.add(id_con);
                reunioes_id.add(id_cliente);
                reunioes_id.add(id_reuniao);
                reunioes_id.add(dt_conversa);
                reunioes_id.add(tr_conversa);

            }

        }
        catch(SQLException eSQl){
            System.out.println("erro ao tentar acessar o banco de dados " + eSQl.getMessage());
        }
        finally {
            if (conecao != null){
                conecao.close();
            }
        }
        return reunioes_id;
    }

}
