import junit.framework.TestCase;

/**
 * The test class HandTest.
 *
 * @author Fiona
 * @version 1.0
 */
public class HandTest extends TestCase {

    public HandTest() {
    }

    public void testHasNKind() {
        Hand pairHand = new Hand("5C 5D AH QS 2D");
        assertTrue(pairHand.hasNKind(2));
        assertFalse(pairHand.hasNKind(3));
        Hand tripsHand = new Hand("TD TC TH 7C 7D");
        assertTrue(tripsHand.hasNKind(3));
        assertTrue(tripsHand.hasNKind(2));
        assertFalse(tripsHand.hasNKind(4));
    }

    public void testIsFlush() {
        Hand flushHand = new Hand("2C 5C 8C TC KC");
        Hand nonFlushHand = new Hand("2C 5C 8C TC KD");
        assertTrue(flushHand.isFlush());
        assertFalse(nonFlushHand.isFlush());
    }

    public void testIsStraight() {
        Hand straightHand = new Hand("5C 6D 7H 8S 9D");
        Hand nonStraightHand = new Hand("5C 6D 7H 8S KD");
        assertTrue(straightHand.isStraight());
        assertFalse(nonStraightHand.isStraight());
    }

    public void testKind() {
        Hand fullHouse = new Hand("TD TC TH 7C 7D");
        Hand pair = new Hand("5C 5D AH QS 2D");
        Hand highCard = new Hand("2C 5D 8H TC KD");
        assertEquals(Hand.Kind.FULL_HOUSE, fullHouse.kind());
        assertEquals(Hand.Kind.PAIR, pair.kind());
        assertEquals(Hand.Kind.HIGH_CARD, highCard.kind());
    }

    public void testCompareTo() {
        Hand fullHouse = new Hand("TD TC TH 7C 7D");
        Hand pair = new Hand("5C 5D AH QS 2D");

        assertTrue(fullHouse.compareTo(pair) > 0);
        assertTrue(pair.compareTo(fullHouse) < 0);
        assertEquals(0, pair.compareTo(new Hand("5S 5H AD QC 2C")));
    }
}