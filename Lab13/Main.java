import java.io.*;

public class Main {
    public static void main(String[] args){
        try{
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            System.out.println("Good morning my dear!");
            String [] splited = args;

            while(splited.length != 3){
                System.out.println("Please enter exactly 3 whole numbers");
                String str = br.readLine();
                splited = str.split(" ");
            }
            int N = Integer.parseInt(args[0]);
            int M = Integer.parseInt(args[1]);
            int P = Integer.parseInt(args[2]);
            
            System.out.println(N);
            System.out.println(M);
            System.out.println(P);
            
            Matrix A = new Matrix(N, M);
            Matrix B = new Matrix(M, P);

            A.fillRandomly();
            A.print();
            System.out.println();
            B.fillRandomly();
            B.print();

            System.out.println(A.equals(A));
            

            int x = 5;
            System.out.println(A.equals(B));
            System.out.println();
            
            Matrix C = A.multiply(B);
            C.print();
        
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
