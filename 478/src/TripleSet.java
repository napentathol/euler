import java.util.*;

public class TripleSet {
	private final Set<Triple> tripleSet;

    private Set<TripleSet> powerSet = null;

	public TripleSet(final int n){
		tripleSet = createComparingSet();

		for(int i = 1; i <= n; i++) {
		for(int j = 0; j <= i; j++) {
		for(int k = 0; k <= j; k++) {
			final Triple triple = new Triple(i,j,k);
			if(triple.gcdEqualsOne()) {
				tripleSet.addAll(triple.getAssociateTriples());
			}
		}}}
	}

	private TripleSet(final Set<Triple> tripleSet) {
		this.tripleSet = tripleSet;
	}

    public int getEValue() {
        final Set<TripleSet> set = powerSet();

        int count = 0;

        for (final TripleSet triples : set) {
            if(triples.isUnary()) count++;
        }

        return count;
    }

	public int compareTo(final TripleSet set) {
		if(tripleSet.size() != set.tripleSet.size()) return tripleSet.size() - set.tripleSet.size();
		final Iterator<Triple> a1 = tripleSet.iterator();
		final Iterator<Triple> a2 = set.tripleSet.iterator();

		while(a1.hasNext() && a2.hasNext()) {
			final Triple t1 = a1.next();
			final Triple t2 = a2.next();

			if(t1.compareTo(t2) != 0) {
				return t1.compareTo(t2);
			}
		}

		return 0;
	}

    public boolean isUnary() {
        final AddTriple add = new AddTriple();

        for(final Triple triple : tripleSet) {
            add.add(triple);
        }

        return add.unary();
    }

	public Set<TripleSet> powerSet() {
        if(this.powerSet != null) return this.powerSet;

		final Set<TripleSet> powerSet = new TreeSet<TripleSet>(new Comparator<TripleSet>() {
			@Override
			public int compare(final TripleSet o1, final TripleSet o2) {
				return o1.compareTo(o2);
		}
		});

		powerSet.add(new TripleSet(copyTripleCollection(tripleSet)));

		for(int i = 0; i < tripleSet.size(); i++) {
			final List<Triple> tmp = new ArrayList<Triple>(tripleSet);
			tmp.remove(i);
			powerSetRecursive(tmp, powerSet);

		}

        this.powerSet = powerSet;

		return powerSet;
	}

	public String toString() {
		String s = "\n{";

		for(final Triple triple : tripleSet) {
			s += triple.toString();
		}

		return s + "}";
	}

	public int size(){
		return tripleSet.size();
	}

	private void powerSetRecursive(final List<Triple> triples, final Set<TripleSet> powerSet) {
		if(triples.size() == 0) return;

		powerSet.add(new TripleSet(copyTripleCollection(triples)));

		for(int i = 0; i < triples.size(); i++) {
			final List<Triple> tmp = new ArrayList<Triple>(triples);
			tmp.remove(i);
			powerSetRecursive(tmp, powerSet);
		}
	}

	private Set<Triple> copyTripleCollection(final Collection<Triple> collection) {
		final Set<Triple> set = createComparingSet();

		set.addAll(collection);

		return set;
	}

	private Set<Triple> createComparingSet() {
		return new TreeSet<Triple>(new Comparator<Triple>(){
			public int compare(final Triple o1, final Triple o2) {
				return o1.compareTo(o2);
			}

			public boolean equals(final Object o) {
				return false;
			}
		});
	}
}
