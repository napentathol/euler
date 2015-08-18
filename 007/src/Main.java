import us.sodiumlabs.math.prime.PrimeCalculator;

public class Main {
    public static void main(final String[] args) {
        final PrimeCalculator primeCalculator = new PrimeCalculator();

        System.out.println( primeCalculator.getNthPrime(10_000) );
    }
}
