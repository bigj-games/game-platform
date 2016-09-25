package org.bigj.blackjack.service;

/**
 * Created by user on 24.09.2016.
 */
public class GameState {

	private Deck deck;
	private Player player;
	private Dealer dealer;
	public GameState() { }


	public String start() {
		deck = new Deck();
		player = new Player();
		dealer = new Dealer();
		deck.populate();
		deck.shuffle();
		for (int i = 0; i < 2; i++) {
			giveCardToPlayers();
		}
		dealer.flipFirstCard();
		String result = "New game is started!" + " Commands" + " '" +
			"hitme" + "' " + "and" + " '" + "stop" + "' " + "are available!\n"+
			"Player hand: " + player.toString() + " | " + "Score: "+ player.getHand().getHandSum() + "\n" +
			"Dealer hand: " + dealer.toString();
		return result;
	}

	private void giveCardToPlayers ()
	{
		if (!deck.getDeckOfCards().isEmpty()) {
			deck.giveCard(player.getHand());
			deck.giveCard(dealer.getHand());
			// TODO переделаю
			//	player.addHand(deck.getCard());
		}
	}

	public void hitMe()
	{


	}

	private void giveAdditionalCard()
	{


	}

	public void stop()
	{

	}

}
