package org.bigj.blackjack.service;

/**
 * Created by user on 24.09.2016.
 */
public class Card {
	private int number;
	private CardSuit suit;
	private boolean IsFaceUp;
	private String  valueCardSuit;
	private String valueCard;

	public Card(int number,CardSuit suit, boolean isFaceUp) {
		this.number = number;
		this.suit = suit;
		this.IsFaceUp = isFaceUp;
	}


	public boolean isFaceUp() {
		return IsFaceUp;
	}

	public void flip()
	{
		this.IsFaceUp = !(IsFaceUp);
	}

	public int getValue()
	{
		int value = 0;
		if (!IsFaceUp) {
			value = this.number;
		}
		return value;
	}

	// TODO переделаю
	public String getValueCard()
	{
		switch (this.number)
		{
			case 1:
				valueCard = "A";
				break;
			case 2:
				valueCard = "2";
				break;
			case 3:
				valueCard = "3";
				break;
			case 4:
				valueCard = "4";
				break;
			case 5:
				valueCard = "5";
				break;
			case 6:
				valueCard = "6";
				break;
			case 7:
				valueCard = "7";
				break;
			case 8:
				valueCard = "8";
				break;
			case 9:
				valueCard = "9";
				break;
			case 10:
				valueCard = "10";
				break;
			case 11:
				valueCard = "J";
				break;
			case 12:
				valueCard = "K";
				break;
			case 13:
				valueCard = "Q";
				break;
		}
		return valueCard;
	}

	public String getCardSuit()
	{
		switch (this.suit)
		{
			case SPADES:
				valueCardSuit = "♠";
				break;
			case CLUBS:
				valueCardSuit ="♦";
				break;
			case HEARTS:
				valueCardSuit ="♥";
				break;
			case DIAMONDS:
				valueCardSuit ="♦";
				break;
		}
		return valueCardSuit;
	}
	@Override
	public String toString() {
		return "card{" +
			getValueCard() +
			", " +
			getCardSuit() + '}';
	}
}
