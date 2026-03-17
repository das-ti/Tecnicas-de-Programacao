package dao;

import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Empresa;

public class EmpresaDAO {

    public void salvar(Empresa e) throws SQLException {
        String sql = "INSERT INTO empresas (cnpj, razao_social, nome_fantasia, logradouro, municipio, uf, cep) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?) ON CONFLICT (cnpj) DO NOTHING";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getCnpj());
            ps.setString(2, e.getRazaoSocial());
            ps.setString(3, e.getNomeFantasia());
            ps.setString(4, e.getLogradouro());
            ps.setString(5, e.getMunicipio());
            ps.setString(6, e.getUf());
            ps.setString(7, e.getCep());

            ps.executeUpdate();
            System.out.println("Empresa salva: " + e.getRazaoSocial());
        }
    }
}
