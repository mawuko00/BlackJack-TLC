package card;

import player.Player;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cardDeck;

    public Deck(Stack<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public Deck() {
    }

    public void createDeck() {

        for (SuitValue suit : SuitValue.values()) {
            for (CardValue c : CardValue.values()) {
                Card card = new Card();
                card.setSuit(suit);
                card.setValue(c);
                this.cardDeck.add(card);
            }
        }

    }
    public Stack<Card> getCardDeck() {
        return cardDeck;
    }

    public void shuffle() {
        Collections.shuffle(this.cardDeck);
    }


}
