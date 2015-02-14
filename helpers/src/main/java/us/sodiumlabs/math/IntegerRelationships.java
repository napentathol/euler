package us.sodiumlabs.math;

import us.sodiumlabs.math.prime.PrimeDecomposer;

import java.util.Set;

public class IntegerRelationships {

    private final PrimeDecomposer decomposer;

    public IntegerRelationships(final PrimeDecomposer decomposer){
        this.decomposer = decomposer;
    }

    public long GCD(final long ... numbers){
        Set<Long> longs = null;

        for (final long n :numbers) {
            if(null == longs) {
                longs = decomposer.decompose(n);
            } else {
                longs = SetManipulator.intersection(longs, decomposer.decompose(n));
            }
        }

        return recompose();
    }

    public long recompose(final Set<Long> set) {
        long out = 1;

        for(final long l : set) {
            out *= l;
        }

        return out;
    }
}
