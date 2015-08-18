import us.sodiumlabs.math.IntegerRelationships;
import us.sodiumlabs.math.calculators.FactorialCalculator;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculationNode {
    private final CalculationNode parent;

    private final int value;

    private final int sum;

    private final BigInteger lcm;

    public CalculationNode(final CalculationNode parent, final int value) {
        this.parent = parent;
        this.value = value;
        this.sum = parent != null ?
                parent.sum + value :
                value;

        lcm = parent != null ?
                IntegerRelationships.lcm(parent.lcm, BigInteger.valueOf(value)) :
                BigInteger.valueOf(value);
    }

    public int getSum() {
        return sum;
    }

    public int getValue() {
        return value;
    }

    public CalculationNode getParent() {
        return parent;
    }

    public ResultNode getBranchResult(final FactorialCalculator calculator) {
        if(value == 1) return new ResultNode(1,1);

        final Map<Integer, Integer> valueCountMap = new HashMap<Integer, Integer>();

        CalculationNode next = this;

        while(next != null && next.value != 1) {
            if(valueCountMap.containsKey(next.getValue())){
                valueCountMap.put(next.value, valueCountMap.get(next.value) + 1);
            } else {
                valueCountMap.put(next.value, 1);
            }

            next = next.getParent();
        }

        return new ResultNode(
            lcm,
            calculator.combination(sum, value)
                    .multiply(convertValueCountMap(valueCountMap, calculator))
        );
    }

    private BigInteger convertValueCountMap(
        final Map<Integer, Integer> valueCountMap,
        final FactorialCalculator calculator
    ) {
        BigInteger result = BigInteger.ONE;

        for(final Map.Entry<Integer, Integer> entry : valueCountMap.entrySet()) {
            result = result.multiply(
                calculator.factorial(entry.getKey() - 1)
                    .pow(entry.getValue())
            ).divide(BigInteger.valueOf(entry.getValue()));
        }

        return result;
    }
}
