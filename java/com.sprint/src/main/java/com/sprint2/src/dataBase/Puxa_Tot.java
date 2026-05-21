package com.sprint2.src.dataBase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

@RestController
public class Puxa_Tot {

    //private int id_con ;
    //rivate String id_cliente ;
    private int id_reuniao;
    //private Date dt_conversa;

    //GuardaInfo infoPuxada = new GuardaInfo(id_con,id_cliente,id_reuniao,dt_conversa);

    @GetMapping("/puxar_tot")
    public String puxa_tot() throws SQLException {

        Scanner input = new Scanner(System.in);
        System.out.println("digite qual o id da conversa que vc deseja pegar: ");

        //id_con = input.nextInt();

        Connection conecao = null;
        String sql = String.format("SELECT * FROM conv");//  WHERE id_meet = %s", id_con );

        try {
            conecao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/totvs", "root", "vitor784!");
            System.out.println(sql);
            ResultSet puxarReuniao = conecao.createStatement().executeQuery(sql);

            long currentTimeMillis = 1622548800000L;
            java.sql.Date sqlDate = new java.sql.Date(currentTimeMillis);

            while (puxarReuniao.next()) {
                //int id_conv = puxarReuniao.getInt(1);
                //String id_clie = puxarReuniao.getString(2);
                int id_meet = puxarReuniao.getInt(3);
                //Date dt_conv = puxarReuniao.getDate(4);
                //String tr_conv = puxarReuniao.getString(5);

                //id_con = id_conv;
                //id_cliente = id_clie;
                id_reuniao = id_meet;
                //dt_conversa = dt_conv;

                //return ("\n id da ligação: \n" + id_meet );
                System.out.println("\n id da ligação: \n" + id_meet);

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



        return "deu BO";
    }

}
