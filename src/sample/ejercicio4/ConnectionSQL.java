package sample.ejercicio4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * @author vladimirsaldivar
 * @project HipotenusaXXX 2018
 * ...:::vsaldivarm@gmail.com:::...
 **/
public class ConnectionSQL {

    // Create a variable for the connection string.
    String connectionUrl = "jdbc:sqlserver://45.40.139.98; databaseName=test; user=AdminBD_des; password=Desa#0216;";

    // Declare the JDBC objects.
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public static void main(String[] args) {
        new ConnectionSQL().connection();
    }

    public void connection() {
        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            // Create and execute an SQL statement that returns some data.
            String SQL = "SELECT TOP 10 * FROM Person.Contact";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString(4) + " " + rs.getString(6));
            }
        } catch (Exception e)

        {
            e.printStackTrace();
        }
    }

}
