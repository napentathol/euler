import us.sodiumlabs.math.calculators.FactorialCalculator;

import java.math.BigInteger;

/**
 * Deprecated - Incorrect model.
 */
@Deprecated
public class NewResultSetFactory {
    private final ResultSet[] resultSets;

    private final FactorialCalculator factCalc;

    private static final ResultSet ONE = new ResultSet();

    static {
        ONE.insert(new ResultNode(1, 1));
    }

    public NewResultSetFactory(final int priming) {
        resultSets = new ResultSet[priming - 1];

        factCalc = new FactorialCalculator(priming);
    }

    private ResultSet createNewResults(final int n) {
        ResultSet out = new ResultSet();

        out.insert(new ResultNode(
            BigInteger.valueOf(n),
            factCalc.factorial(n - 1)
        ));

        for(int i = 2; i < n / 2.0; i++) {
            out = out.merge(
                getNewResultSet(i).convolve(
                    getNewResultSet(n - i).multiply(
                        factCalc.combination(n, n - i)
                )));
        }

        if(n % 2 == 0 && n != 2) {
            out = out.merge(getNewResultSet(n/2).multiply(
                factCalc.combination(n, n/2)
                    .divide(BigInteger.valueOf(2))
            ));
        }

        System.out.println("Results: " + n);
        out.print();

        return out;
    }

    public ResultSet getNewResultSet(final int n) {
        if(n > resultSets.length + 1) throw new RuntimeException("Value greater than priming value!");

        if(n == 1) return ONE;


        if(resultSets[n - 2] == null) {
            resultSets[n - 2] = createNewResults(n);
        }

        return resultSets[n - 2];
    }

    public FactorialCalculator getFactCalc() {
        return factCalc;
    }
}
