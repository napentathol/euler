package us.sodiumlabs.math;

import java.util.Set;
import java.util.TreeSet;

public class SetManipulator {

    public static <T> Set<T> intersection(final Set<T> a, final Set<T> b) {
        final Set<T> outSet = new TreeSet<T>();

        for(final T tmp : a) {
            if(b.contains(tmp)) {
                outSet.add(tmp);
            }
        }

        return outSet;
    }
}
