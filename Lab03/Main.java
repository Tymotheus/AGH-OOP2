public class Main{

    //function solving Quadratic equation, including complex solutions and featuring custom Complex class
    static public void solveQuadratic(double a, double b, double c){
        double delta = b*b - 4*a*c;
        Complex delta_root = Complex.sqrt(delta);
        
        if (delta > 0){
            Complex x1 = new Complex( (-b + delta_root.getRe())/(2*a) );
            Complex x2 = new Complex( (-b - delta_root.getRe())/(2*a) );
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        }
        else
        {
            Complex x1 = new Complex( (-b +delta_root.getRe() )/ (2*a) , delta_root.getIm()/(2*a));
            Complex x2 = new Complex( (-b -delta_root.getRe() )/ (2*a) , delta_root.getIm()/(2*a));
            System.out.println("x1 = " + x1 + ",2 x2 = " + x2);
        }        
    }
    
    public static void main(String[] args){
        System.out.println("Hello World!");
        //test();
        Complex z = new Complex(4,5);
        z.test();
        solveQuadratic(1.0, 2.5, 3.0);
        }
    
}
