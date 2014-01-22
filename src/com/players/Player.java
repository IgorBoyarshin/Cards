package com.players;

import com.Card;
import com.Game;

import java.util.Vector;

/**
 * Created by Igor on 21.01.14.
 */
public abstract class Player {

    private final String name;
    protected Vector<Card> cards;
    protected final int trump;

    public abstract Vector<Card> makeMove(Vector<Card> opponentMove);

    public void listCards() {
        for (int i=0; i<cards.size(); i++) {
            System.out.print(cards.get(i).getCardString() + " ");
        }
        System.out.println();
    }

    public void receiveCard(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    public void receiveCards(Vector<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            this.cards.add(cards.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public int getAmountOfCards() {
        return cards.size();
    }

    public Player(String name, int trump) {
        this.name = name;
        this.trump = trump;
        cards = new Vector<Card>();
    }
}
