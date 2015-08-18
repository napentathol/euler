import us.sodiumlabs.math.calculators.FactorialCalculator;

import java.math.BigInteger;

/**
 * Deprecated - Incorrect model.
 */
@Deprecated
public class TotalResultSetFactory {

    public static ResultSet getResultSet(
        final int val,
        final NewResultSetFactory newFactory
    ) {
        ResultSet set = newFactory.getNewResultSet(val)
                .merge(newFactory.getNewResultSet(1));

        for(int i = 2; i < val; i++) {
            set = set.merge(
                newFactory.getNewResultSet(i)
                    .multiply(newFactory.getFactCalc().combination(val, i))
            );
        }

        return set;
    }
}
