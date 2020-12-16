//while calling the main function pass string of arguments for the second part
public class Main {
    public static void main(String[] args) {
        try{
            //Part 1 of task: Basic functionality, stack for Integer type
            Stack<Integer> myStack = new Stack<Integer>(10, Integer[].class );
            System.out.println(myStack.isEmpty() );
            myStack.push(10);
            System.out.println(myStack.isEmpty() );
            System.out.println(myStack.pop() );
            myStack.push(42);
            myStack.push(34);
            myStack.push(47);
            myStack.pop();
            System.out.println(myStack.toString());

            //Part 2 of task: Stack for String type featuring Reversed Polish Notation
            Stack<String> yetStack = new Stack<String>(10, String[].class);
            String[] input = args[0].split("");

                String arg1;
                String arg2;
                String operator;
                for (var element : input){
                    System.out.println("Current element is: " + element);
                    if( element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/") ){
                        operator = element;
                        arg1 = yetStack.pop();
                        arg2 = yetStack.pop();
                        System.out.println(String.format("arg1 is %s arg2 is %s operator is %s", arg1, arg2, operator) );
                        String toPush = "(" + arg2 + operator + arg1 + ")";
                        //System.out.println("Pushing this: " + toPush);
                        yetStack.push( toPush);
                    }
                    else{
                        //System.out.println("Pushing this: " + element);
                        yetStack.push(element);
                    }
                    //System.out.println("Top of the stack is: " + yetStack.stack[yetStack.size-1]);
                    //System.out.println("Stack size is: " + yetStack.size);
                }
                String result = yetStack.pop();
                if (yetStack.isEmpty() == false){
                    System.out.println("Invalid input data. Stack is not empty after execution.");
                    System.out.println(String.format("%s, %s", yetStack.toString(), result ) );
                }
                else{
                    System.out.println("Output: " + result);
                }
        }
        catch(StackOverflowException e)
        {
            System.out.println(e.getMessage() );
        }
        catch(StackUnderflowException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
