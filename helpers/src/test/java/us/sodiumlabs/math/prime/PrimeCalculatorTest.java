package us.sodiumlabs.math.prime;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeCalculatorTest {

    @Test
    public void testIsPrime() throws Exception {
        final PrimeCalculator testCalculator = new PrimeCalculator();

        notPrime(1, testCalculator);
        isPrime(2, testCalculator);
        isPrime(3, testCalculator);
        notPrime(4, testCalculator);
        isPrime(5, testCalculator);
        notPrime(6, testCalculator);
        isPrime(7, testCalculator);
        notPrime(8, testCalculator);
        notPrime(9, testCalculator);
        notPrime(10, testCalculator);
        isPrime(11, testCalculator);
        notPrime(12, testCalculator);
        isPrime(13, testCalculator);
    }

    private void isPrime(final int p, final PrimeCalculator primeCalculator) {
        assertTrue(p + " should be prime!", primeCalculator.isPrime(p));
    }

    private void notPrime(final int p, final PrimeCalculator primeCalculator) {
        assertFalse(p + " should not be prime!", primeCalculator.isPrime(p));
    }
}