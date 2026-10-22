package com.sprint2.src.dao;

import java.sql.*;

public class InsereRespostaDao {

    private Connection conectar() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/teste1",
                "backend_sprint",
                "senha_do_backend"
        );
    }

    public void inserir(int id_reu, String dr_cli, String rs_reu, String pr_cli, String rc_ia , String grau_urgencia) throws SQLException {

        System.out.println("chamou a  funcao de inserir");

        Connection conecaoVerificacao = null;
        String sqlVerificacao = String.format("SELECT * FROM relatorio_ia WHERE fk_pk_reu = %s", id_reu );

        String sql = """
            INSERT INTO relatorio_ia
            (FK_PK_reu, dr_cli_rel, rs_rel, pr_cli_rel,rc_rel,grau_urgencia)
            VALUES (?, ?, ?, ?, ?, ?) """;

        try {
            conecaoVerificacao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teste1", "backend_sprint", "senha_do_backend");
            System.out.println(sqlVerificacao);
            ResultSet puxarReuniao = conecaoVerificacao.createStatement().executeQuery(sqlVerificacao);

            if (puxarReuniao.next()) {
                System.out.println("ja inserido!");

            } else {
                try (Connection conexao = conectar();
                     PreparedStatement stmt = conexao.prepareStatement(sql)) {

                    System.out.println("guardou a resposta");

                    stmt.setInt(1, id_reu);
                    stmt.setString(2, dr_cli);
                    stmt.setString(3, rs_reu);
                    stmt.setString(4, pr_cli);
                    stmt.setString(5, rc_ia);
                    stmt.setString(6, grau_urgencia);

                    stmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conecaoVerificacao != null) {
                conecaoVerificacao.close();
            }
        }

    }
}
