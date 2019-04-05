public class P478 {
	public static void main(final String[] args){
		final Calculator calculator = new Calculator(36);

		for(int n = 0; n <= 1; n++) {
			final TripleSet tripleSet = new TripleSet(n);

			System.out.println("N: "+ n +
					"\tF(n): " + calculator.f(n) +
					" \tG(n): " + calculator.g(n) +
					" \tSize: " + tripleSet.size() +
					" \tPower: " + tripleSet.powerSet().size() +
                    " \tUnaries: " + tripleSet.getEValue() +
                    " \tRejected: " + (tripleSet.powerSet().size() - tripleSet.getEValue())
			);
		}
	}
}
