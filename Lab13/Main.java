import java.io.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        try{
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String [] splited = args;

            while(splited.length != 3){
                System.out.println("Please enter exactly 3 whole numbers");
                String str = br.readLine();
                splited = str.split(" ");
            }
            int N = Integer.parseInt(splited[0]);
            int M = Integer.parseInt(splited[1]);
            int P = Integer.parseInt(splited[2]);
        
            Matrix A = new Matrix(N, M);
            Matrix B = new Matrix(M, P);

            System.out.println("Filling matrix A: ");
            A.fillRandomly();
            A.print();
            System.out.println("\nFilling matrix B: ");
            B.fillRandomly();
            B.print();

            System.out.println("\nStarting the regular multiplication");
            Matrix C = A.multiply(B);
            C.print();

            System.out.println("\nStarting the multithread multiplication: ");        
            Matrix D = A.multiThreadMultiply(B);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("\nMultithread multiplication result: ");
            D.print();

            System.out.println("\nChecking if the result is the same for both methods: ");
            System.out.println(C.equals(D));
        
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
