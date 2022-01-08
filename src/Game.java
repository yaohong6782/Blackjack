
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Game starting");
		
		Deck playingDeck = new Deck();
		playingDeck.newDeck();
		playingDeck.shuffle();
		System.out.println(playingDeck.toString());
	}

}
