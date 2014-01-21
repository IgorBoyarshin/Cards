package com;

/**
 * Created by Igor on 21.01.14.
 */
public class Card {
    public static final int SUIT_AMOUNT = 4;
    public static final String SUIT_CROSS = "+";
    public static final String SUIT_SPADES = "^";
    public static final String SUIT_DIAMONDS = "#";
    public static final String SUIT_HEARTS = "%";

    public static final int SUIT_CROSS_NUM = 0;
    public static final int SUIT_SPADES_NUM = 1;
    public static final int SUIT_DIAMONDS_NUM = 2;
    public static final int SUIT_HEARTS_NUM = 3;

    public static final int TYPE_AMOUNT = 9;
    public static final String TYPE_6 = "6";
    public static final String TYPE_7 = "7";
    public static final String TYPE_8 = "8";
    public static final String TYPE_9 = "9";
    public static final String TYPE_10 = "10";
    public static final String TYPE_V = "V";
    public static final String TYPE_D = "D";
    public static final String TYPE_K = "K";
    public static final String TYPE_T = "T";

    public static final int TYPE_6_NUM = 6;
    public static final int TYPE_7_NUM = 7;
    public static final int TYPE_8_NUM = 8;
    public static final int TYPE_9_NUM = 9;
    public static final int TYPE_10_NUM = 10;
    public static final int TYPE_V_NUM = 11;
    public static final int TYPE_D_NUM = 12;
    public static final int TYPE_K_NUM = 13;
    public static final int TYPE_T_NUM = 14;

    private final int suit;
    private final int type;

    public Card(int type, int suit) {
        this.type = type;
        this.suit = suit;
    }

    public String getCardString() {
        String card = getTypeChar() + getSuitChar();
        return card;
    }

    private String getTypeChar() {
        String typeC;

        switch (type) {
            case TYPE_6_NUM:
                typeC = TYPE_6;
                break;
            case TYPE_7_NUM:
                typeC = TYPE_7;
                break;
            case TYPE_8_NUM:
                typeC = TYPE_8;
                break;
            case TYPE_9_NUM:
                typeC = TYPE_9;
                break;
            case TYPE_10_NUM:
                typeC = TYPE_10;
                break;
            case TYPE_V_NUM:
                typeC = TYPE_V;
                break;
            case TYPE_D_NUM:
                typeC = TYPE_D;
                break;
            case TYPE_K_NUM:
                typeC = TYPE_K;
                break;
            case TYPE_T_NUM:
                typeC = TYPE_T;
                break;
            default:
                typeC = "n/a";
        }

        return typeC;
    }

    private String getSuitChar() {
        String suitC;

        switch (suit) {
            case SUIT_HEARTS_NUM:
                suitC = SUIT_HEARTS;
                break;
            case SUIT_CROSS_NUM:
                suitC = SUIT_CROSS;
            break;
            case SUIT_SPADES_NUM:
                suitC = SUIT_SPADES;
            break;
            case SUIT_DIAMONDS_NUM:
                suitC = SUIT_DIAMONDS;
            break;
            default:
                suitC = "n/a";
        }

        return suitC;
    }

    public int getSuit() {
        return suit;
    }

    public int getType() {
        return type;
    }
}
