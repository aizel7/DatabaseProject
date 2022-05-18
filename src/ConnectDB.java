import java.sql.*;

public class ConnectDB {
    // DB Connection variables
    static Connection connection = null;
    static String databaseName = "";
    static String url = "jdbc:mysql://localhost:3306/" + databaseName + "?autoReconnect=true&useSSL=false";

    static String username = "root";
    static String password = "garabag21";

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        System.out.println("\n\n***** MySQL JDBC Connection Testing *****");
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO studentdatabase.student (name) VALUES ('Johnny Depp');");
            int status = ps.executeUpdate();

            if (status != 0) {
                System.out.println("Database was Connected");
                System.out.println("Record Was Inserted");

            }

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}