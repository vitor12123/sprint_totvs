package com.sprint2.src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class PegaRelatorioIa {

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teste1", "backend_sprint", "senha_do_backend");
    }

    // Verifica se já existe relatório da IA salvo para essa reunião
    public boolean existeRelatorio(int id) throws SQLException {

        String sql = "SELECT 1 FROM relatorio_ia WHERE FK_PK_reu = ? LIMIT 1";

        try (Connection conexao = conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    // Devolve um objeto com nomes, já no formato das props do RepoCardEspecifico
    public Map<String, Object> filtro_para_RepoEspecifico(int id) throws SQLException {

        System.out.println("chamou a funçao de pegar o relatorio");

        Map<String, Object> repo = new LinkedHashMap<>();
        repo.put("id_reuniao", id);

        String sqlReuniao = "SELECT FK_PK_cli, NT_NPS_reu, DT_reu FROM reuniao WHERE PK_reu = ?";

        try (Connection conexao = conectar();
             PreparedStatement stmt = conexao.prepareStatement(sqlReuniao)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    repo.put("id_cliente", rs.getString("FK_PK_cli"));
                    repo.put("nota", rs.getString("NT_NPS_reu"));
                    repo.put("data_conversa", rs.getDate("DT_reu") != null ? rs.getDate("DT_reu").toString() : null);
                } else {
                    System.out.println("nenhuma reuniao encontrada com PK_reu = " + id);
                }
            }
        }

        String sqlRelatorio = """
            SELECT dr_cli_rel, pr_cli_rel, rs_rel, rc_rel, grau_urgencia
            FROM relatorio_ia WHERE FK_PK_reu = ?""";

        try (Connection conexao = conectar();
             PreparedStatement stmt = conexao.prepareStatement(sqlRelatorio)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    repo.put("dores", rs.getString("dr_cli_rel"));
                    repo.put("produtos", rs.getString("pr_cli_rel"));
                    repo.put("riscos", rs.getString("rs_rel"));
                    repo.put("recomendacao", rs.getString("rc_rel"));
                    repo.put("grau_urgencia", rs.getString("grau_urgencia"));
                } else {
                    System.out.println("nenhum relatorio_ia encontrado para a reuniao " + id);
                }
            }
        }

        System.out.println("pegou o relatorio !!! " + repo);
        return repo;
    }
}
