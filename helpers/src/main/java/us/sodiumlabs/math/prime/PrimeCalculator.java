package us.sodiumlabs.math.prime;

import java.util.Arrays;
import java.util.Iterator;

public class PrimeCalculator implements Iterable<Long> {

    private final CircleGenerator generator = new CircleGenerator();

    private long[] primeSet = new long[] {2,3,5,7};

    private long maxNumberCalulated = primeSet[primeSet.length - 1];

    private int nthNumberCalculated = primeSet.length - 1;

    private int nextErator = 0;

    public long[] calculatePrimesUpToNumber(final long n){
        while(n>maxNumberCalulated) {
            final long i = nextCircle();

            if(eratosthenes(i)) {
                insert(i);
            }

            maxNumberCalulated = i;
        }

        return Arrays.copyOf(primeSet, nthNumberCalculated + 1);
    }

    private long next() {
        nextErator++;

        if(nextErator <= nthNumberCalculated) return primeSet[nextErator];

        long i = 0;

        do {
            i = nextCircle();

            maxNumberCalulated = i;
        } while(!eratosthenes(i));

        insert(i);

        return i;
    }

    private boolean eratosthenes(final long i) {
        final double sqrt = Math.sqrt(i);

        if(sqrt % 1 == 0) return false;

        for(int n = 0; primeSet[n] < sqrt && n < primeSet.length; n++) {
            if(0 == i % primeSet[n]) {
                return false;
            }
        }

        return true;
    }

    private long nextCircle() {
        generator.updateCircle();

        long i = maxNumberCalulated + 1;
        circleLoop: for( ; ; i++) {
            final long mod = i % generator.getCircle();

            if(mod == 1) break;
            for(int j = generator.getNumOfPrimesInCircle() - 1; j < primeSet.length; j++){
                if(mod % primeSet[j] == 0){
                    break circleLoop;
                }
                if(primeSet[j] > mod) {
                    break;
                }
            }
        }

        return i;
    }

    private boolean insert(final long i) {
        if(++nthNumberCalculated >= primeSet.length) {
            final long[] tmp = primeSet;
            primeSet = new long[primeSet.length << 1];

            System.arraycopy(tmp, 0, primeSet, 0, tmp.length);
        }

        primeSet[nthNumberCalculated] = i;

        return true;
    }

    public Long getNthPrime(final int n) {
        while(n > nthNumberCalculated) {
            next();
        }

        return primeSet[n];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Long> iterator() {
        return new PrimeIterator(this);
    }


    private class CircleGenerator {
        protected int circle = 1;
        protected int newCircle = circle;
        private int numOfPrimesInCircle = 0;

        public void updateCircle() {
            final long largestPrime = primeSet[nthNumberCalculated];

            for( ; newCircle < largestPrime; numOfPrimesInCircle++) {
                circle = newCircle;
                newCircle *= primeSet[numOfPrimesInCircle];
            }
        }

        public int getNumOfPrimesInCircle() {
            return numOfPrimesInCircle;
        }

        public int getCircle() {
            return circle;
        }
    }
}
