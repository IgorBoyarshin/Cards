package com;

import java.util.Vector;

/**
 * Created by Igor on 21.01.14.
 */
public abstract class Player {

    private final String name;
    private Vector<Card> cards;

    public abstract Vector<Card> makeMove();

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public void receiveCards(Vector<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            this.cards.add(cards.get(i));
        }
    }

    public Vector<Card> receiveMove(Vector<Card> opponentMove) {
        Vector<Card> move = new Vector<Card>();
        move.add(cards.get(0));

        return move;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfCards() {
        return cards.size();
    }

    public Player(String name) {
        this.name = name;
        cards = new Vector<Card>();
    }
}
