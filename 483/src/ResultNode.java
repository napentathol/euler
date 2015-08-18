import java.math.BigInteger;

public class ResultNode {
    private final BigInteger value;
    private BigInteger count;
    private ResultNode next;
    private ResultNode prev;

    public ResultNode(final BigInteger value, final BigInteger count) {
        this.value = value;
        this.count = count;
    }

    public ResultNode(final int value, final int count) {
        this(BigInteger.valueOf(value), BigInteger.valueOf(count));
    }

    public void insert(final ResultNode node){
        if(node == null) return;

        if(node.value.compareTo(value) == -1) {
            final ResultNode tmp = node.next;

            if(prev != null) prev.next = node;
            node.prev = prev;
            node.next = this;
            prev = node;

            insert(tmp);
        } else if(node.value.equals(value)) {
            count = count.add(node.count);

            insert(node.next);
        } else if (next != null) {
            next.insert(node);
        } else {
            next = node;
            node.prev = this;
        }
    }

    public ResultNode getHead() {
        if(prev == null) return this;
        return prev.getHead();
    }

    public ResultNode getNext() {
        return next;
    }

    public BigInteger getCount() {
        return count;
    }

    public BigInteger getValue() {
        return value;
    }

    public String toString() {
        return "ResultString " + value + ", " + count;
    }

    // <editor-fold desc="Deprecated">
    @Deprecated
    public void multiplyCount(final BigInteger mult) {
        count = count.multiply(mult);
        if(next != null) next.multiplyCount(mult);
    }
    @Deprecated
    public void multiplyCount(final int mult) {
        this.multiplyCount(BigInteger.valueOf(mult));
    }
    // </editor-fold>
}
