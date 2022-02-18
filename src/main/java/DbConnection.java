import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static Connection connection;


    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/banco_teste_automacao?" +
                "user=root&password=TESTE1@nao");
        return connection;
    }

}
