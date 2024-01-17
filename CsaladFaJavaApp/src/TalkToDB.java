import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TalkToDB {

    public ArrayList getPersones(Connection conn){
        try {
            return tryGetPersones(conn);
        } catch (SQLException e) {
            System.out.println("Nem sikerült az sql parancsot végre hajtani hogy lekérjük a személyeket!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ArrayList tryGetPersones(Connection conn) throws SQLException{
        ArrayList<Person> personList = new ArrayList<>();

        String sql = "CALL `get_person_procedure`();";        
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Person person = new Person(
                rs.getInt("personID"),
                rs.getString("name"),
                rs.getInt("csaladID"),
                rs.getInt("genderID"),
                rs.getInt("statusID"),
                rs.getString("birthdate"),
                rs.getInt("birth_placeID"),
                rs.getString("mothersname"),
                rs.getString("fathersname"),
                rs.getInt("possibleplaceofdeath_placeID"),
                rs.getString("possibletimeofdeath")
                );
                personList.add(person);
            }

        return personList;
    }

    
}