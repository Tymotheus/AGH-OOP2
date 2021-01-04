import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){
        try{
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String str;
            System.out.println("Please enter two filenames, separated by space, that you want to open and add:");
            str = br.readLine();
            String[] splited = str.split(" ");
            while(splited.length != 2){
                System.out.println("Please enter exactly two filenames");
                str = br.readLine();
                splited = str.split(" ");
            }
            //Creating the buffers for the input data
            System.out.println(String.format("Reading files %s and %s",splited[0],splited[1]));
            Path filePath1 = Paths.get(splited[0]);
            Path filePath2 = Paths.get(splited[1]);
            Charset charset = Charset.forName("UTF-8");
            BufferedReader reader1 = Files.newBufferedReader(filePath1, charset);
            BufferedReader reader2 = Files.newBufferedReader(filePath2, charset);
            
            //Creating the buffer for the output data
            BufferedWriter writer;
            Path outputPath;
            while(true){
                System.out.println("Enter the filename where you want to save the data: ");
                str = br.readLine();
                outputPath = Paths.get(str);
                File f = new File(str);
                if(f.exists()){
                    System.out.println("That file already exists. Do you want to overwrite it? (y/n)");
                    str = br.readLine().trim();
                    while(!str.equals("y") && !str.equals("n")){
                        System.out.println("You typed " + str);
                        System.out.println("Type y or n");
                        str = br.readLine();
                    }
                    if (str.equals("y"))
                        break;
                    else if(str.equals("n"))
                        continue;
                    }
                else
                    break;
                }
            writer = Files.newBufferedWriter(outputPath, charset);
            
            //Reading files and saving the data
            String line1;
            String line2;
            double output;
            while((line1 = reader1.readLine())!= null && (line2 = reader2.readLine()) != null )
            {
                String[] splited1 = line1.split(" ");
                String[] splited2 = line2.split(" ");

                if (!splited1[0].equals(splited2[0])){
                    System.out.println(String.format("Argument values are not the same in the line: x1=%s and x2=%s", splited1[0], splited2[0]));
                    System.out.println("Breaking");
                    break;
                }
                else{
                    output = Double.parseDouble(splited1[1]) + Double.parseDouble(splited2[1]);
                    System.out.println(output);
                    writer.write(String.format("%s %s\n", splited1[0], String.valueOf(output)));
                }
            }        
        }
        catch(IOException e){
            System.out.println("Exception: " + e);
        }    
    }
}
