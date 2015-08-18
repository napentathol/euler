import us.sodiumlabs.math.prime.PrimeCalculator;

import java.util.stream.LongStream;

public class Main {
    public static void main(final String[] args) {
        System.out.println("Create prime calculator!");

        final PrimeCalculator primeCalculator = new PrimeCalculator();

        System.out.println("Start calculating primes up to 2,000,000");

        final long[] primes = primeCalculator.calculatePrimesUpToNumber(2_000_000);

        System.out.println("Sum primes.");

        final long count = LongStream.of( primes ).sum();

        System.out.println( count );
    }
}
