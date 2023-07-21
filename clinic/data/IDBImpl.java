package clinic.data;

import clinic.data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IDBImpl implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/clinic1";
        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(connectionUrl, "postgres", "1234");

            return connection;
        } catch (Exception e) {
            System.out.println(e);

            return null;
        }
    }
}
