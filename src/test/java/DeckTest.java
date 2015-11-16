import nl.hr.infdev226.Card;
import nl.hr.infdev226.Deck;
import nl.hr.infdev226.Number;
import nl.hr.infdev226.Suit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeckTest {
    Deck deck;

    @Before
    public void setup(){
        deck = new Deck();
        Card[] cards = {
                new Card(Suit.HARTEN, Number.TWEE),
                new Card(Suit.HARTEN, Number.DRIE),
                new Card(Suit.HARTEN, Number.VIER),
                new Card(Suit.HARTEN, Number.VIJF)
        };
        deck.setCardArray(cards);
    }

    @Test
    public void sequentialSearchTest(){
        Card card = new Card(Suit.HARTEN, Number.VIER);
        int expectedIndex = 2;

        deck.insertAt(card, expectedIndex);
        int actualIndex = deck.sequentialSearch(card);
        assertTrue(actualIndex == expectedIndex);
    }


    @Test
    public void binarySearchTest(){
        Card card = new Card(Suit.HARTEN, Number.VIER);
        int expectedIndex = 2;

        int actualIndex = deck.binarySearch(card);

        assertTrue(actualIndex == expectedIndex);
    }


    /**
     * De volgende test faalt met deze error message:
     * Expected :nl.hr.infdev226.Card<Card{suit=KLAVER, number=TWEE}>
     * Actual   :nl.hr.infdev226.Card<Card{suit=KLAVER, number=TWEE}>
     *
     * Het lijkt alsof ze 'equal' zijn, maar blijkbaar is dat niet zo.
     * Zorg dat deze test kan slagen.
     */
    @Test
    public void fillDeckTest(){
        deck.fillDeck();

        //Nu geimplementeerd door een steekproef
        assertEquals(deck.getCardArray()[0], new Card(Suit.KLAVER, Number.TWEE));
        assertEquals(deck.getCardArray()[51], new Card(Suit.RUITEN, Number.AAS));
    }


    @Test
    public void testInsertAt() {
        Card card1 = new Card(Suit.HARTEN, Number.TWEE);
        Card card2 = new Card(Suit.HARTEN, Number.AAS);
        Card card3 = new Card(Suit.KLAVER, Number.VIER);
        Card card4 = new Card(Suit.SCHOPPEN, Number.VIJF);

        deck.insertAt(card1, 0);
        deck.insertAt(card2, 1);
        deck.insertAt(card3, 2);
        deck.insertAt(card4, 3);

        Deck result = new Deck();
        Card[] expected = {card1, card2, card3, card4};
        deck.setCardArray(expected);

        assertEquals(result, deck);
    }

    @Test
    public void testDelete() {
        deck.delete(0);
        deck.delete(1);
        deck.delete(2);
        deck.delete(3);

        Deck expected = new Deck();
        deck.setCardArray(new Card[]{});
        assertEquals(expected, deck);

        int expectedSize = 0;
        assertEquals(expectedSize, deck.getCardArray().length);
    }


    @Test
    public void testSequentialSearch() {
        Card card1 = new Card(Suit.HARTEN, Number.TWEE);
        Card card2 = new Card(Suit.HARTEN, Number.AAS);
        Card card3 = new Card(Suit.KLAVER, Number.VIER);
        Card card4 = new Card(Suit.SCHOPPEN, Number.VIJF);

        deck.insertAt(card1, 0);
        deck.insertAt(card2, 1);
        deck.insertAt(card3, 2);


        assertEquals(deck.sequentialSearch(card1), 0);
    }

    @Test
    public void testSort() {
        deck.fillDeck();
        deck.shuffle();


        Deck deck2 = new Deck();
        deck2.fillDeck();
        deck.sort();
        assertEquals("result", deck, deck2);
    }

    @Test
    public void testIsSorted() {
        Deck d= new Deck();
        d.fillDeck();

        assertTrue("Gesorteerd", d.isSorted());

        //Pas op! het volgende is een op de
        //80658175170943878571660636856403766975289505440883277824000000000000
        //keer niet geldig
        d.shuffle();
        assertFalse(d.isSorted());
    }

    @Test
    public void testBinarySearchCard() {
        deck.fillDeck();

        assertEquals("0", 0, deck.binarySearch(new Card(Suit.KLAVER, Number.TWEE)));

        deck.delete(0);
        assertEquals("1", -1, deck.binarySearch(new Card(Suit.KLAVER, Number.TWEE)));
    }
}
