package org.bigj.blackjack.service;

/**
 * Created by user on 22.09.2016.
 */
public class Player  {

	private Hand hand = new Hand();

	public Player() {}

	public boolean isBust(){
		return (this.hand.getHandSum() > 21);
	}

	public Hand getHand() {
		return this.hand;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < this.hand.getCards().size(); i++) {
			String s = this.hand.getCards().get(i).toString();
			result += s;
			if (i != this.hand.getCards().size() - 1) {
				result += ",";
			}
		}
		return result;
	}
}
