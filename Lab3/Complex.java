import java.lang.Math;

// Simple custom class representing complex numbers and implementing basic methods for them
public class Complex {
    private double real;
    private double imaginary;

    static final Complex I = new Complex(0, 1.0); 
    static final Complex ZERO = new Complex(0);
    static final Complex ONE = new Complex(1.0);

    public Complex(double real1, double imaginary1){
        real = real1;
        imaginary = imaginary1;
    }
    public Complex(double real1){
        real  = real1;
        imaginary = 0;
    }

    public Complex(){
        real = 0;
        imaginary = 0;
    }

    public String toString(){
        
        String output = "";
        if (imaginary == 0){
            return output + real;
        }
        else if ( (real == 0) && (imaginary != 0) ){
            return "" + imaginary + 'i';
        }
        else if (imaginary >= 0){
            return output + real + " + " + imaginary +'i';  
        }
        else{
            return output + real + " - " + -imaginary + 'i';
        }
         
    }

    public double getRe(){
        return real;
    }

    public double getIm(){
        return imaginary;
    }

    static public Complex add(Complex c1, Complex c2){
        return new Complex(c1.getRe() + c2.getRe(), c1.getIm() + c2.getIm());
    }

    static public Complex subtract(Complex c1, Complex c2){
        return new Complex(c1.getRe() - c2.getRe(), c1.getIm() - c2.getIm());
    }

    static public Complex multiply(Complex c1, Complex c2){
        double re = c1.getRe() * c2.getRe() - c1.getIm() * c2.getIm();
        double im = c1.getIm() * c2.getRe() + c1.getRe() * c2.getIm();
        return new Complex(re, im);
    }

    static public Complex multiply(Complex c1, double d1){
        
        return new Complex(c1.getRe() * d1, c1.getIm() * d1);
    }

    static public Complex divide(Complex c1, Complex c2){

        double re = ( c1.getRe() * c2.getRe() + c1.getIm() * c2.getIm() ) / ( c2.getRe() * c2.getRe() + c2.getIm() * c2.getIm() );
        double im = ( c1.getIm() * c2.getRe() - c1.getRe() * c2.getIm() ) / ( c2.getRe() * c2.getRe() + c2.getIm() * c2.getIm() );
        return new Complex(re,im);
    }

    public double mod(){
        return Math.sqrt( real * real + imaginary * imaginary );
    }

    static public Complex sqrt(double d1){
        if (d1 >= 0){
            return new Complex ( Math.sqrt(d1));
        }
        else{
            return new Complex (0, Math.sqrt(-d1));
        }
    }

    public Boolean equals(Complex c1){
       
        if(c1.getClass() != Complex.I.getClass())
            return false;
        else if( (real == c1.getRe())  && (imaginary == c1.getIm() )  )
            return true;
        else
            return false;
    }

    public void conjugate(){
        imaginary = - imaginary;
    }

    public void opposite(){
        real = - real;
        imaginary = -imaginary;
    }

    public void test() {
        // Wykorzystanie konstruktorów:
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
        System.out.println(c1); // 2.5 + 13.1i
        System.out.println(c2); // -8.5 - 0.9i
        System.out.println(new Complex(4.5)); // 4.5
        System.out.println(new Complex()); // 0.0
        System.out.println(new Complex(0, 5.1)); // 5.1i
        System.out.println();

        // // Stałe typu Complex:
        System.out.println(Complex.I); // 1.0i
        System.out.println(Complex.ZERO); // 0.0
        System.out.println(Complex.ONE); // 1.0
        System.out.println();

        // // Wykorzystanie metod zwracających wynik obliczeń:
        System.out.println("Re(c1) = " + c1.getRe()); // Re(c1) = 2.5
        System.out.println("Im(c1) = " + c1.getIm()); // Im(c1) = 13.1
        System.out.println("c1 + c2 = " + Complex.add(c1, c2)); // c1 + c2 = -6.0 + 12.2i
        System.out.println("c1 - c2 = " + Complex.subtract(c1, c2)); // c1 - c2 = 11.0 + 14.0i
        System.out.println("c1 * c2 = " + Complex.multiply(c1, c2)); // c1 * c2 = -9.46 - 113.6i
        System.out.println("c1 * 15.1 = " + Complex.multiply(c1, 15.1)); // c1 * 15.1 = 37.75 + 197.81i
        System.out.println("c1 / c2 = " + Complex.divide(c1, c2)); // c1 / c2 = -0.4522310429783739 - 1.4932931836846426i
        System.out.println("|c1| = " + c1.mod()); // |c1| = 13.336416310238668
        System.out.println("sqrt(243.36) = " + Complex.sqrt(243.36)); // sqrt(243.36) = 15.6
        System.out.println("sqrt(-243.36) = " + Complex.sqrt(-243.36)); // sqrt(-243.36) = 15.6i
        Complex c3 = new Complex(2.5, 13.1);
        System.out.println(c1.equals(c2)); // false
        System.out.println(c1.equals(c3)); // true
        // // Poniższe wywołanie - dla chętnych :)
        System.out.println(c1.equals("test ze zlym obiektem")); // false
        // System.out.println();

        // Metoda zamieniająca liczbę na jej sprzężenie:
        c1.conjugate();
        System.out.println("c1* = " + c1); // c1* = 2.5 - 13.1i

        // // Metoda zamieniająca liczbę na przeciwną:
        c1.opposite();
        System.out.println("-c1 = " + c1); // -c1 = -2.5 + 13.1i
    }
}
