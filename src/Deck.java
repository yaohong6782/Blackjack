import java.util.*;

public class Deck {
	
	// instance var
	ArrayList<Card> cards;
//	static ArrayList<String> val = new ArrayList<>(Arrays.asList("2","3","4","5","6","7","8","9","10", "JACK","QUEEN","KING","ACE"));
//	static ArrayList<String> sui = new ArrayList<>(Arrays.asList("HEART","SPADE","DIAMOND","CLUB"));
	// constructor
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public void newDeck() {
		for (Suit s : Suit.values()) {
			for (Value v : Value.values()) {
				this.cards.add(new Card(s,v));
			}
		}
	}
	
	public void shuffle() {
		ArrayList<Card> tempDeck = new ArrayList<>();
		Random rand = new Random();
		int randomPos = 0;
		int originalDeck = this.cards.size(); // 52
		
		for (int i = 0; i < originalDeck; i++) {
			// max - min + 1 + min // overflow
			randomPos = rand.nextInt((this.cards.size()-1-0)+1)+ 0;
			tempDeck.add(this.cards.get(randomPos));
			this.cards.remove(randomPos);
		}
		this.cards = tempDeck; //shuffled  
	}
	
	public String toString() {
		String cardListString = "";
		int i = 0; 
		for (Card aCard : this.cards) {
			cardListString += "\n" + i + " " + aCard.toString();
			i++;
		}
		return cardListString;
	}

}