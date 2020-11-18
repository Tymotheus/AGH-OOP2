public class StudentWFiIS3 extends Student {
    
    private StudentUSOS stud;
    
    public StudentUSOS getStudentUSOS(int y, String nazwa1, String nazwa2, String nazwa3){
        return new StudentUSOS() {
            private String[] przedmioty;
            private int rok;
            {
                przedmioty = new String[] {nazwa1, nazwa2, nazwa3};
                rok = y;
            }

            @Override
            public double srednia(){
                return average();
            }

            @Override
            public void listaPrzedmiotow(){
                for (int i = 0; i < przedmioty.length; i++)
                    System.out.println("\t" + (i + 1) + ". " + przedmioty[i] + ": " + getGrade(i));
            }

            @Override
            public String toString() {
                return "" + rok;
            }
        };
    }

    public StudentWFiIS3(String n, String s, int id, int y, String nazwa1, double o1, String nazwa2, double o2, String nazwa3, double o3){
        super(n, s, id, o1, o2, o3);
        stud = getStudentUSOS(y, nazwa1, nazwa2, nazwa3);
    }

    public String toString(){
        return String.format("[%s] %s", stud.toString(), super.toString());
    }

    public double srednia(){
        return super.average();
    }

    public void listaPrzedmiotow(){
        stud.listaPrzedmiotow();
    }

}