package com.players;

import com.Card;

import java.util.Vector;

/**
 * Created by Igor on 21.01.14.
 */
public class AI extends Player {

    @Override
    public Vector<Card> makeMove(Vector<Card> opponentMove) {

        Vector<Card> move = new Vector<Card>();
        Vector<Card> take = new Vector<Card>();

        if (opponentMove == null) {
            move.add(findTheMostUselessCard());
        } else {
            for (int i = 0; i < opponentMove.size(); i++) {
                Card card = findCardThatBeatsIt(opponentMove.get(i));

                if (card == null) {
                    take.add(opponentMove.get(i));
                }

                move.add(card);
            }

            if (take.size() != 0) {
                receiveCards(take);
                System.out.println(getName() + " took " + take.size() + " cards;");
            }
        }

        return move;
    }

    private Card findTheMostUselessCard() {
        Card card = cards.get(0);
        int num = 0;

        for (int i = 1; i < getAmountOfCards(); i++) {
            if (cards.get(i).getType() < card.getType()) {
                card = cards.get(i);
                num = i;
            }
        }

        cards.remove(num);

        return card;
    }

    // TODO: change this func
    private Card findCardThatBeatsIt(Card card) {
        Card move = null;

        for (int i = 0; i < cards.size(); i++) {
            if (((cards.get(i).getType() > card.getType()) && (cards.get(i).getSuit() == card.getSuit()))
                    || ((cards.get(i).getSuit() == trump) && (card.getSuit() != trump))) {
                move = cards.get(i);
            }
        }

        return move;
    }

    public AI(String name, int trump) {
        super(name, trump);
    }
}
