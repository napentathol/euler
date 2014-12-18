import java.util.Comparator;
import java.util.TreeSet;
import java.util.Set;

public class Triple {
	private final int x;
	private final int y;
	private final int z;

	public Triple(final int x, final int y, final int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public boolean gcdEqualsOne(){
		return gcd(x,gcd(y,z)) == 1;
	}

	public int compareTo(final Triple o2) {
		if(x == o2.x) {
			if(y == o2.y) {
				if(z == o2.z) {
					return 0;
				} else {
					return z - o2.z;
				}
			} else {
				return y - o2.y;
			}
		} else {
			return x - o2.x;
		}
	}

	public Set<Triple> getAssociateTriples() {
		final TreeSet<Triple> tripleSet = new TreeSet<Triple>(new Comparator<Triple>(){
			public int compare(final Triple o1, final Triple o2) {
				return o1.compareTo(o2);
			}

			public boolean equals(final Object o) {
				return false;
			}
		});

		addAssociateTriples(tripleSet);

		addInverseTriples(tripleSet);

		return tripleSet;
	}

	private void addInverseTriples(final TreeSet<Triple> tripleSet) {
		if(x != y || x != z) {
			final Triple inverse = new Triple(x, x - y, x - z);

			inverse.addAssociateTriples(tripleSet);
		}
	}

	private void addAssociateTriples(final TreeSet<Triple> tripleSet) {
		tripleSet.add(new Triple(x, y, z));
		tripleSet.add(new Triple(x, z, y));
		tripleSet.add(new Triple(y, z, x));
		tripleSet.add(new Triple(y, x, z));
		tripleSet.add(new Triple(z, x, y));
		tripleSet.add(new Triple(z, y, x));
	}

	private int gcd(final int i, final int j) {
		if(i < j)  return gcd(j,i);
		if(j == 0) return i;

		return gcd(j, i % j);
	}

	public String toString() {
		return "( "+x+", "+y+", "+z+") ";
	}
}
