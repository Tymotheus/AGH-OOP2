/**
* Class inherited from Man class. Represents a Dean of a Faculty.
* Contains Dean title, and years of staring the term and finishing it. 
*/
public class Dean extends Man{
    private final String title;
    private final int startYear;
    private final int endYear;

    public Dean(String title_instance, String name_instance, String surname_instance, int start_date, int end_date){
        super(name_instance, surname_instance);
        title = title_instance;
        startYear = start_date;
        endYear = end_date;
    }

    public String toString(){
        return String.format("%s %s, Dean of the Faculty from %d to %d. ",
        title, super.toString(), startYear, endYear );
    }

    /** Compares two Deans, returns the reference to the one, who has more recent term years.
     * If any other object than Dean is passed, returns null.
     * @param obj The other Dean we compare to.
    */
    public Man compare(Man obj){
        if(obj.getClass().getName() != this.getClass().getName())
            return null;
        else{
            Dean other = (Dean) obj;
            if (endYear > other.endYear)
                return this;
            else
                return obj;
        }
    }
}
