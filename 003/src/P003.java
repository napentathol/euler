import us.sodiumlabs.math.prime.PrimeDecomposer;

public class P003 {
    public static void main(final String[] args) {
        final PrimeDecomposer decomposer = new PrimeDecomposer();

        System.out.println("result: " + decomposer.greatestPrimeFactorial(210L));
        System.out.println("result: " + decomposer.greatestPrimeFactorial(2310L));
        System.out.println("result: " + decomposer.greatestPrimeFactorial(600851475143L));
    }
}
