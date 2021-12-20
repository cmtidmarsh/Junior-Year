//iu username: cmtidmar

package DeckADT;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public interface DeckADT {
    // Step 1. create a full set of cards (52 cards; no Jokers)
    List<String> cards = new ArrayList<String>();
    public void initialize();



    // Step 2. draw a card, and return the card as string. For example
    // using single-letter representations for suits:
    // S (spades), C (clubs), H (hearts), and D (diamonds)
    public void drawRandomCard();
    public void drawTopCardFromDeck();
    public void shuffleDeck();

}

abstract class Cards implements DeckADT{
    //@Override
    public void initialize() {
        cards.add("AS");
        cards.add("2S"); // Spades
        cards.add("3S");
        cards.add("4S");
        cards.add("5S");
        cards.add("6S");
        cards.add("7S");
        cards.add("8S");
        cards.add("9S");
        cards.add("10S");
        cards.add("JS");
        cards.add("QS");
        cards.add("KS");

        cards.add("AH"); // Hearts
        cards.add("2H");
        cards.add("3H");
        cards.add("4H");
        cards.add("5H");
        cards.add("6H");
        cards.add("7H");
        cards.add("8H");
        cards.add("9H");
        cards.add("10H");
        cards.add("JH");
        cards.add("QH");
        cards.add("KH");

        cards.add("AC"); // Clubs
        cards.add("2C");
        cards.add("3C");
        cards.add("4C");
        cards.add("5C");
        cards.add("6C");
        cards.add("7C");
        cards.add("8C");
        cards.add("9C");
        cards.add("10C");
        cards.add("JC");
        cards.add("QC");
        cards.add("KC");

        cards.add("AD"); // Diamonds
        cards.add("2D");
        cards.add("3D");
        cards.add("4D");
        cards.add("5D");
        cards.add("6D");
        cards.add("7D");
        cards.add("8D");
        cards.add("9D");
        cards.add("10D");
        cards.add("JD");
        cards.add("QD");
        cards.add("KD");

    }



    public static void main(String[] args) {

    }

    // Step  3. create drawTopCardFromDeck() function

    // Step 4. create shuffleDeck() function

    // Step 5. Now write an implementation of the ADT, and save
    // it in a file named MyDeckOfCards.java.
    //
    // Within the MyDeckOfCards class, in the main()
    // method (as in previous labs) write Java code to
    // test your new ADT and class:
    // in order to test your code, instantiate at least 2 or 3
    // MyDeckOfCards objects, then call all the objects'
    // methods, several different times, and print out the
    // returned value(s).  Also, print out the content of
    // each MyDeckOfCards object, before and after all methods
    // have been called on that object.


}
