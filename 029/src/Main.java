import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class Main {

private List<BigInteger> resList = new ArrayList<BigInteger>();

public void pushPow(final int a, final int b) {
	final BigInteger result = BigInteger.valueOf(a).pow(b);

	if(!resList.contains(result)) {
		resList.add(result);
	}
}

public void bTerate(final int a, final int k) {
	for(int i = 2; i <= k; i++) {
		pushPow(a,i);
	}
}

public void aTerate(final int k) {
	for(int i = 2; i <= k; i++) {
		bTerate(i,k);
	}

	System.out.println(resList.size());
}

public static void main(final String[] args) {
	final Main five = new Main();

	five.aTerate(5);

	final Main hundo = new Main();

	hundo.aTerate(100);
}}
