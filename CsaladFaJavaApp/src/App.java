import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Connection conn = null;
        try {
            String url = "jdbc:mariadb://localhost:3306/csaladfa";
            conn = DriverManager.getConnection(url, 
            "javaApp", "java123");
 
            String sql = "CALL `get_person_procedure`();";        
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }catch(SQLException ex) {
            System.err.println("Hiba! Az SQL művelet sikertelen!");
            System.err.println(ex.getMessage());
        }
    }
}
