public class Person {
    Integer personID;
    String name;
    Integer csaladID;
    Integer genderID;
    Integer statusID;
    String birthdate;
    Integer birth_placeID;
    String mothersname;
    String fathersname;
    Integer possibleplaceofdeath_placeID;
    String possibletimeofdeath;
    
    public Person(
        Integer personID,
        String name,
        Integer csaladID,
        Integer genderID,
        Integer statusID,
        String birthdate,
        Integer birth_placeID,
        String mothersname,
        String fathersname,
        Integer possibleplaceofdeath_placeID,
        String possibletimeofdeath
    )
    {
        this.personID = personID;
        this.name = name;
        this.csaladID = csaladID;
        this.genderID = genderID;
        this.statusID = statusID;
        this.birthdate = birthdate;
        this.birth_placeID = birth_placeID;
        this.mothersname = mothersname;
        this.fathersname = fathersname;
        this.possibleplaceofdeath_placeID = possibleplaceofdeath_placeID;
        this.possibletimeofdeath = possibletimeofdeath;
    }
}
