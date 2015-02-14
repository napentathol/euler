import us.sodiumlabs.math.prime.PrimeCalculator;

import java.util.*;

public class Calculator {

    private final Integer[] fResults;

    private final Integer[] gResults;

    private final List[] primeResults;

    private final Set[] factorialResults;

    private final PrimeCalculator primeCalculator = new PrimeCalculator();

    public Calculator(final int memory) {
        fResults = new Integer[memory + 1];
        gResults = new Integer[memory + 1];
        primeResults = new List[memory + 1];
        factorialResults = new Set[memory + 1];
    }

    public int f(final int n) {
        if(n == 0) return 1;
        if(n == 1) return 6;

        if(n < fResults.length && fResults[n] != null)
            return fResults[n];

        int result = (3 * n * (n + 1) - 6);

        for (final int i : factorialDecomposition(n)) {
            result -= f(i);
        }

        if(n < fResults.length) fResults[n] = result;

        return result;
    }

    public int g(final int n) {
        if(n == 0) return 1;
        if(n == 1) return 7;

        if(n < gResults.length && gResults[n] != null)
            return gResults[n];

        int result = f(n) + g(n - 1);

        if(n < gResults.length) gResults[n] = result;

        return result;
    }

    @SuppressWarnings("unchecked")
    public Set<Integer> factorialDecomposition(final int n) {
        if(n < factorialResults.length && factorialResults[n] != null)
            return factorialResults[n];

        final Set<Integer> resultSet = new TreeSet<Integer>();

        final List<Integer> primeList = primeDecomposition(n);

        for(int s = 0; s < primeList.size(); s++){
            final List<Integer> tmp = new ArrayList<Integer>(primeList);
            tmp.remove(s);
            resultSet.addAll(recursiveFactorialDecomposition(tmp));
        }

        if(n < factorialResults.length) factorialResults[n] = resultSet;

        return resultSet;
    }

    private Set<Integer> recursiveFactorialDecomposition(final List<Integer> primeList) {
        if(primeList.size() == 0) return Collections.emptySet();

        final Set<Integer> resultSet = new TreeSet<Integer>();

        int i = 1;

        for(final int r : primeList) {
            i *= r;
        }

        resultSet.add(i);

        for(int s = 0; s < primeList.size(); s++){
            final List<Integer> tmp = new ArrayList<Integer>(primeList);
            tmp.remove(s);
            resultSet.addAll(recursiveFactorialDecomposition(tmp));
        }

        return resultSet;
    }

    @SuppressWarnings("unchecked")
    public List<Integer> primeDecomposition(final int n) {
        if(n < primeResults.length && primeResults[n] != null)
            return primeResults[n];

        final List<Integer> decompList = new ArrayList<Integer>();

        int number = n;

        for(final long i : primeCalculator.calculatePrimesUpToNumber(n/2)) {
            if(i == 1) break;

            while(number % i == 0) {
                number = number / (int)i;

                decompList.add((int)i);
            }
        }

        if(n < primeResults.length) primeResults[n] = decompList;

        return decompList;
    }
}
