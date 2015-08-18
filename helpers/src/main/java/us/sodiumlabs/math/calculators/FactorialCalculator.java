package us.sodiumlabs.math.calculators;

import java.math.BigInteger;

public class FactorialCalculator {
    private BigInteger[] results;

    public FactorialCalculator(final int priming) {
        results = new BigInteger[priming + 1];

        results[0] = BigInteger.ONE;

        for(int i = 1; i < results.length; i++) {
            results[i] = results[i-1].multiply(BigInteger.valueOf(i));
        }
    }

    public BigInteger factorial(final int n) {
        return results[n];
    }

    public BigInteger permutation(final int n, final int k) {
        if(k > n) return BigInteger.ZERO;

        return results[n].divide(results[n - k]);
    }

    public BigInteger combination(final int n, final int k) {
        if(k > n) return BigInteger.ZERO;

        return permutation(n,k).divide(results[k]);
    }
}
