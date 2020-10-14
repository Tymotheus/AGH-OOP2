import java.math.BigInteger;

public class RSA {
    
    static int[] generateKeys(int p, int q){
        //Funkcja generuje wartosci klucza publicznego i prywatnego dla danych liczb pierwszych
        //Zwraca kolejno wartosci n, e, oraz d jako tablicę
        int n = p * q;
        int fi = (p-1) * (q-1);

        //obliczanie e zgodnie z podanymi warunkami
        int e = 3;
        while (euclid(e,fi) != 1)
            e = e + 2;

        //obliczanie d korzystajac z rozszerzonego algorytmu euklidesa
        int d = extendedEuclid(e, fi);

        System.out.println("Klucz publiczny = (" + e +"," + n +")");
        System.out.println("Klucz prywatny = (" + d + "," + n +")" );

        int[] result = {n,e,d};

        return result;

    }

    static String encodeWord(String word, int e, int n){
        //do zakodowania korzystamy z klucza publicznego

        BigInteger[] coded_letters = new BigInteger[word.length()];
        char[] output = new char[word.length()];
        for (int i =  0; i < word.length(); i++)
        {   
            coded_letters[i] = BigInteger.valueOf(word.codePointAt(i));
            coded_letters[i] = (coded_letters[i].pow(e)).mod(BigInteger.valueOf(n));
            //System.out.println(coded_letters[i]);
            output[i] = (char) coded_letters[i].intValue();
        }

        return new String(output);
    }

    static String decodeWord(String word, int d, int n){
        //do odkodowania korzystamy z klucza prywatnego

        BigInteger[] decoded_letters = new BigInteger[word.length()];
        char[] output = new char[word.length()];
        for (int i =  0; i < word.length(); i++)
        {   
            decoded_letters[i] = BigInteger.valueOf(word.codePointAt(i));
            decoded_letters[i] = (decoded_letters[i].pow(d)).mod(BigInteger.valueOf(n));
            //System.out.println(decoded_letters[i]);
            output[i] = (char) decoded_letters[i].intValue();
        }

        return new String(output);

    }


    static int euclid(int a, int b){
        //prosty algorytm euklidesa
        int temp = 0;
        while (b != 0)
        {
            temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

    static int extendedEuclid(int a, int b){
        //rozszerzeony algorytm euklidesa
        int x0 = 1;
        int x = 0;
        int b0 = b;
        int q = 0;
        int temp = 0;
        while ( b!= 0){
            q = a/b;
            temp = x;
            x = x0 - q * x;
            x0 = temp;
            temp = a % b;
            a = b;
            b = temp;
        }
        if(x0 < 0 )
            x0 = x0 + b0;
        return x0;
    }

    public static void main(String[] args){

        int p = 397;
        int q = 103;

        int[] res = generateKeys(p,q);
        
        int n = res[0];
        int e = res[1];
        int d = res[2];
        
        System.out.println("n = " + n +" e = "+ e +" d = " + d );
        String str = args[0];
        System.out.println("Wyraz do zakodowania: " + args[0]);
        
        String coded_word = encodeWord(args[0], e, n);
        System.out.println(coded_word);

        String decoded_word = decodeWord(coded_word, d, n);
        System.out.println(decoded_word);

    }
}
