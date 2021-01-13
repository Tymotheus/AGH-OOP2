public class MatrixThread extends Thread{
    private Thread t;
    private String threadName;

    Matrix A;
    Matrix B;
    Matrix C;
    
    int row;
    int column;

    MatrixThread(int row, int column, Matrix A, Matrix B, Matrix C, String name){
        this.row = row;
        this.column = column;
        this.A = A;
        this.B = B;
        this.C = C;
        this.threadName = name;
        //System.out.println("Creating " + threadName);
    }

    @Override
    public void run(){
        try{
            //System.out.println("Running " + threadName);
            double summed = 0;
            for(int k=0; k < A.columnNumber(); k++){
                summed += A.getValue(row, k) * B.getValue(k, column);}
            C.setValue(row, column, summed);
        }
        catch (Exception e){
            System.out.println("Thread " + threadName + " interrupted");
        }
    }

    public void start(){
        System.out.println("Starting " + threadName);
        if (t==null){
            t = new Thread (this, threadName);
            t.start();
        }
    }
    
}
