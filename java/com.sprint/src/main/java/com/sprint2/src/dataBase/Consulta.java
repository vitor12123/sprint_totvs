package com.sprint2.src.dataBase;

import com.sprint2.src.cliente.InfoCliente;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class Consulta extends InfoCliente {
    static int contador = 0;

    public static boolean consultaEmail(String email, String senha) throws SQLException, InterruptedException {

        boolean resultado = false;

        Connection conexao = null;
        String sql = String.format("SELECT * FROM usuario WHERE email_usu = '%s' AND sn_usu = '%s'", email, senha);

        try {
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teste1", "backend_sprint", "senha_do_backend");
            ResultSet puxarLogin = conexao.createStatement().executeQuery(sql);

            if(puxarLogin.next()){
                resultado = true;
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

        if (resultado){
            System.out.println(contador);
            contador = 0;
            return true;
        }
        else{
            System.out.println(contador);
            contador = contador + 1;
            if(contador > 3){
                System.out.println("senha ou email errados muitas vezes espere 5 minutos.");
                Thread.sleep(300000);
                contador = 0;
            }
            return false;
        }


    }
    public static ArrayList<String> consultaLinha(String email) throws SQLException{

        email = getEmail();
        ArrayList<String> listaLogin = new ArrayList<>();

        Connection conexao = null;
        String sql = String.format("SELECT * FROM usuario WHERE email_usu = '%s'", email);
        System.out.println("1");

        try {
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teste1", "backend_sprint", "senha_do_backend");
            ResultSet puxarPessoa = conexao.createStatement().executeQuery(sql);

            System.out.println("2");

            if(puxarPessoa.next()){
                listaLogin.add(puxarPessoa.getString(2));
                System.out.println("2.1");
                listaLogin.add(puxarPessoa.getString(4));
                System.out.println("2.2");
                listaLogin.add(puxarPessoa.getString(5));

                System.out.println("3");
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

        return listaLogin;

    }

}
