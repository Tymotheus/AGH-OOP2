/**
* Class inherited from Student class. Represents a Graduate Student.
* Containts Graduate title and year of graduation. 
*/
public class Graduate extends Student {
    private final String title;
    private final int yearOfCompletion;   

    public Graduate(String title_instance, String name_instance, String surname_instance, int index_id, int year, double grade1, double grade2, double grade3){
        super( name_instance,  surname_instance,  index_id,  grade1,  grade2,  grade3);
        title = title_instance;
        yearOfCompletion = year;
    }

    public String toString(){
        return String.format("%s %s, year of graduation: %d", title, super.toString(), yearOfCompletion);
    }
}
