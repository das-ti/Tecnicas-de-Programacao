package dao;

import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Socio;

public class SocioDAO {

    public void salvarTodos(String cnpjEmpresa, List<Socio> socios) throws SQLException {
        if (socios == null || socios.isEmpty()) return;

        String sql = "INSERT INTO socios (cnpj_empresa, nome_socio, cnpj_cpf_do_socio, qualificacao_socio) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (Socio socio : socios) {
                ps.setString(1, cnpjEmpresa);
                ps.setString(2, socio.getNomeSocio());
                ps.setString(3, socio.getCnpjCpfDoSocio());
                ps.setString(4, socio.getQualificacaoSocio());
                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println(socios.size() + " socio(s) salvo(s).");
        }
    }
}
