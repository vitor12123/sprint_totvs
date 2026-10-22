package com.sprint2.src.infraestrutura;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaNota {

    private static ArrayList<Integer> listaNotas = new ArrayList<>();

    public static ArrayList<Integer> getListaNotas() {
        return listaNotas;
    }

    public static void setListaNotas(int listaNotas) {
        ConsultaNota.listaNotas.add(listaNotas);
    }

    public static ArrayList<Integer> consultaMediaNT() throws SQLException {

        Connection conexao = null;
        String sql = String.format("SELECT * FROM reuniao WHERE nt_nps_reu != '%s'","");

        try {
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teste1", "backend_sprint", "senha_do_backend");
            ResultSet puxarNota = conexao.createStatement().executeQuery(sql);

            int transformar;

            while(puxarNota.next()) {
                transformar = Integer.parseInt(puxarNota.getString(3));
                setListaNotas(transformar);
            }


        }
        catch(SQLException eSQl){
            System.out.println("erro ao tentar acessar o banco de dados " + eSQl.getMessage());
        }
        finally {
            if (conexao != null){
                conexao.close();
            }

        }

        return listaNotas;
    }

}
