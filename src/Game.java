import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Game starting");
		
		Scanner sc = new Scanner(System.in);
		
		Deck playingDeck = new Deck();
		playingDeck.newDeck();
		playingDeck.shuffle();
		
		Deck playerDeck = new Deck(); // player hand cards
		
		Deck dealerDeck = new Deck(); // dealer hand cards 
		
		double playerChip = 100.00;
		
		while (playerChip > 0) {
			System.out.println("$" + playerChip + " available, Enter your bet : ");
			double betPlace = sc.nextDouble();
			
			if (betPlace > playerChip) {
				System.out.println("You're betting more than what you have, please withdraw");
				break;
			}
			
			playerDeck.draw(playingDeck);
			playerDeck.draw(playingDeck);
			
			dealerDeck.draw(playerDeck);
			dealerDeck.draw(playerDeck);
			
			System.out.println(dealerDeck.getCard(0).toString());
			while(true) {
				System.out.println("Your hand currently : ");
				System.out.println(playerDeck.toString());
				System.out.println("Your hand current value is : " + playerDeck.cardsValue());
				
				System.out.println("Dealer hand : " + dealerDeck.getCard(0).toString() + " and [Unknown]");
				
				System.out.println("1. Hit or 2. Stand");
				int response = sc.nextInt();
				if (response == 1) {
					playerDeck.draw(playingDeck); 
					// Last card draw in array
					System.out.print("You drew : " + playerDeck.getCard(playerDeck.deckSize()-1)); 
					
					// bust
					if (playerDeck.cardsValue() > 21) {
						System.out.println("You bust! Hand value : " + playerDeck.cardsValue());
						playerChip -= betPlace;
					}
				}
				
			}
		}
		
		System.out.println("Game over, no chips remaining");
	}

}
