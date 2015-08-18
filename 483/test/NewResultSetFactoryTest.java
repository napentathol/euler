import org.junit.Test;

import static org.junit.Assert.*;

@Deprecated
public class NewResultSetFactoryTest {

    @Test
    public void testGetNewResultSet() throws Exception {
        final NewResultSetFactory factory = new NewResultSetFactory(7);

        testResultSet(factory.getNewResultSet(1), new ResultNode(1, 1));
        testResultSet(factory.getNewResultSet(2), new ResultNode(2, 1));
        testResultSet(factory.getNewResultSet(3), new ResultNode(3, 2));
        testResultSet(factory.getNewResultSet(4),
                new ResultNode(2, 3),
                new ResultNode(4, 6));
        testResultSet(factory.getNewResultSet(5),
                new ResultNode(5, 24),
                new ResultNode(6, 20));
        testResultSet(factory.getNewResultSet(6),
                new ResultNode(2, 45),
                new ResultNode(3, 20),
                new ResultNode(4, 90),
                new ResultNode(6, 120));
        testResultSet(factory.getNewResultSet(7),
                new ResultNode(6, 630),
                new ResultNode(7, 720),
                new ResultNode(10, 504),
                new ResultNode(12, 420));
    }

    public void testResultSet(final ResultSet set, final ResultNode ... nodes) {
        ResultNode next = set.getHead();

        for(final ResultNode node : nodes) {
            assertNotNull("Node should not be null!", next);

            assertEquals("Value not equivalent", node.getValue(), next.getValue());
            assertEquals("Count not equivalent", node.getCount(), next.getCount());

            next = next.getNext();
        }

        assertNull("Last node should be null!", next);
    }
}