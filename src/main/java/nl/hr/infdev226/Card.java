package nl.hr.infdev226;

/**
 * Card is een datastructuur die een suit en een number heeft.
 */
public class Card {
    private Suit suit;
    private Number number;

    public Card() {
    }

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }


	/**
	 * Pretty-print deze Card als string
	 */
    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", number=" + number +
                '}';
    }
}
