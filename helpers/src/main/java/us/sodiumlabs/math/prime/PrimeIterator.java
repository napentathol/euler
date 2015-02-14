package us.sodiumlabs.math.prime;

import java.util.Iterator;

public class PrimeIterator implements Iterator<Long> {
    final PrimeCalculator calculator;

    int n = 0;

    public PrimeIterator(final PrimeCalculator longs) {
        calculator = longs;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return true;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws java.util.NoSuchElementException if the iteration has no more elements.
     */
    @Override
    public Long next() {
        final Long result = calculator.getNthPrime(n);

        n++;

        return result;
    }
}
