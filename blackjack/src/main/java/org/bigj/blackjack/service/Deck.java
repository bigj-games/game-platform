package org.bigj.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 24.09.2016.
 */
public class Deck {

	private  int numCards = 52;
	private List<Card> deckOfCards = new ArrayList<>();

	public Deck() { }

	public void populate() {
		deckOfCards.clear();
		for (int i=0; i < 4;i++) {
			for ( int j=1; j<= 13;j++ ) {
				this.deckOfCards.add(new Card(j,CardSuit.values()[i],false));
			}
		}
	}

	public void shuffle()
	{
		List<Card> shuffledCards = new ArrayList<Card>();
		Random r = new Random();
		for (int i=0; i<numCards; i++){
			int index = r.nextInt(numCards-i);
			shuffledCards.add(this.deckOfCards.remove(index));
		}
		deckOfCards = shuffledCards;
	}

	public void giveCard (Hand hand)
	{
		Card top = this.deckOfCards.get(numCards-1);
		hand.addCard(top);
		this.deckOfCards.remove(numCards-1);
		numCards --;
	}

	public List<Card> getDeckOfCards() {
		return deckOfCards;
	}
}
