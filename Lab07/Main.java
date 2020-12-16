import java.io.IOException;
public class Main {

    public static void main(String[] args)throws IOException, InterruptedException {
        System.out.println("Hi Universe!");
        Direction direction = Direction.LEFT;
        System.out.println(direction);

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
