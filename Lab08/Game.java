import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;

class OptionNotRecognizedException extends InputMismatchException{
    String description = "Enter a valid command.";
    OptionNotRecognizedException(String description)
    {this.description = description;}
    OptionNotRecognizedException()
    {}
}

class WallException extends RuntimeException{
    String description = "You can not move through the walls.";
    WallException(String description)
    {this.description = description;}
    WallException()
    {}
}

interface CheckStep{
    boolean test(char[][] board, int i0, int j0, Direction dir);
}

public class Game {
    private char[][] board;
    int x_size;
    int y_size;
    double probability;
    int player_x;
    int player_y;
    String gameInfo;

    public Game(int n_x, int n_y, double obstacle_probability){
        this.x_size = n_x;
        this.y_size = n_y;
        this.probability = obstacle_probability;
        this.gameInfo = "";
        generateBoard();
    }

    public Game(){
        this(11, 11, 0.3);
    }

    public void generateBoard(){
        //board is stored row-wise (I think)
        this.board = new char[y_size][x_size];

        for (int i = 0; i < y_size; i++){
            for(int j = 0; j < x_size; j++ )
            {
                if( (i == 0) || (j == 0) || (i == y_size-1) || (j == x_size-1))
                    {board[i][j] = 'X';
                    //System.out.println(String.format("i=%d j=%d",i,j));
                    }
                else if(Math.random()>this.probability)
                   board[i][j] = ' ';
                else
                    board[i][j] = 'X';
            }
        }
        this.player_y = y_size - 2;
        this.player_x = 1;
        board[player_y][player_x]= '@';
        board[0][x_size/2] = ' ';
    }

    public void printBoard(){
        //flushing the screen for windows and linux
        try{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(InterruptedException | IOException e)
        {}
        try {
        new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
        }
        catch(InterruptedException | IOException e)
        {}
        //printing the regular console input
        System.out.println("Hi user! Welcome th the labyrinth game!");
        System.out.println("Do you think you can make it to the top?");
        System.out.println("Remember you can always reset the board.");
        System.out.println("Here are your possible options: ");
        for( var option : java.util.Arrays.asList(Option.values()))
            System.out.println(option);
        System.out.println("");
        for(int row = 0; row < this.y_size; row++){
            String line = "";
            for(int column = 0; column < this.x_size; column++){
                line+=board[row][column];
            }
            System.out.println(line);
        }
        System.out.println(this.gameInfo);
        this.gameInfo = "";
    }

    public void step(Direction dir, CheckStep check){
        if ( check.test(board, player_x, player_y, dir ) == true ){
            board[player_y][player_x] = ' ';
            //System.out.println(String.format("Option: %s Move vector: x=[%d] y=[%d]",dir.name(), dir.getXCoordinate(), dir.getYCoordinate()) );
            player_x += dir.getXCoordinate();
            player_y -= dir.getYCoordinate();
            //player_y += 1;
            board[player_y][player_x] = '@';
        }
        else{
            try{throw new WallException();}
            catch(WallException e){
                this.gameInfo = e.description;
            }
            //System.out.println("Step function here, condition from check.test not passed");
            //System.out.println("Invalid move");
        }
    }

    public void startGame()
    {
        System.out.println("Hi user! How are you?");
        System.out.println("Here are your possible options: ");
        for( var option : java.util.Arrays.asList(Option.values()))
            System.out.println(option);
        //Scanner myScanner = new Scanner(System.in);
        Scanner myScanner = SystemInWrapper.sc;
        Boolean inGame = true;
        char playerChar = ' ' ;

        //I was trying to make it work without the user hitting enter button - like in a real game
        //It occurs it is not so easy. You would need to completely change the way that terminal works :/
        printBoard();
        while (inGame){
            playerChar = myScanner.next().charAt(0);
            Option option = null;
            switch(playerChar){

                case 'e':
                    option = Option.RESET;
                    System.out.println("Reseting the board");
                    generateBoard();
                    break;

                case 'q':
                    option = Option.EXIT;
                    inGame = false;
                    System.out.println("Quitting");
                    break;

                case 'w':
                    option = Option.UP;
                    //System.out.println("Up we go!");
                    break;

                case 'a':
                    option = Option.LEFT;
                    break;

                case 's':
                    option = Option.DOWN;
                    break;

                case 'd':
                    option = Option.RIGHT;
                    break;
                default:
                    try{throw new OptionNotRecognizedException();}
                    catch (OptionNotRecognizedException e ){
                        this.gameInfo = e.description;
                        System.out.println(e.description);
                }
                }
            if ( (option == Option.LEFT) || (option == Option.RIGHT) || (option==Option.UP) || (option == Option.DOWN))
            {
                //I want to call the step function with the direction chosen by user before
                //as an instance of CheckStep I want to pass lambda expression below. What the heck is not working?
                //Ok here you need to be extra careful!
                step(option.getDirection(),
                (
                    (board, player_x, player_y, chosenDirection)
                -> {return !(board[player_y - chosenDirection.getYCoordinate()][player_x + chosenDirection.getXCoordinate()] == 'X');}
                )
                );
            }
            if ( (player_y == 0) && (player_x == x_size/2) ){
                inGame = false;
            }
            printBoard();

        }
        System.out.println("\nSpectacular WIN! Congratulations!");
        System.out.println("Bye, it was nice to play with you!");
        myScanner.close();
    }
    
    //Additional function required in the task
    public static void getInput(){
        System.out.println("Enter a whole number greater than 1:");
        Boolean correctInput = false;
        //Scanner sc = new Scanner(System.in);
        Scanner sc = SystemInWrapper.sc;
        
        int nx;
        while (correctInput == false){
            try {
                nx = sc.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Error: Enter a whole number!");
                continue;
            }
            finally{
                sc.nextLine();
            }
            if (nx > 1){
                correctInput = true;
                System.out.println("Correct, thanks!");
                //sc.close();
            }
            else{
                System.out.println("Error: The number must be greater than 1!");
                continue;
            }
        }
    }

}
