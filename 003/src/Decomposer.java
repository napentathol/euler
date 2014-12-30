public class Decomposer {
    private final PrimeCalculator calculator = new PrimeCalculator();

    public long greatestFactorial(final long x) {
        long prime = calculator.reset();

        while(x % prime != 0) {
            if(839 == x) System.out.println(prime);
            prime = calculator.next();
        }

        return x / prime;
    }

    public long greatestPrimeFactorial(final long x) {
        final long greatestFactorial = greatestFactorial(x);

        if(greatestFactorial == 1){
            return x;
        } else {
            System.out.println(greatestFactorial);
            return greatestPrimeFactorial(greatestFactorial);
        }
    }
}
