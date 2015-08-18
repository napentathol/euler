import us.sodiumlabs.math.IntegerRelationships;

import java.math.BigInteger;

public class ResultSet {

    private ResultNode head;

    public void insert(final ResultNode node) {
        if(node == null) return;

        if(head == null) {
            head = node.getHead();
        } else {
            head.insert(node.getHead());

            head = head.getHead();
        }
    }

    public ResultNode getHead() {
        return head;
    }

    public BigInteger squareSum() {
        BigInteger sum = BigInteger.ZERO;

        ResultNode next = head;

        while(next != null) {
            sum = sum.add(
                    next.getValue()
                            .multiply(next.getValue())
                            .multiply(next.getCount())
            );

            next = next.getNext();
        }

        return sum;
    }

    public BigInteger countSum() {
        BigInteger sum = BigInteger.ZERO;

        ResultNode next = head;

        while(next != null) {
            sum = sum.add(next.getCount());
            next = next.getNext();
        }

        return sum;
    }

    public void print() {
        ResultNode next = head;

        while(next != null) {
            System.out.println(next.toString());
            next = next.getNext();
        }
        System.out.println();
    }

    // <editor-fold desc="Deprecated">

    /**
     * Deprecated - Incorrect model.
     */
    @Deprecated
    public ResultSet multiply(final BigInteger mult) {
        final ResultSet clone = deepClone();

        clone.head.multiplyCount(mult);

        return clone;
    }

    /**
     * Deprecated - Incorrect model.
     */
    @Deprecated
    public ResultSet convolve(final ResultSet set) {
        final ResultSet out = new ResultSet();

        ResultNode thisNext = this.head;
        while(thisNext != null) {

            ResultNode thatNext = set.head;
            while (thatNext != null) {
                out.insert(
                        new ResultNode(
                                IntegerRelationships.lcm(
                                        thisNext.getValue(),
                                        thatNext.getValue()
                                ),
                                thisNext.getCount().multiply(thatNext.getCount())
                        )
                );

                thatNext = thatNext.getNext();
            }
            thisNext = thisNext.getNext();
        }

        return out;
    }

    /**
     * Deprecated - Incorrect model.
     */
    @Deprecated
    public ResultSet merge( final ResultSet set ) {
        final ResultSet thisClone = this.deepClone();
        final ResultSet thatClone = set.deepClone();

        thisClone.insert(thatClone.head);

        return thisClone;
    }

    /**
     * Deprecated - Incorrect model.
     */
    @Deprecated
    public ResultSet deepClone() {
        final ResultSet output = new ResultSet();

        if(head != null) {
            ResultNode next = head;
            do {
                ResultNode cloneNext = new ResultNode(next.getValue(), next.getCount());
                output.insert(cloneNext);
                next = next.getNext();
            } while (next != null);
        }

        return output;
    }
    // </editor-fold>
}
