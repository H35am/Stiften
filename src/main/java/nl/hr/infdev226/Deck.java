package nl.hr.infdev226;

import java.util.Arrays;

/**
 * Een deck met Cards.
 *
 *Niet-functionele eisen:
 * - Alleen Card en Card[] mogen gebruikt worden als datastructuren (nog even geen Collections)
 *
 */
public class Deck {
	private Card[] cardArray;

	public Deck(){
		cardArray = new Card[0];
	}


    public Card[] getCardArray() {
        return cardArray;
    }

    public void setCardArray(Card[] cardArray) {
        this.cardArray = cardArray;
    }

    /**
	 * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
	 * harten en ruiten.
	 */
	public void fillDeck() {
        cardArray = new Card[52];
        int position = 0;
        Card card;

        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Number.values().length; j++) {
                card = new Card(Suit.values()[i], Number.values()[j]);
                cardArray[position] = card;

                position++;
            }
        }
    }

	/**
	 * Zoals gezegd is dit spel een beetje vreemd. Bijvoorbeeld: spelers kunnen
	 * kaarten toevoegen aan het deck. Hierdoor kan het aantal kaarten groter
	 * worden dan 52.
	 * 
	 * @param card
	 *            een Kaart
	 * @param index
	 *            Op positie
	 */
	public void insertAt(Card card, int index) {
        new RuntimeException("Not Implemented");
	}

	/**
	 * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
	 * met een bepaalde index er uit.
	 * 
	 * Merk op: na delete is de array zo groot als het aantal elementen dat er in zit.
	 * 
	 * @param index
	 */
	public void delete(int index) {
        new RuntimeException("Not Implemented");
	}

	/**
	 * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
	 * toegestaan de Java Random generator te gebruiken.
	 * 
	 */
	public void shuffle() {
        new RuntimeException("Not Implemented");
	}

	/**
	 * Een gegeven kaart moet worden opgezocht in de array, en de index ervan
	 * moet als return worden teruggegeven. Zie [Hubbard p.30]
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int sequentialSearch(Card card) {
        new RuntimeException("Not Implemented");
        return 0;
    }

	/**
	 * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
	 * als de volgorde hetzelfde is als na {@link #fillDeck()}
	 */
	public void sort() {
        new RuntimeException("Not Implemented");
	}

	/**
	 * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
	 * binary search manier zoals besproken in [Hubbart p.31].
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int binarySearch(Card card) {
        new RuntimeException("Not Implemented");
        return 0;
	}


    /**
     * Is het deck gesorteerd?
     * @return Is het deck gesorteerd?
     */
	public boolean isSorted(){
        new RuntimeException("Not Implemented");
        return true;
    }
	
	/**
	 *  Pretty-print het deck.
	 */
	@Override
	public String toString() {
		String str = "";
		
		for(int i=0; i<cardArray.length;i++){
			str += cardArray[i] + "\n";
		}
		return str;
		
	}
}
