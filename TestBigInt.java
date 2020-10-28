import java.lang.Math;

public class TestBigInt{
    // Class designed to test custom BigInt class.
    // test() function should be executed with the -ea flag, so it features assertions.
    static public void test(){
        long long1;
        long long2;
        BigInt big1;
        BigInt big2;

        try
        {   for(int i = 0; i < 1000; i++)
            {
                long1 = (long) (Math.random() * Long.MAX_VALUE/2 );
                long2 = (long) (Math.random() * Long.MAX_VALUE/2 );
                big1 = new BigInt("" + long1);
                big2 = new BigInt("" + long2);
                assert big1.add(big2).equals(new BigInt("" + (long1 + long2) )) : "Error. Result is not correct." ;
            }
            long1 = 1L;
            long2 = 999999999999999999L;
            big1 = new BigInt("" + long1);
            big2 = new BigInt("" + long2);
            assert big1.add(big2).equals(new BigInt("" + (long1 + long2) )) : "Error. Result is not correct." ;

            long1 = 999999999999999999L;
            long2 = 1L;
            big1 = new BigInt("" + long1);
            big2 = new BigInt("" + long2);
            assert big1.add(big2).equals(new BigInt("" + (long1 + long2) )) : "Error. Result is not correct." ;
            System.out.println("Tests completed successfully.");
        }
        catch (Throwable t)
        {
            System.out.println("Error. Result is not correct.");
        }

    }
}