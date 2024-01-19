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
            //System.out.println("person siker");
        return personList;
    }

    
    public ArrayList getFamilys(Connection conn){
        try {
            return tryGetFamilys(conn);
        } catch (SQLException e) {
            System.out.println("Nem sikerült az sql parancsot végre hajtani hogy lekérjük a családokat!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ArrayList tryGetFamilys(Connection conn) throws SQLException{
        ArrayList<Family> familyList = new ArrayList<>();

        String sql = "CALL `get_family_procedure`();";        
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Family family = new Family(
                    rs.getInt("csaladID"),
                    rs.getString("csaladnev")
                );
                familyList.add(family);
            }
            //System.out.println("family siker");
        return familyList;
    }

    public ArrayList getGender(Connection conn){
        try {
            return tryGetGender(conn);
        } catch (SQLException e) {
            System.out.println("Nem sikerült az sql parancsot végre hajtani hogy lekérjük a gendert!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ArrayList tryGetGender(Connection conn) throws SQLException{
        ArrayList<Gender> GenderList = new ArrayList<>();

        String sql = "CALL `get_gender_procedure`();";        
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Gender gender = new Gender(
                    rs.getInt("genderID"),
                    rs.getString("gender")
                );
                GenderList.add(gender);
            }
            //System.out.println("gender siker");
        return GenderList;
    }
    
    public ArrayList getStatus(Connection conn){
        try {
            return tryGetStatus(conn);
        } catch (SQLException e) {
            System.out.println("Nem sikerült az sql parancsot végre hajtani hogy lekérjük a statust!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ArrayList tryGetStatus(Connection conn) throws SQLException{
        ArrayList<Status> statusList = new ArrayList<>();

        String sql = "CALL `get_status_procedure`();";        
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Status status = new Status(
                    rs.getInt("statusID"),
                    rs.getString("status")
                );
                statusList.add(status);
            }
            //System.out.println("status siker");
        return statusList;
    }

        
    public ArrayList getPlace(Connection conn){
        try {
            return tryGetPlace(conn);
        } catch (SQLException e) {
            System.out.println("Nem sikerült az sql parancsot végre hajtani hogy lekérjük a place!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ArrayList tryGetPlace(Connection conn) throws SQLException{
        ArrayList<Place> placeList = new ArrayList<>();

        String sql = "CALL `get_places_procedure`();";        
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Place place = new Place(
                    rs.getInt("placeID"),
                    rs.getString("placename"),
                    rs.getString("zipcode")
                );
                placeList.add(place);
            }
            //System.out.println("place siker");
        return placeList;
    }



    // public void addPersone(Connection conn, Person newPerson){
    //     try {
    //         tryAddPersone(conn, newPerson);
    //     } catch (SQLException e) {
    //         System.err.println("adat bázis put müvelet sikertelen");
    //         System.err.println(e.getMessage());
    //     }
    // }

    // public void tryAddPersone(Connection conn, Person newPerson) throws SQLException{
    //     String sql = 
    //     "CALL add_person_procedure('"
    //     +newPerson.name+"',"
    //     +newPerson.csaladID+","
    //     +newPerson.genderID+",'"
    //     +newPerson.birthdate+"',"
    //     +newPerson.birth_placeID+",'"
    //     +newPerson.mothersname+"','"
    //     +newPerson.fathersname+"',"
    //     +newPerson.possibleplaceofdeath_placeID+",'"
    //     +newPerson.possibletimeofdeath+"');";
    //     Statement stmt = conn.createStatement();
    //     ResultSet rs = stmt.executeQuery(sql);
    //     System.out.println(rs);
    // }
    
}
