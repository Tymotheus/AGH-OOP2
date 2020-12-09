import java.lang.Math;
import java.util.Arrays;
import java.lang.reflect.*;

public class Main{
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("You need to pass some function and argument while calling. ");
        }
        else{
            String splitted[] = splitArgs(args[0]);
            for(String var: splitted){
                System.out.println(var);
            }
            if(splitted.length > 3 || splitted.length == 1){
                System.out.println("You have to pass between 1 and 2 numbers to the function.");
            }
           else{
            Class<Math> cls = Math.class;
            double arglist[] = new double[splitted.length - 1];
            Class argtypes[] = new Class[splitted.length - 1];
            try{
                for (int i = 0; i<splitted.length - 1; i++){
                    arglist[i] = Double.parseDouble(splitted[i+1]);
                    argtypes[i] = double.class;
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("The arguments must be numbers. ");
            }
            try{
                Method meth = cls.getMethod(splitted[0], argtypes );
                if (arglist.length == 1){
                    System.out.println("Result: " + meth.invoke(null, arglist[0] ) );
                }
                else if(arglist.length == 2){
                    System.out.println("Result: " + meth.invoke(null, arglist[0], arglist[1] ) );
                }
            }
            catch(NoSuchMethodException e){
                System.out.println("Sorry, there is no such method available.");
            }
            catch(IllegalAccessException | InvocationTargetException e){
                System.out.println("This method can not be accessed.");
            }
            }
        }
    }
    //Komentarz: wykorzystany regexp wydaje się rozdzielać liczby jeśli są między nimi przecinki bez spacji
    // Jeśli między liczbami występują przecinki oraz spacje - wyłapywana jest tylko pierwsza liczba
    // Wobec tego dla poprawnego działania programu przekazywane powinny być liczby oddzielone przecinkami bez spacji
    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> w.isEmpty() == false).toArray(String[]::new);
    }

}