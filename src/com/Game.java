package com;

import com.players.AI;
import com.players.Human;
import com.players.Player;

import java.util.Vector;

/**
 * Created by Igor on 21.01.14.
 */
public class Game {
    public static final int PLAYER_AI = 0;
    public static final int PLAYER_HUMAN = 1;
    public static final int PLAYER_TYPE_AMOUNT = 2;

    public static final int CARDS_FOR_EACH = 7;

    private Pack pack;

    private Player first;
    private Player second;
    private Player currentPlayer;
    private Player opponentPlayer;

    private void play() {
        int counter = 0;

        System.out.println("Before passing: " + pack.getCardAmount());

        passCards();

        System.out.println("After passing: " + pack.getCardAmount());

        while (!isGameEnded()) {
            counter++;

            Vector<Card> currentPlayerMove = currentPlayer.makeMove(null);
            System.out.print(counter + "| ");
            printMove(currentPlayerMove);

            Vector<Card> opponentPlayerMove = opponentPlayer.makeMove(currentPlayerMove);
            System.out.print(counter + "| ");
            printMove(opponentPlayerMove);

            passCards();

            Player temp = currentPlayer;
            currentPlayer = opponentPlayer;
            opponentPlayer = temp;
        }
    }

    private void passCards() {
        while (currentPlayer.getAmountOfCards() < opponentPlayer.getAmountOfCards()) {
            currentPlayer.receiveCard(pack.getNextCard());
        }

        while ((pack.getCardAmount() > 0) && (currentPlayer.getAmountOfCards() < CARDS_FOR_EACH)) {
            currentPlayer.receiveCard(pack.getNextCard());
            opponentPlayer.receiveCard(pack.getNextCard());
        }
    }

    private void printMove(Vector<Card> move) {
        System.out.print(currentPlayer.getName() + ": ");

        if (move.size() == 0) {
            System.out.println("Takes");
        } else {
            for (int i = 0; i < move.size(); i++) {
                if (move.get(i) == null) {
                    System.out.print("--" + " ");
                } else {
                    System.out.print(move.get(i).getCardString() + " ");
                }
            }
        }

        System.out.println(";");
    }

    private boolean isGameEnded() {
        boolean packEnded = (pack.getCardAmount() == 0);
        if (((first.getAmountOfCards() == 0) && packEnded) || ((second.getAmountOfCards() == 0) && (packEnded))) {
            return true;
        } else {
            return false;
        }

    }

    public int getTrump() {
        return pack.getTrump();
    }

    public Game(final int typeFirst, String firstName, final int typeSecond, String secondName) {

        // TODO: Use enum!!!!
        if ((typeFirst >= PLAYER_TYPE_AMOUNT) || (typeSecond >= PLAYER_TYPE_AMOUNT)) {
            // return
        } else {
            pack = new Pack();

            switch (typeFirst) {
                case 0:
                    first = new AI(firstName, pack.getTrump());
                    break;
                case 1:
                    first = new Human(firstName, pack.getTrump());
                    break;
            }

            switch (typeSecond) {
                case 0:
                    second = new AI(secondName, pack.getTrump());
                    break;
                case 1:
                    second = new Human(secondName, pack.getTrump());
                    break;
            }

            play();
        }
    }
}
