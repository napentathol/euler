import us.sodiumlabs.math.prime.PrimeCalculator;

import java.math.BigInteger;

public class Main {
    private PrimeCalculator primeCalculator = new PrimeCalculator();

    private int maxSize = 0;

    public static void main(final String[] args) {
        final Main main = new Main();

        for(int i = 1; i < 1000; i++) {
            main.compareCycleSize(i);
        }
    }

    public void compareCycleSize(final int p) {
        final BigInteger cycle = cyclic(p);
        final int cycleSize = cycle.toString().length();

        if(cycleSize > maxSize) {
            maxSize = cycleSize;
            System.out.println(p + ": " + maxSize + " : " + cycle.toString());
        }
    }

    private BigInteger cyclic(final int p) {
        if( primeCalculator.isPrime(p) && !BigInteger.TEN.gcd(BigInteger.valueOf(p)).equals(BigInteger.TEN) ) {
            return BigInteger.TEN.pow(p).subtract(BigInteger.ONE).divide(BigInteger.valueOf(p));
        }

        return BigInteger.ZERO;
    }
}
