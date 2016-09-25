package org.bigj.blackjack.service;


public class Dealer  {

	private Hand hand = new Hand();

	public Dealer() {
	}

	public boolean IsHitting() {
		return hand.getHandSum() > 16;
	}

	public void flipFirstCard() {
		if ( !hand.getCards().isEmpty()) {
			hand.getCards().get(0).flip();
		}
	}
	public Hand getHand() {
		return hand;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < this.hand.getCards().size(); i++) {
			if (i ==0 && this.hand.getCards().get(i).isFaceUp()) {
				result += "[hidden], ";
				continue;
			}
			String s = this.hand.getCards().get(i).toString();
			result += s;
			if (i != this.hand.getCards().size() - 1) {
				result += ",";
			}
		}
		return result;
	}
}

