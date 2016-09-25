package org.bigj.blackjack.service;


import java.util.ArrayList;
import java.util.List;

public class Hand {



	private List<Card> cards;

	/*
	* В руке создаются карты
	*/
	public Hand()
	{
		cards = new ArrayList<>();
	}
	/*
	* добавляет карту в руки
	*/
	public void addCard(Card card)
	{
		cards.add(card);
	}

	/*
	* очищает руку от карт
	*/
	public void clear()
	{
		cards.clear();
	}

	/*
	* получает сумму очков в руке
	*/
	public int getHandSum()
	{
		if(cards.isEmpty()) {
			return 0;
		}
		// если первая карта имеет значение 0 , то она лежит стороной вверх
		if (cards.get(0).getValue() == 0) {
			return  0;
		}
		int cardNum;
		int handSum=0;
		int handAces = 0;
		for (int i=0; i < cards.size();i++)
		{
			// получить значение карты
			cardNum = cards.get(i).getValue();
			if (cardNum == 1)
			{
				handAces = handAces+1 ;  // количество тузов
				handSum = handSum + 11;
			}
			else if (cardNum  > 10) {  handSum = handSum + 10; }
			else {handSum  = handSum + cardNum; }
		}

		while (handSum > 21 && handAces > 0 )
		{
			handSum = handSum - 10;
			handAces =  handAces - 1;
		}
		return handSum;
	}

	public List<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		return cards.toString();
	}

}
