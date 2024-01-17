import java.sql.Connection;
import java.util.ArrayList;

public class controler {
    TalkToDB DB = new TalkToDB();
    Connection conn = new DBconnector().DBconn();
    View view = new View();
    Integer choice;

    public void mainControler(){
        Integer choice = view.homeMassage();

        if (choice == 1) {
            ArrayList<Person> personList = DB.getPersones(conn);
            for (Person person : personList) {
                System.out.print("Name: "+person.name+"|");
                System.out.print("CsaladID: "+person.csaladID+"|");
                System.out.print("GenderID: "+person.genderID+"|");
                System.out.print("StatusID: "+person.statusID+"|");
                System.out.print("Birth date: "+person.birthdate+"|");
                System.out.print("Birth place: "+person.birth_placeID+"|");
                System.out.print("Mothers name: "+person.mothersname+"|");
                System.out.print("Fathers name: "+person.fathersname+"|");
                System.out.print("Place of death: "+person.possibleplaceofdeath_placeID+"|");
                System.out.print("Time of death: "+person.possibletimeofdeath+"|");
                System.out.println();
                mainControler();
            }
        }else if(choice == 2){
            Person newPerson = new Person("Kiss Ödön", 1, 1, 1, "2001-09-28", 1, "Ödönné", "Kiss Ödön", null, null);
            DB.addPersone(conn, newPerson);
            mainControler();
        }else if (choice == 3){
            System.exit(0);
        }else{
            System.out.println("hibás input");
            mainControler();
        }



    }
}
