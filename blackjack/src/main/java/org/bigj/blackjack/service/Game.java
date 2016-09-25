package org.bigj.blackjack.service;

/**
 * Created by user on 20.09.2016.
 */
public class Game  {

	private GameState gameState;

	public Game() {
		gameState = new GameState();
	}

	public String start() {
		gameState.start();
        return gameState.start();
	}


}
