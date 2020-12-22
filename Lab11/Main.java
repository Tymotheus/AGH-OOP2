//Simple program to check efficiency of basic operations on different collection datatypes
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
   
    //get random alphabetic string with the given length
    static String getRandomString(int length){
        String AlphabeticString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++){
            int index = (int) (AlphabeticString.length() * Math.random());
            sb.append(AlphabeticString.charAt(index));
        }
        return sb.toString();
    }
   
    public static void main(String[] args){
       
       if (args.length != 2){
           System.out.println("You need to pass exactly two numbers while calling main.");
        }   
        else if ( Integer.parseInt(args[0]) <= Integer.parseInt(args[1]) ){
           System.out.println("The first number should be greater than the second.");
       }
       else{
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            System.out.println("\nHello, I'm checking efficiency of some basic operations for different collection datatypes.");
            System.out.println("Im generating " + n + " strings and testing on " + m + " strings.\n");
            //1st part of the task
            Random rand = new Random();
            String t1[] = new String[n];
            String t2[] = new String[m];
            String t3[] = new String[m];
            
            //creating array of random strings of size between [5,20]
            for(int i = 0; i < t1.length; i++){
                int size = rand.nextInt(16) + 5;
                t1[i] = getRandomString(size);
            }
            //creating array of random strings from t1 tab
            for(int i = 0; i < t2.length; i++){
                int index = rand.nextInt(t1.length);
                t2[i] = t1[index];
            }

            //creating array of random strings that are not in t1
            for(int i = 0; i < t3.length; i++){
                int size = rand.nextInt(16) + 5;
                String temp = getRandomString(size);
                while(Arrays.stream(t1).anyMatch(temp::equals)){
                    temp = getRandomString(size);
                }
                t3[i] = temp;
            }

            //2nd part of the task
            ArrayList<String> col1 = new ArrayList<String>();
            LinkedList<String> col2 = new LinkedList<String>();
            TreeMap<String,String> col3 = new TreeMap<>(); //hehe using diamond operator here
            HashMap<String, String> col4 = new HashMap<>();

            //Inserting
            System.out.println("Inserting operation");
            
            long startTime = System.nanoTime();
            for(var el:t1){
                col1.add(el);
            }
            System.out.println("Array List: " + (System.nanoTime()-startTime)*1e-3 + " ms" );
            
            startTime = System.nanoTime();
            for(var el:t1){
                col2.addLast(el);
            }
            System.out.println("Linked List: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            for(var el:t1){
                col3.put(el, "");
            }
            System.out.println("Tree Map: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            for(var el:t1){
                col4.put(el, "");
            }
            System.out.println("Hash Map: " + (System.nanoTime()-startTime)*1e-3 + " ms" );
            
            //Searching existing elements
            System.out.println("\nSearch existing elements operation");

            startTime = System.nanoTime();
            for(var el:t2){
                int i = col1.indexOf(el);
            }
            System.out.println("Array List: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            for(var el:t2){
                int i = col2.indexOf(el);
            }
            System.out.println("Linked List: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            for(var el:t2){
                String i = col3.get(el);
            }
            System.out.println("Tree Map: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            for(var el:t2){
                String i = col4.get(el);
            }
            System.out.println("Hash Map: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            //Searching nonexisting elements
            System.out.println("\nSearch nonexisting elements operation");

            startTime = System.nanoTime();
            for(var el:t3){
                int i = col1.indexOf(el);
            }
            System.out.println("Array List: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            for(var el:t3){
                int i = col2.indexOf(el);
            }
            System.out.println("Linked List: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            for(var el:t3){
                String i = col3.get(el);
            }
            System.out.println("Tree Map: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            for(var el:t3){
                String i = col4.get(el);
            }
            System.out.println("Hash Map: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            //checking loops
            System.out.println("\nChecking loop efficiency.");

            System.out.println("\nArray List:");
            startTime = System.nanoTime();
            for(int i = 0; i < col1.size(); i++){
                String temp = col1.get(i);
            }
            System.out.println("Looping with indexes: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            for(var el:col1){
                String temp = el;
            }
            System.out.println("Looping with for-each: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            Iterator<String> it = col1.iterator();
            startTime = System.nanoTime();
            while(it.hasNext()){
                String temp = it.next();
            }
            System.out.println("Looping with iterator: " + (System.nanoTime()-startTime)*1e-3 + " ms" );


            System.out.println("\nLinked List: ");
            startTime = System.nanoTime();
            for(int i = 0; i < col2.size(); i++){
                String temp = col2.get(i);
            }
            System.out.println("Looping with indexes: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            for(var el:col2){
                String temp = el;
            }
            System.out.println("Looping with for-each: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            it = col2.iterator();
            startTime = System.nanoTime();
            while(it.hasNext()){
                String temp = it.next();
            }
            System.out.println("Looping with iterator: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            //Deleting all the elements
            System.out.println("\nDeleting all the elements at once: ");
            startTime = System.nanoTime();
            col1.clear();
            System.out.println("Array List: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            col2.clear();
            System.out.println("Linked List: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            col3.clear();
            System.out.println("Tree Map: " + (System.nanoTime()-startTime)*1e-3 + " ms" );

            startTime = System.nanoTime();
            col4.clear();
            System.out.println("Hash Map: " + (System.nanoTime()-startTime)*1e-3 + " ms" );
       }
    }
}