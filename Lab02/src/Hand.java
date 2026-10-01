import java.util.*;

/**
 * A poker hand is a list of cards, which can be of some "kind" (pair, straight, etc.)
 * 
 */
public class Hand implements Comparable<Hand> {

    public enum Kind {HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, 
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH}

    private final List<Card> cards;

    /**
     * Create a hand from a string containing all cards (e,g, "5C TD AH QS 2D")
     */
    public Hand(String c) {
        this.cards = new ArrayList<>();
        String[] cardNames = c.split(" "); //create an array of the names of cards to be added
        for(int i = 0; i<5; i++)    //loop through this array
        {
            cards.add(new Card(cardNames[i])); //create a new card and add it to the cards ArrayList
        }
    }
    
    /**
     * @returns true if the hand has n cards of the same rank
	 * e.g., "TD TC TH 7C 7D" returns True for n=2 and n=3, and False for n=1 and n=4
     */
    protected boolean hasNKind(int n) {
        int[] ranks = new int[13];  //create an array to hold the count of each rank
        for(Card c : cards)
        {
            ranks[c.getRank().ordinal()] ++;    //for each rank in the hand, increase this count
        }
        for(int i:ranks)    //loop through counts to see if there are n of one card
        {
            if(i ==n)
                return true;
        }
        return false;
    }
    
    /**
	 * Optional: you may skip this one. If so, just make it return False
     * @returns true if the hand has two pairs
     */
    public boolean isTwoPair() {
        int[] ranks = new int[13];  //create an array to hold the count of each rank
        for(Card c : cards)
        {
            ranks[c.getRank().ordinal()] ++;    //for each rank in the hand, increase this count
        }
        int pairs = 0;
        for(int i = 0; i<13; i++){
            if(ranks[i] == 2)
            {
                pairs++;
            }
        }
        if(pairs == 2)
            return true;
        return false;


    }   
    
    /**
     * @returns true if the hand is a straight 
     */
    public boolean isStraight() {
        int[] ranks = new int[5]; //create an array to hold the int ranks
        for (int i = 0; i < 5; i++) {
            ranks[i] = cards.get(i).getRank().ordinal();    //add the int ranks
        }
        Arrays.sort(ranks);
        int[] lowAce = {0, 1, 2, 3, 12};
        if(Arrays.equals(ranks, lowAce))
            return true;
        for(int i = 0; i<4; i++)
        {
            if(ranks[i+1] != ranks[i] +1)
                return false;
        }
        return true;
    }
    
    /**
     * @returns true if the hand is a flush
     */
    public boolean isFlush() {
        int suit = cards.get(0).getSuit().ordinal(); //get the suit of the first card
        for(int i = 1; i<5; i++)
        {
            if(cards.get(i).getSuit().ordinal() != suit)
                return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Hand h) {
        return(this.kind().compareTo(h.kind())); //compare the enumerations of each kind/hand
    }
    
    /**
	 * This method is already implemented and could be useful! 
     * @returns the "kind" of the hand: flush, full house, etc.
     */
    public Kind kind() {
        if (isStraight() && isFlush()) return Kind.STRAIGHT_FLUSH;
        else if (hasNKind(4)) return Kind.FOUR_OF_A_KIND; 
        else if (hasNKind(3) && hasNKind(2)) return Kind.FULL_HOUSE;
        else if (isFlush()) return Kind.FLUSH;
        else if (isStraight()) return Kind.STRAIGHT;
        else if (hasNKind(3)) return Kind.THREE_OF_A_KIND;
        else if (isTwoPair()) return Kind.TWO_PAIR;
        else if (hasNKind(2)) return Kind.PAIR; 
        else return Kind.HIGH_CARD;
    }

}
