public class Main {
    public static void main(final String[] args) {
        final Decomposer decomposer = new Decomposer();

        System.out.println("result: " + decomposer.greatestPrimeFactorial(210L));
        System.out.println("result: " + decomposer.greatestPrimeFactorial(2310L));
        System.out.println("result: " + decomposer.greatestPrimeFactorial(600851475143L));
    }
}
