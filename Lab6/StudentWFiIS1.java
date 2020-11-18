public class StudentWFiIS1 extends Student implements StudentUSOS {
    private String[] przedmioty = new String[3];
    private int rok;

    public StudentWFiIS1(String n, String s, int id, int rok, String nazwa1, double o1, String nazwa2, double o2, String nazwa3, double o3){
        super(n, s, id, o1, o2, o3);
        this.rok = rok;
        this.przedmioty[0] = nazwa1;
        this.przedmioty[1] = nazwa2;
        this.przedmioty[2] = nazwa3;
    }

    public String toString(){
        return String.format("[%d] %s", rok, super.toString() );
    }

    public double srednia(){
        return super.average();
    }

    public void listaPrzedmiotow()
    {   
        for (int i = 0; i < przedmioty.length; i++){
            System.out.println(String.format("\t%d. %s: %.1f", i+1, przedmioty[i], getGrade(i)));
        }
        
    }

}
