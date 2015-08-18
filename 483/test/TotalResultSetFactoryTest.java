import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

@Deprecated
public class TotalResultSetFactoryTest {

    @Test
    public void testGetResultSet() throws Exception {
        final NewResultSetFactory factory = new NewResultSetFactory(20);

        final ResultSet three = TotalResultSetFactory.getResultSet(3, factory);
        final ResultSet five = TotalResultSetFactory.getResultSet(5, factory);
        final ResultSet six = TotalResultSetFactory.getResultSet(6, factory);
        final ResultSet seven = TotalResultSetFactory.getResultSet(7, factory);
        final ResultSet eight = TotalResultSetFactory.getResultSet(8, factory);
        final ResultSet twenty = TotalResultSetFactory.getResultSet(20, factory);

        assertEquals("Three not the correct square sum!",
                BigInteger.valueOf(31),
                three.squareSum());

        assertEquals("Three not the correct count sum!",
                BigInteger.valueOf(6),
                three.countSum());

        assertEquals("Five not the correct square sum!",
                BigInteger.valueOf(2081),
                five.squareSum());

        assertEquals("Five not the correct count sum!",
                BigInteger.valueOf(120),
                five.countSum());

/*        assertEquals("Six not the correct count sum!",
                BigInteger.valueOf(720),
                six.countSum());
*/
/*        assertEquals("Seven not the correct count sum!",
                BigInteger.valueOf(5040),
                seven.countSum());
*/
        assertEquals("Eight not the correct count sum!",
                BigInteger.valueOf(40320),
                eight.countSum());

        assertEquals("Twenty not the correct count sum!",
                new BigInteger("2432902008176640000"),
                twenty.countSum());

        assertEquals("Twenty not the correct square sum!",
                new BigInteger("12422728886023769167301"),
                twenty.squareSum());
    }
}