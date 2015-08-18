package us.sodiumlabs.math;

import us.sodiumlabs.math.prime.PrimeDecomposer;

import java.math.BigInteger;
import java.util.Set;

public class IntegerRelationships {

    public static BigInteger gcd(final BigInteger ... numbers){
        BigInteger result = numbers[0];
        for(int i = 1; i < numbers.length; i++) result = result.gcd(numbers[i]);
        return result;
    }

    public static BigInteger lcm(final BigInteger ... numbers){
        BigInteger result = numbers[0];
        for(int i = 1; i < numbers.length; i++) result = lcm(result, numbers[i]);
        return result;
    }

    public static BigInteger lcm(final BigInteger a, final BigInteger b) {
        return a.multiply(b.divide(a.gcd(b)));
    }
}
