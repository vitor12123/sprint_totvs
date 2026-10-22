package com.sprint2.src.dao;

import java.sql.*;
import java.util.ArrayList;

public class ReuniaoDAO {

    private Connection conectar() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/teste1",
                "backend_sprint",
                "senha_do_backend"
        );
    }

    public void inserir(int idCliente, int nps, String transcricao, Date data)
            throws SQLException {

        String sql = """
            INSERT INTO reuniao
            (FK_PK_cli, NT_NPS_reu, TR_reu, DT_reu)
            VALUES (?, ?, ?, ?)""";

        try (Connection conexao = conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            stmt.setInt(2, nps);
            stmt.setString(3, transcricao);
            stmt.setDate(4, data);

            stmt.executeUpdate();
        }
    }

    public ArrayList<String> consultar() throws SQLException {

        ArrayList<String> reunioes = new ArrayList<>();

        String sql = "SELECT * FROM reuniao";

        try (Connection conexao = conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                reunioes.add(
                        resultado.getInt("PK_reu")
                                + " - "
                                + resultado.getString("TR_reu")
                );
            }
        }

        return reunioes;
    }

    public void atualizar(int idReuniao, int nps)
            throws SQLException {

        String sql = """
            UPDATE reuniao
            SET NT_NPS_reu = ?
            WHERE PK_reu = ?
            """;

        try (Connection conexao = conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, nps);
            stmt.setInt(2, idReuniao);

            stmt.executeUpdate();
        }
    }

    public void deletar(int idReuniao)
            throws SQLException {

        String sql = """
            DELETE FROM reuniao
            WHERE PK_reu = ?
            """;

        try (Connection conexao = conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idReuniao);

            stmt.executeUpdate();
        }
    }

}
