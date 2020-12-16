import java.lang.reflect.Array;

class StackOverflowException extends Exception{
    StackOverflowException(String errorMessage){
        super(errorMessage);
    }
}

class StackUnderflowException extends Exception{
    StackUnderflowException(String errorMessage){
        super(errorMessage);
    }
}

//my implementation of generic class featuring the Stack for any type
public class Stack<T> {

     private int maxSize = 10;
     private int size = 0;
     private T[] stack;

    public Stack(int maxSize, Class<T[]> classT){
        stack = classT.cast(Array.newInstance(classT.getComponentType(), maxSize));
        this.maxSize = maxSize;
    }

    public boolean isEmpty(){
        if (size == 0)
            return true;
        else
            return false;
    }

    public boolean isFull(){
        if (size == maxSize)
            return true;
        else
            return false;
    }

    public void push(T x) throws StackOverflowException{
        if (this.isFull())
            throw new StackOverflowException("Warning! Stack overflow.");
        else{
            this.stack[size] = x;
            this.size += 1;
        }
    }

    public T pop() throws StackUnderflowException{
        if (this.isEmpty())
            throw new StackUnderflowException("Warning! Stack underflow. Not enough elements on the stack.");
        else{
            this.size -= 1;
            T temp = stack[size];
            stack[size] = null;
            return temp;
            }
        }

    public String toString(){
        String output= "";
        for (var element: stack){
            if(element != null)
                output += element + "";
        }
        return output;
    }

}
