package com;

/**
 * Created by Igor on 21.01.14.
 */
public class Main {
    public static void main(String[] args) {

        Game game = new Game(new AI("John"), new AI("Bob"));
        game.play();

        // 2 hours

    }
}
