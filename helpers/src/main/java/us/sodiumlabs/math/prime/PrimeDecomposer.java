package us.sodiumlabs.math.prime;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PrimeDecomposer {
    private final PrimeCalculator calculator = new PrimeCalculator();

    public long greatestFactorial(final long x) {
        final Iterator<Long> iterator = calculator.iterator();

        long prime = iterator.next();

        while(x % prime != 0) {
            prime = iterator.next();
        }

        return x / prime;
    }

    public long greatestPrimeFactorial(final long x) {
        final long greatestFactorial = greatestFactorial(x);

        if(greatestFactorial == 1){
            return x;
        } else {
            return greatestPrimeFactorial(greatestFactorial);
        }
    }

    public Set<Long> decompose(final long x) {
        final Set<Long> decomposeSet = new TreeSet<Long>();

        long number = x;

        for(final long i : calculator) {
            while(number % i == 0) {
                decomposeSet.add(i);

                number = number / i;
            }

            if(number == 1) break;
        }

        return decomposeSet;
    }
}
