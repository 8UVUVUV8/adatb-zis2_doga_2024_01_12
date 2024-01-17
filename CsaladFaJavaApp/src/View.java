import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    String input;

    public View(){
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
