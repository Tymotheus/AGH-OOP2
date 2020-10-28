public class BigInt {
    //Custom class, representing big integer numbers from any range.
    //It is immutable, represents strictly possitive numbers.
    //Implements basic methods: add, toString, equals.

    private final Byte[] digit_tab;
    //Our number is stored in the big endian-like format. Highest digit is 
    //on the 0 index. It is declared as private so it is immutable.

    public BigInt(String digit_string){
        
        String[] temp_tab = digit_string.split("");
        digit_tab = new Byte[digit_string.length()];
        for (int i = 0; i< digit_string.length(); i++)
        {   
            //get the byte value
            byte b = Byte.parseByte(temp_tab[i]);
            digit_tab[i] = b;
        }
    }

    //Constructor fot byte tab argument
    public BigInt(byte[] tab){
        digit_tab = new Byte[tab.length];
        for (int i = 0; i < tab.length; i++)
        {
            digit_tab[i] = (tab[i]);
        }
    }

    //Constructor for BigInt argument
    public BigInt(BigInt number)
    {   
        //Calling the string argument based constructor
        this(number.toString());
    }

    public boolean equals(Object obj)
    {   
        if(obj.getClass() != this.getClass())
            return false;
        if(obj == this)
            return true;
        BigInt num = (BigInt) obj;
        if(this.digit_tab.length != num.digit_tab.length)
            return false;
        
        else{
            for(int i = 0; i<this.digit_tab.length; i++)
            {
                if (this.digit_tab[i].equals(num.digit_tab[i]) == false)
                    return false;
            }
        return true;
        }
    }

    public String toString()
    {   String output = "";
        for (int i = 0; i< digit_tab.length; i++)
            output += digit_tab[i].toString();
        return output;
    }

    public BigInt add(BigInt other)
    {
        String str1 = this.toString();
        String str2 = other.toString();
        if (str1.length() > str2.length()){
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        int size1 = str1.length();
        int size2 = str2.length();

        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();
        String resultString = "";

        int carry = 0;
        for (int idx = 0; idx < size1; idx++)
        {
            int sum = (str1.charAt(idx) - '0') +
                    (str2.charAt(idx) - '0') + carry;
            resultString += (char)(sum % 10 + '0');

            carry = sum / 10;
        }

        for (int idx = size1; idx < size2; idx++)
        {
            int sum = (str2.charAt(idx) - '0') + carry;
            resultString += (char)(sum % 10 + '0');
            carry = sum / 10;
        }

        if (carry > 0)
            resultString += (char)(carry + '0');

        resultString = new StringBuilder(resultString).reverse().toString();

        return new BigInt(resultString);
    }

    public final Byte[] getNum()
    {   
        Byte[] temp = digit_tab.clone();
        return temp;
    }

}
