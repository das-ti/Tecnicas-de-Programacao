package br.edu.fatecpg.apijdbc.db;

public class DB {

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DB {

        public static Connection connection() throws SQLException {
            try {
                var jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
                var user = "postgres";
                var password = "abc123";
                return DriverManager.getConnection(jdbcUrl, user, password);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }
        }
    }
}
