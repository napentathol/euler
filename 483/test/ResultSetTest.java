import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class ResultSetTest {

    @Test
    public void testSquareSum() throws Exception {
        final ResultSet setOne = createResultSetOne();

        assertEquals("Set one square sum not as expected!",
                BigInteger.valueOf(263), // 4*2 + 25*3 + 36*5
                setOne.squareSum());

        final ResultSet setTwo = createResultSetTwo();

        assertEquals("Set two square sum not as expected!",
                BigInteger.valueOf(1540), // 9*7 + 16*11 + 36*13 + 49*17
                setTwo.squareSum());
    }

    @Test
    public void testMerge() throws Exception {
        final ResultSet setOne = createResultSetOne();
        final ResultSet setTwo = createResultSetTwo();

        final ResultSet result = setOne.merge(setTwo);

        testResultSetOne(setOne);
        testResultSetTwo(setTwo);

        ResultNode next = result.getHead();

        next = testResultNode(next, 2, 2);
        next = testResultNode(next, 3, 7);
        next = testResultNode(next, 4, 11);
        next = testResultNode(next, 5, 3);
        next = testResultNode(next, 6, 18);
        next = testResultNode(next, 7, 17);

        assertNull("Final node should be null!", next);
    }

    @Test
    public void testDeepClone() throws Exception {
        final ResultSet setOne = createResultSetOne();
        final ResultSet setTwo = createResultSetTwo();

        final ResultSet result = setOne.deepClone();

        testResultSetOne(setOne);
        testResultSetOne(result);
        testResultSetTwo(setTwo);

        result.insert(setTwo.getHead());

        ResultNode next = result.getHead();

        next = testResultNode(next, 2, 2);
        next = testResultNode(next, 3, 7);
        next = testResultNode(next, 4, 11);
        next = testResultNode(next, 5, 3);
        next = testResultNode(next, 6, 18);
        next = testResultNode(next, 7, 17);

        assertNull("Final node should be null!", next);
    }

    @Test
    public void testConvolve() throws Exception {
        final ResultSet setOne = createResultSetOne();
        final ResultSet setTwo = createResultSetTwo();

        final ResultSet result = setOne.convolve(setTwo);

        testResultSetOne(setOne);
        testResultSetTwo(setTwo);

        ResultNode next = result.getHead();

        next = testResultNode(next, 4, 22);
        next = testResultNode(next, 6, 140); // 14 + 26 + 35 + 65 = 40 + 100 = 140
        next = testResultNode(next, 12, 55);
        next = testResultNode(next, 14, 34);
        next = testResultNode(next, 15, 21);
        next = testResultNode(next, 20, 33);
        next = testResultNode(next, 30, 39);
        next = testResultNode(next, 35, 51);
        next = testResultNode(next, 42, 85);

        assertNull("Final node should be null!", next);
    }

    private ResultSet createResultSetOne() {
        final ResultSet setOne = new ResultSet();

        setOne.insert(new ResultNode(2,2));
        setOne.insert(new ResultNode(5,3));
        setOne.insert(new ResultNode(6,5));

        return setOne;
    }

    private ResultSet createResultSetTwo() {
        final ResultSet setTwo = new ResultSet();

        setTwo.insert(new ResultNode(3, 7));
        setTwo.insert(new ResultNode(4, 11));
        setTwo.insert(new ResultNode(6, 13));
        setTwo.insert(new ResultNode(7, 17));

        return setTwo;
    }

    private void testResultSetOne(final ResultSet set) {
        ResultNode next = set.getHead();

        next = testResultNode(next, 2, 2);
        next = testResultNode(next, 5, 3);
        next = testResultNode(next, 6, 5);

        assertNull("Final node should be null!", next);
    }

    private void testResultSetTwo(final ResultSet set) {
        ResultNode next = set.getHead();

        next = testResultNode(next, 3, 7);
        next = testResultNode(next, 4, 11);
        next = testResultNode(next, 6, 13);
        next = testResultNode(next, 7, 17);

        assertNull("Final node should be null!", next);
    }

    private ResultNode testResultNode(final ResultNode node, final int val, final int cnt) {
        assertEquals("Value not as expected!", BigInteger.valueOf(val), node.getValue());
        assertEquals("Count not as expected!", BigInteger.valueOf(cnt), node.getCount());

        return node.getNext();
    }
}