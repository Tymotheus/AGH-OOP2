/**
* Class inherited from Man class. Represents a student.
* Contains his or her index number, last 3 grades 
*/
public class Student extends Man {
    private int indexNumber;
    private double[] grades;

    public Student(String name_instance, String surname_instance, int index_id, double grade1, double grade2, double grade3){
        super(name_instance, surname_instance);
        indexNumber = index_id;
        grades = new double[3];
        grades[0] = grade1;
        grades[1] = grade2;
        grades[2] = grade3;
    }

    public String toString(){
        return String.format("%s, id_number: %d, grades: [%.1f, %.1f, %.1f]",
         super.toString(), indexNumber, grades[0], grades[1], grades[2]);
    }
    /** Returns average of Student's last 3 grades.
    */
    public double average(){
        return (grades[0] + grades[1] + grades[2])/3 ;
    }
    /** Compares two Deans, returns the reference to the one, who has more recent term years.
     * If any other object than Student (or inheriting from it) is passed, returns null.
     * @param to_compare The other Student we compare to.
    */
    public Man compare(Man to_compare)
    {   
        if((to_compare instanceof Student)==false)
            return null;
        else{
            Student other = (Student) to_compare;
            if( (grades[0] + grades[1] + grades[2])/3 > (other.grades[0] + other.grades[1] + other.grades[2])/3 )
                return this;
            else
                return to_compare;
        }
    }

    
}
