import java.math.BigInteger;

public class P016 {
    public static final BigInteger TWO = new BigInteger("2");

    public static void main(final String[] args) {
        printPowerDigitalSum(0);
        printPowerDigitalSum(2);
        printPowerDigitalSum(5);
        printPowerDigitalSum(10);
        printPowerDigitalSum(15);
        printPowerDigitalSum(100);
        printPowerDigitalSum(1000);
    }

    public static BigInteger pow(final int x) {
        return TWO.pow(x);
    }

    public static int digitalSum(final BigInteger x) {
        final String s = x.toString();

        int res = 0;

        for(final char c : s.toCharArray()){
            res += Character.getNumericValue(c);
        }

        return res;
    }

    public static void print(final String s) {
        System.out.println(s);
    }

    public static void printPowerDigitalSum(final int x) {
        print("Digital sum of 2^" + x + ":" + digitalSum(pow(x)));
    }
}
