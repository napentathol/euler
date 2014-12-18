import java.util.Arrays;

public class PrimeCalculator {

    private final CircleGenerator generator = new CircleGenerator();

    private int[] primeSet = new int[] {2,3,5,7,11,13,17,19};

    private int maxNumberCalulated = primeSet[primeSet.length - 1];

    public int nthNumberCalculated = primeSet.length - 1;

    public int[] calculatePrimesUpToNumber(final int n){
        while(n>maxNumberCalulated) {
            final int i = nextCircle();

            if(eratosthenes(i)) {
                insert(i);
            }

            maxNumberCalulated = i;
        }

        return Arrays.copyOf(primeSet, nthNumberCalculated + 1);
    }

    private boolean eratosthenes(final int i) {
        final double sqrt = Math.sqrt(i);

        if(sqrt % 1 == 0) return false;

        for(int n = 0; primeSet[n] < sqrt && n < primeSet.length; n++) {
            if(0 == i % primeSet[n]) {
                return false;
            }
        }

        return true;
    }

    private int nextCircle() {
        generator.updateCircle();

        int i = maxNumberCalulated + 1;
        circleLoop: for( ; ; i++) {
            final int mod = i % generator.getCircle();

            if(mod == 1) break;
            for(int j = generator.getNumOfPrimesInCircle() -1; j < primeSet.length; j++){
                if(mod == primeSet[j]){
                    break circleLoop;
                }
            }
        }

        return i;
    }

    private boolean insert(final int i) {
        if(++nthNumberCalculated >= primeSet.length) {
            final int[] tmp = primeSet;
            primeSet = new int[primeSet.length << 1];

            System.arraycopy(tmp, 0, primeSet, 0, tmp.length);
        }

        primeSet[nthNumberCalculated] = i;

        return true;
    }


    private class CircleGenerator {
        protected int circle = 1;
        protected int newCircle = circle;
        private int numOfPrimesInCircle = 0;

        public void updateCircle() {
            final int largestPrime = primeSet[nthNumberCalculated];

            for( ; newCircle < largestPrime; numOfPrimesInCircle++) {
                circle = newCircle;
                newCircle *= primeSet[numOfPrimesInCircle];
            }
        }

        public int getNumOfPrimesInCircle() {
            return numOfPrimesInCircle;
        }

        public int getCircle() {
            return circle;
        }
    }
}
