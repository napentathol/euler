import us.sodiumlabs.math.calculators.FactorialCalculator;

public class CalculationTree {
    private final FactorialCalculator calculator;

    private final ResultSet resultSet;

    public CalculationTree (final int n, final FactorialCalculator calculator) {
        this.calculator = calculator;
        resultSet = new ResultSet();

        calculateBranch(null, 1, n);
    }

    private void calculateBranch(final CalculationNode parent, final int min, final int sum) {
        if (parent == null || parent.getSum() < sum) {
            final int max = parent == null ?
                    sum :
                    sum - parent.getSum();

            for(int i = min; i <= max; i++) {
                calculateBranch(new CalculationNode(parent, i), i, sum);
            }
        } else if(parent.getSum() == sum) {
            resultSet.insert(parent.getBranchResult(calculator));
        }
    }
}
