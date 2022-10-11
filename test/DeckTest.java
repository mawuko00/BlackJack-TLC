import card.Card;
import card.CardValue;
import card.Deck;
import card.SuitValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

public class DeckTest {
    @Test
    public void createCardDeckTest() {
        Stack<Card> card = new Stack<>();
        Deck deck = new Deck(card);
        deck.createDeck();
        int count = 0;
        for (var suit : SuitValue.values()) {
            for (var deckCard : deck.getCardDeck()) {
                if (deckCard.getSuit() == suit) {
                    ++count;
                }
            }
            Assertions.assertEquals(13, count, "" + suit);
            count = 0;
        }


    }

    @Test
    public void deckShuffleTest(){
        Stack<Card> card = new Stack<>();
        Deck deck1 = new Deck(card);
        deck1.createDeck();

        Stack<Card> card2 = new Stack<>();
        Deck deck2 = new Deck(card);
        deck2.createDeck();

        deck2.shuffle();

        Assertions.assertNotEquals(deck1,deck2);
    }
}
