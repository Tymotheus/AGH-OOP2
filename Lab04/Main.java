public class Main{
    
    public static void main(String[] args){
        BigInt number1 = new BigInt("123");
        System.out.println(number1.toString());
        BigInt number2 = new BigInt(number1);
        System.out.println(number2.toString());
        System.out.println(number1.equals(number2));
        BigInt number3 = new BigInt("123");
        System.out.println(number1.equals(number3));
        System.out.println(number3.toString());        
        BigInt number4 = number1.add(number2);
        System.out.println(number4.toString());
        
        //checking if it is immutable
        Byte[] test = number3.getNum();
        test[0] = (Byte.parseByte("9"));
        System.out.println(number3.toString());
        
        //Running tests
        TestBigInt.test();

    }
}
