package com.sprint2.src.infraestrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Filtro {

    private int id_con ;
    private String id_cliente ;
    private String nota_nps_reu;
    private Date dt_conversa;
    private String tr_conversa;

    public int getId_con() {
        return id_con;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public String getNota_nps() {
        return nota_nps_reu;
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
        String sql = String.format("SELECT * FROM reuniao WHERE pk_reu = %s", id_con );

        try {
            conecao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teste1", "backend_sprint", "senha_do_backend");
            System.out.println(sql);
            ResultSet puxarReuniao = conecao.createStatement().executeQuery(sql);

            long currentTimeMillis = 1622548800000L;
            java.sql.Date sqlDate = new java.sql.Date(currentTimeMillis);

            while (puxarReuniao.next()) {
                int id_conv = puxarReuniao.getInt(1);
                String id_clie = puxarReuniao.getString(2);
                String nota_nps = puxarReuniao.getString(3);
                Date dt_conv = puxarReuniao.getDate(5);
                String tr_conv = puxarReuniao.getString(4);

                id_con = id_conv;
                id_cliente = id_clie;
                nota_nps_reu = nota_nps;
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

        GuardaInfo infoPuxada = new GuardaInfo(id_con,id_cliente,nota_nps_reu,dt_conversa,tr_conversa);
        return infoPuxada;

    }

}
