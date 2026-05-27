package com.sprint2.src.dataBase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Filtro {

    private int id_con ;
    private String id_cliente ;
    private int id_reuniao;
    private Date dt_conversa;
    private String tr_conversa;

    public int getId_con() {
        return id_con;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public int getId_reuniao() {
        return id_reuniao;
    }

    public Date getDt_conversa() {
        return dt_conversa;
    }

    public String getTr_conversa() {
        return tr_conversa;
    }

    public GuardaInfo filtrando(int id) throws SQLException {

        id_con = id;

        Connection conecao = null;
        String sql = String.format("SELECT * FROM conv WHERE id_conv = %s", id_con );

        try {
            conecao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/totvs", "root", "vitor784!");
            System.out.println(sql);
            ResultSet puxarReuniao = conecao.createStatement().executeQuery(sql);

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

        GuardaInfo infoPuxada = new GuardaInfo(id_con,id_cliente,id_reuniao,dt_conversa,tr_conversa);
        return infoPuxada;

    }

}
