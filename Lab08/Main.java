import java.util.Scanner;
import java.util.InputMismatchException;;

public class Main {

    public static void main(String[] args)  {
        System.out.println("Hi Universe!");
        Game.getInput();
        Game game;
        if(args.length < 3){
            game = new Game(11, 11, 0.3);
        }
        else{
            game = new Game(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Double.parseDouble(args[2]) );
        }
            game.startGame();
    }
}
