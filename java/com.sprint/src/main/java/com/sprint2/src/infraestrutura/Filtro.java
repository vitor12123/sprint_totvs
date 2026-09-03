package com.sprint2.src.infraestrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
            conecao = DriverManager.getConnection("127.0.0.1:3306", "root", "URsFJvwawEyzhtFyGiBDinjmkhrovZpt");
            System.out.println(sql);
            ResultSet puxarReuniao = conecao.createStatement().executeQuery(sql);

            long currentTimeMillis = 1622548800000L;
            java.sql.Date sqlDate = new java.sql.Date(currentTimeMillis);

            while (puxarReuniao.next()) {
                int id_conv = puxarReuniao.getInt(1);
                String id_clie = puxarReuniao.getString(6);
                int id_meet = puxarReuniao.getInt(2);
                Date dt_conv = puxarReuniao.getDate(3);
                String tr_conv = puxarReuniao.getString(4);

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
