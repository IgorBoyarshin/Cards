package com.players;

import com.Card;

import java.util.Vector;

/**
 * Created by Igor on 21.01.14.
 */
public class Human extends Player{
    @Override
    public Vector<Card> makeMove(Vector<Card> opponentMove) {
        return null;
    }

    public Human(String name, int trump) {
        super(name, trump);
    }
}
