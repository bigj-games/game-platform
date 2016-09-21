package org.bigj.blackjack.service;

import java.util.*;

/**
 * Created by arthan on 21.09.2016. | Project game-platform
 */
public class AGame {

    private Queue<String> desk = new LinkedList<>();
    private List<String> playerHand = new ArrayList<>();
    private List<String> houseHand = new ArrayList<>();

    public String start() {

        fillDesk();

        playerHand.add(dealCard());
        playerHand.add(dealCard());
        houseHand.add(dealCard());
        houseHand.add(dealCard());

        String result = "Game has started!\n" +
                "Player hand: " + join(playerHand) + " | " + countScore(playerHand) + "\n" +
                "House hand: " + join(houseHand.subList(0, houseHand.size() - 1));
        return result;
    }

    private int countScore(List<String> hand) {
        int sum = 0;
        for (String card : hand) {
            char c = card.charAt(0);
            if (c == 'J' || c == 'Q' || c == 'K') {
                sum += 10;
            } else if (c == 'A') {
                sum += 11;
            } else {
                sum += Integer.parseInt(card.substring(0, 1));
            }
        }
        return sum;
    }

    private String join(List<String> list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            result += s;
            if (i != list.size() - 1) {
                result += ",";
            }
        }
        return result;
    }

    private void fillDesk() {
        List<String> cards = new ArrayList<>();
        String[] suits = new String[]{"♠", "♥", "♦", "♣"};
        String[] pips = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String pip : pips) {
            for (String suit : suits) {
                cards.add(pip + suit);
            }
        }
        Collections.shuffle(cards);
        desk.addAll(cards);
    }

    private String dealCard() {
        return desk.poll();
    }
}
