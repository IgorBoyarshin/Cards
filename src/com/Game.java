package com;

import java.util.Vector;

/**
 * Created by Igor on 21.01.14.
 */
public class Game {
    public static final int PLAYER_AI = 0;
    public static final int PLAYER_HUMAN = 1;

    private Pack pack;

    private Player first;
    private Player second;
    private Player currentPlayer;
    private Player opponentPlayer;

    public void play() {
        int counter = 0;



        while (!isGameEnded()) {
            counter++;

            Vector<Card> currentPlayerMove = currentPlayer.makeMove();
            System.out.print(counter + "| ");
            printMove(currentPlayerMove);

            Vector<Card> opponentPlayerMove = opponentPlayer.receiveMove(currentPlayerMove);
            System.out.print(counter + "| ");
            printMove(opponentPlayerMove);

            Player temp = currentPlayer;
            currentPlayer = opponentPlayer;
            opponentPlayer = currentPlayer;
        }
    }

    private void printMove(Vector<Card> move) {
        System.out.print(currentPlayer.getName() + ": ");

        for (int i = 0; i < move.size(); i++) {
            System.out.print(move.get(i).getCardString() + " ");
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

    public Game(Player first, Player second) {

        this.first = first;
        this.second = second;

        currentPlayer = first;
        opponentPlayer = second;

//        switch (firstType) {
//            case 0:
//                first = new AI(firstName);
//                break;
//            case 1:
//                first = new Human(firstName);
//                break;
//        }
//
//        switch (secondType) {
//            case 0:
//                second = new AI(secondName);
//                break;
//            case 1:
//                second = new Human(secondName);
//                break;
//        }

        pack = new Pack();
    }
}
