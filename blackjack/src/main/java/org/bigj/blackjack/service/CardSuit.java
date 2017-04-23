package org.bigj.blackjack.service;


public enum CardSuit {
	SPADES("♠"),
	CLUBS("♣"),
	HEARTS("♥"),
	DIAMONDS("♦");

	private String stringValue;

	CardSuit(String stringValue) {
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}


}
