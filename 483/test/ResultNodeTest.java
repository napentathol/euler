

import java.math.BigInteger;

import static org.junit.Assert.*;

public class ResultNodeTest {

    @org.junit.Test
    public void testInsertStraight() throws Exception {
        final ResultNode twoOne = new ResultNode(2, 2);
        final ResultNode twoTwo = new ResultNode(2, 3);
        final ResultNode oneOne = new ResultNode(1, 1);
        final ResultNode threeOne = new ResultNode(3, 4);
        final ResultNode fourOne = new ResultNode(4, 2);
        final ResultNode fiveOne = new ResultNode(5, 3);

        threeOne.getHead().insert(oneOne);
        threeOne.getHead().insert(twoOne);
        threeOne.getHead().insert(twoTwo);
        threeOne.getHead().insert(fiveOne);
        threeOne.getHead().insert(fourOne);

        ResultNode next = threeOne.getHead();
        next = runTestsAndNext(next, 1, 1);
        next = runTestsAndNext(next, 2, 5);
        next = runTestsAndNext(next, 3, 4);
        next = runTestsAndNext(next, 4, 2);
        next = runTestsAndNext(next, 5, 3);
        assertNull("Last not null!", next);
    }

    @org.junit.Test
    public void testInsertMerge() throws Exception {
        final ResultNode twoOne = new ResultNode(2, 2);
        final ResultNode twoTwo = new ResultNode(2, 3);
        final ResultNode oneOne = new ResultNode(1, 1);
        final ResultNode threeOne = new ResultNode(3, 4);
        final ResultNode fourOne = new ResultNode(4, 2);
        final ResultNode fiveOne = new ResultNode(5, 3);

        threeOne.getHead().insert(oneOne);
        threeOne.getHead().insert(twoOne);
        threeOne.getHead().insert(twoTwo);
        threeOne.getHead().insert(fiveOne);
        threeOne.getHead().insert(fourOne);

        final ResultNode oneTwo = new ResultNode(1,2);
        final ResultNode threeTwo = new ResultNode(3,2);
        final ResultNode fourTwo = new ResultNode(4,2);
        final ResultNode fiveTwo = new ResultNode(5,2);
        final ResultNode six = new ResultNode(6,12);
        final ResultNode seven = new ResultNode(7,14);

        threeTwo.getHead().insert(seven);
        threeTwo.getHead().insert(oneTwo);
        threeTwo.getHead().insert(fiveTwo);
        threeTwo.getHead().insert(six);
        threeTwo.getHead().insert(fourTwo);

        threeOne.getHead().insert(threeTwo.getHead());

        ResultNode next = threeOne.getHead();
        next = runTestsAndNext(next, 1, 3);
        next = runTestsAndNext(next, 2, 5);
        next = runTestsAndNext(next, 3, 6);
        next = runTestsAndNext(next, 4, 4);
        next = runTestsAndNext(next, 5, 5);
        next = runTestsAndNext(next, 6, 12);
        next = runTestsAndNext(next, 7, 14);
        assertNull("Last not null!", next);
    }

    private ResultNode runTestsAndNext(final ResultNode next, final int val, final int cnt) {
        assertEquals(
            "Incorrect value",
            BigInteger.valueOf(val),
            next.getValue()
        );
        assertEquals(
            "Incorrect count",
            BigInteger.valueOf(cnt),
            next.getCount()
        );
        return next.getNext();
    }

    @org.junit.Test
    public void testMultiplyCount() throws Exception {
        final ResultNode twoOne = new ResultNode(2, 2);
        final ResultNode twoTwo = new ResultNode(2, 3);
        final ResultNode oneOne = new ResultNode(1, 1);
        final ResultNode threeOne = new ResultNode(3, 4);
        final ResultNode fourOne = new ResultNode(4, 2);
        final ResultNode fiveOne = new ResultNode(5, 3);

        threeOne.getHead().insert(oneOne);
        threeOne.getHead().insert(twoOne);
        threeOne.getHead().insert(twoTwo);
        threeOne.getHead().insert(fiveOne);
        threeOne.getHead().insert(fourOne);

        threeOne.getHead().multiplyCount(5);

        ResultNode next = threeOne.getHead();
        next = runTestsAndNext(next, 1, 5);
        next = runTestsAndNext(next, 2, 25);
        next = runTestsAndNext(next, 3, 20);
        next = runTestsAndNext(next, 4, 10);
        next = runTestsAndNext(next, 5, 15);
        assertNull("Last not null!", next);
    }
}