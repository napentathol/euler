import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class P029 {

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
	final P029 five = new P029();

	five.aTerate(5);

	final P029 hundo = new P029();

	hundo.aTerate(100);
}}
