package card;

import java.util.Stack;

public class Card {
    private String suit;
    private CardValue value;

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }
}
