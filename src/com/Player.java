package com;

import java.util.Vector;

/**
 * Created by Igor on 21.01.14.
 */
public abstract class Player {

    private final String name;
    private Vector<Card> cards;

    public abstract Vector<Card> makeMove();

    public Vector<Card> receiveMove(Vector<Card> opponentMove) {

    }

    public String getName() {
        return name;
    }

    public int getAmountOfCards() {
        return cards.size();
    }

    public Player(String name) {
        this.name = name;
    }
}
