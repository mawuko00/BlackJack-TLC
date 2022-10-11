package card;

import java.util.Stack;

public class Card {
    private SuitValue suit;
    private CardValue value;

    public Card() {
    }

    public Card(SuitValue suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public void setSuit(SuitValue suit) {
        this.suit = suit;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public SuitValue getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }
}
