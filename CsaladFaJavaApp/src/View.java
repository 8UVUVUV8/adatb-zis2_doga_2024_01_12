import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class View {

    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    String input;

    public View(){
    }

    public void showPersones(ArrayList<Person> personlist, ArrayList<Family> familiyList, ArrayList<Gender> genderList, ArrayList<Status> statusList, ArrayList<Place> placeList){
        for (Person person : personlist) {
            System.out.print("név: "+person.name+"| ");
            System.out.print("család: "+familiyList.get(person.csaladID-1).familyName+"| ");
            System.out.print("gender: "+genderList.get(person.genderID-1).gender+"| ");
            System.out.print("státusz: "+statusList.get(person.statusID-1).status+"| ");
            System.out.print("Születési idö: "+person.birthdate+"| ");
            System.out.print("Születési hely: "+placeList.get(person.birth_placeID).placename+"| ");
            System.out.print("Anyja neve: "+person.mothersname+"| ");
            System.out.print("Apja neve: "+person.fathersname+"| ");
            System.out.println("");
        }
    }

    public Integer homeMassage(){
        System.out.println("Üdvözölek a 'Csaladfa' java app ban");
        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Opciok:");
        System.out.println("[1]Személyek listázása");
        System.out.println("[2]Személy hozzáasása");
        System.out.println("[0]Kilépés a programbol");
        return home();
    }

    public Integer home(){
        try {
            return tryHome();
        } catch (Exception e) {
            System.err.println("input bekérési hiba!");
            System.err.println(e.getMessage());
            return 3;
        }
    }

    public Integer tryHome() throws IOException{
        
        input = BR.readLine();
        Integer intInput = Integer.parseInt(input);

        return intInput;
    }
}
