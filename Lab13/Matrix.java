import java.util.Random;

public class Matrix {
    private final int rows;
    private final int columns;
    double tab[][];

    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.tab = new double[rows][columns];
        System.out.println("Hey I am the constructor");
        System.out.println(String.format("Dimensions: rows=%s columns=%s", rows, columns));
    }

public void fillRandomly(){
    Random rand = new Random();
    for (int i=0; i<rows; i++){
        for (int j=0; j<columns; j++){
            tab[i][j] = rand.nextDouble()*100; //generating double between 0 and 100
        }
    }
}

public boolean equals(Object obj){
        try{
            Matrix casted = (Matrix) obj;
            if (casted.columns != this.columns || casted.rows != this.rows)
                return false;
            else{
                for (int i=0; i<rows; i++){
                    for (int j=0; j<columns; j++){
                        if (tab[i][j] == casted.tab[i][j])
                            continue;
                        else
                            return false;
                    }
                }
                return true;
            }
        }
        catch (ClassCastException e){
            System.out.println("Could not cast the passed object: \n" + e);
            return false;
        }
    }

    public void print(){
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                System.out.print(String.format("%.2f  ", tab[i][j]) );
            }
            System.out.println();
        }
    }

    public Matrix multiply(Matrix other){
        if(columns != other.rows){
            System.out.println("Error. Can not multiply, matrix dimensions are invalid.");
            return null;
        }
        else{
            Matrix temp = new Matrix(rows, other.columns);
            for (int i=0; i<rows; i++){
                for (int j=0; j<other.columns; j++){
                    double summed = 0;
                    for(int k=0; k<columns; k++){
                        summed += tab[i][k] * other.tab[k][j];
                    }
                    temp.tab[i][j] = summed;
                }
            }
            return temp;
        }
    }

    public Matrix multiThreadMultiply(Matrix other){
        Thread t = new Thred();


        return null;

    }
}

