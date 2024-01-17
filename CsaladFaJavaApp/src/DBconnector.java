import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBconnector {

    Connection conn = null;

    public Connection DBconn(){

        try {
            conn = tryDBconnecter();
        } catch (SQLException e) {
            System.out.println("Hiba az adatbázishozz valo csatlakozásban!");
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public Connection tryDBconnecter() throws SQLException{
        String url = "jdbc:mariadb://localhost:3306/csaladfa";
        return DriverManager.getConnection(url, "javaApp", "java123");
    }
}
