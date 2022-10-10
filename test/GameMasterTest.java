import blackjack.GameMaster;
import card.Card;
import card.CardValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class GameMasterTest {

    @Test
    void createDeckTest(){
        Card card = new Card();
        Stack<Card>cardDeck = new Stack<>();
        GameMaster dealer = new GameMaster(cardDeck,card);
        dealer.createDeck();

        String[] suits = {"HEART", "SPADES", "DIAMONDS", "CLUBS"};
        for (String s: suits){
            int count = 0;
            for (Card c: cardDeck){
                if (c.getSuit() == s){
                    ++count;
                }

            }
            Assertions.assertEquals(13,count);

        }


    }

    @Test
    void deckShuffleTest(){
        Card card1 = new Card();
        Stack<Card>cardDeck1 = new Stack<>();
        GameMaster dealer1 = new GameMaster(cardDeck1,card1);
        dealer1.createDeck();

        Card card2 = new Card();
        Stack<Card>cardDeck2 = new Stack<>();
        GameMaster dealer2 = new GameMaster(cardDeck2,card2);
        dealer2.createDeck();
        dealer2.shuffle();

        Assertions.assertNotEquals(dealer1.getCardDeck(),dealer2.getCardDeck());

    }
}
