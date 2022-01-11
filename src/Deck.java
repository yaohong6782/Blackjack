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
		this.cards = tempDeck; // shuffled  
	}

	public String toString() {
		String cardListString = "";
		for (Card aCard : this.cards) {
			cardListString += "\n" + aCard.toString();
		}
		return cardListString;
	}

	public void removeCard(int i) {
		this.cards.remove(i);
	}

	public Card getCard(int i) {
		return this.cards.get(i);
	}

	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}

	public void draw(Deck comingFrom) {
		this.cards.add(comingFrom.getCard(0)); // top of the deck
		comingFrom.removeCard(0);
	}
	
	public int deckSize() {
		return this.cards.size();
	}
	
	public void restartDeck(Deck moveTo) {
		int thisDeckSize = this.cards.size();
		
		for (int i = 0; i < thisDeckSize; i++) {
			moveTo.addCard(this.getCard(i));
		}
		for (int i = 0; i < thisDeckSize; i++) {
			this.removeCard(0);
		}
	}
	public int cardsValue() {
		int totalValue = 0;
		int aces = 0;

		for (Card aCard : this.cards) {
			switch(aCard.getValue()) {
			case TWO : totalValue+=2; break;
			case THREE : totalValue+=3; break;
			case FOUR : totalValue+=4; break;
			case FIVE : totalValue+=5; break;
			case SIX : totalValue+=6; break;
			case SEVEN : totalValue+=7; break;
			case EIGHT : totalValue+=8; break;
			case NINE : totalValue+=9; break;
			case TEN : totalValue+=10; break;
			case JACK : totalValue+=10; break;
			case QUEEN : totalValue+=10; break;
			case KING : totalValue+=10; break;
			case ACE : aces+=1; break;
			}
		}
		
		for (int i = 0; i < aces; i++) {
			if (totalValue > 10) {
				totalValue += 1;
			}
			else {
				totalValue += 11;
			}
		}
		return totalValue;
	}
}