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
			
			boolean endGame = false;
			
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
					// Last card draw in array from player side
					System.out.print("You drew : " + playerDeck.getCard(playerDeck.deckSize()-1)); 
					
					// bust
					if (playerDeck.cardsValue() > 21) {
						System.out.println("You bust! Hand value : " + playerDeck.cardsValue());
						playerChip -= betPlace;
						endGame = true;
						break;
					}
				}
				else if (response == 2) {
					break; // stand 
				}
			}
			System.out.println("Dealer hand : " + dealerDeck.toString());
			
			if (dealerDeck.cardsValue() > playerDeck.cardsValue() && endGame == false) {
				System.out.println("Dealer wins");
				playerChip -= betPlace;
				endGame = true;
			}
			
			// dealer draws
			while(dealerDeck.cardsValue() < 17 && endGame == false) {
				dealerDeck.draw(playingDeck);
				System.out.println("Dealer drew : " + dealerDeck.getCard(dealerDeck.deckSize()-1));
			}
			System.out.println("Dealer hand value : " + dealerDeck.cardsValue());
			
			//check if dealer busted
			if (dealerDeck.cardsValue() > 21 && endGame == false) {
				System.out.println("Dealer bust, you win");
				playerChip += betPlace;
				endGame = true;
			}
			
			if (playerDeck.cardsValue() == dealerDeck.cardsValue() && endGame == false) {
				System.out.println("Tied");
				endGame = true;
			}
		}
		
		System.out.println("Game over, no chips remaining");
	}

}
