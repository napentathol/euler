import us.sodiumlabs.math.prime.PrimeDecomposer;

import java.util.Arrays;

public class P005 {
    public static void main(final String[] args) {
        final PrimeDecomposer decomposer = new PrimeDecomposer();

        for (int i = 1; i <= 20; i++) {
            System.out.println(Arrays.toString(decomposer.decompose(i).toArray()));
        }
    }
}
