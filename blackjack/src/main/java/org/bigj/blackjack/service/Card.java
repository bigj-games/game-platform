package org.bigj.blackjack.service;

/**
 * Created by user on 24.09.2016.
 */
public class Card {
	private int number;
	private CardSuit suit;
	private boolean IsFaceUp;
	private String valueCardSuit;
	private String valueCard;

	public Card(int number, CardSuit suit, boolean isFaceUp) {
		this.number = number;
		this.suit = suit;
		this.IsFaceUp = isFaceUp;
	}


	public boolean isFaceUp() {
		return IsFaceUp;
	}

	public void flip() {
		this.IsFaceUp = !(IsFaceUp);
	}

	public int getValue() {
		int value = 0;
		if (!IsFaceUp) {
			value = this.number;
		}
		return value;
	}

	// TODO переделаю
	public String getValueCard() {
		if ((this.number > 1) && (this.number <= 10))
		{
			valueCard = String.valueOf(this.number);
		} else {
			switch (this.number) {
				case 1:
					valueCard ="A";
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
		}
		return valueCard;
	}

	@Override
	public String toString() {
		return "card{" +
			getValueCard() +
			", " +
			suit.getStringValue() + '}';
	}
}
