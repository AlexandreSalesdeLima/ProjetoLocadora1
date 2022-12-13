package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost/locafacil";
    private static final String USER = "root";
    private static final String PASS = "123456";
    public static Connection getConexao() {
        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            return c;
        } catch (Exception e) {
            return null;
        }
    }
}
