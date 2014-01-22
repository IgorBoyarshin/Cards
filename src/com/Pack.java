package com;

import java.util.Random;
import java.util.Vector;

/**
 * Created by Igor on 21.01.14.
 */
public class Pack {
    public static final int MAX_CARD_AMOUNT = Card.TYPE_AMOUNT * Card.SUIT_AMOUNT;
    private Vector<Card> pack;

    private final int trump;

    public Pack() {
        pack = new Vector<Card>();
        prepareCards();

        //listAllCards();

        trump = pack.get(0).getSuit();
    }

    public Card getNextCard() {
        Card card = null;

        if (pack.size() != 0) {
            int top = pack.size() - 1;
            card = pack.get(top);
            pack.remove(top);
        }

        return card;
    }

    public int getCardAmount() {
        return pack.size();
    }

    public int getTrump() {
        return trump;
    }

    private void prepareCards() {
        int[][][] cards = new int[Card.TYPE_AMOUNT][Card.SUIT_AMOUNT][2];

        // Initialising starting cards
        for (int type = 0; type < Card.TYPE_AMOUNT; type++) {
            for (int suit = 0; suit < Card.SUIT_AMOUNT; suit++) {
                cards[type][suit][0] = type;
                cards[type][suit][1] = suit;
            }
        }

        Random random = new Random();

        // Generating a random sequence
        for (int i = 0; i < 50; i++) {
            int cardType1 = Math.abs(random.nextInt()) % Card.TYPE_AMOUNT;
            int cardSuit1 = Math.abs(random.nextInt()) % Card.SUIT_AMOUNT;
            int cardType2 = Math.abs(random.nextInt()) % Card.TYPE_AMOUNT;
            int cardSuit2 = Math.abs(random.nextInt()) % Card.SUIT_AMOUNT;

            System.out.println(cardType1 + "  " + cardSuit1 + "::" + cardType2 + "  " + cardSuit2);

            int type = cards[cardType1][cardSuit1][0];
            int suit = cards[cardType1][cardSuit1][1];

            cards[cardType1][cardSuit1][0] = cards[cardType2][cardSuit2][0];
            cards[cardType1][cardSuit1][1] = cards[cardType2][cardSuit2][1];

            cards[cardType2][cardSuit2][0] = type;
            cards[cardType2][cardSuit2][1] = suit;
        }

        // Initialising real cards with the sequence
        for (int suit = 0; suit < Card.SUIT_AMOUNT; suit++) {
            for (int type = 0; type < Card.TYPE_AMOUNT; type++) {
                Card card = new Card(cards[type][suit][0], cards[type][suit][1]);
                pack.add(card);
            }
        }
    }

    public void listAllCards() {
        for (int i = 0; i < pack.size(); i++) {
            Card card = pack.get(i);
            System.out.println(card.getCardString());
        }
    }
}
