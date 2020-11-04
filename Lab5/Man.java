/**
* Abstract class representing a human. 
* Contains name and surname, and abstract compare method.
*/
abstract class Man {
    private final String name;
    private final String surname;

    public Man(String name_instance, String surname_instance){
        name = name_instance;
        surname = surname_instance;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }

    public String toString(){
        return name + " " + surname;
    }
    abstract public Man compare(Man ob);

    public double average() {
        return 0.0;
    }
}
