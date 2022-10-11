import blackjack.GameMaster;
import card.Card;
import card.CardValue;
import card.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.Player;

import java.util.ArrayList;
import java.util.Stack;

public class GameMasterTest {
    @Test
    public void addPlayersTest() {
        ArrayList<Player> players = new ArrayList<>();
        Deck deck = new Deck();
        GameMaster gameMaster = new GameMaster(players, deck);
        gameMaster.addPlayers();
        Assertions.assertEquals(3, gameMaster.getPlayers().size());
    }

    @Test
    public void numberOfCardsInHandTest() {
        ArrayList<Player> players = new ArrayList<>();
        Stack<Card>cards = new Stack<>();
        Deck deck = new Deck(cards);
        deck.createDeck();
        GameMaster gameMaster = new GameMaster(players, deck);
        gameMaster.dealCard();


        for (Player player : players) {
            Assertions.assertEquals(2,player.getCards().size() );

        }
        gameMaster.dealCard();
        for (Player player : players) {
            Assertions.assertEquals(3,player.getCards().size() );

        }

    }

    @Test
    public void numberOfPlayerTest(){
        ArrayList<Player> players = new ArrayList<>();
        Deck deck = new Deck();
        GameMaster gameMaster = new GameMaster(4,deck,players);

        Assertions.assertEquals(true,gameMaster.checkNumberOfPlayers());

        GameMaster gameMaster1 = new GameMaster(7,deck,players);

        Assertions.assertEquals(false,gameMaster1.checkNumberOfPlayers());
    }

    @Test
    public void playerWithHighCardValueTest(){
        ArrayList<Card>cards = new ArrayList<>();
        Player player1 = new Player(cards);
        player1.setTotalValueOfCards(22);
        Player player2 = new Player(cards);
        player2.setTotalValueOfCards(23);
        Player player3 = new Player(cards);
        player3.setTotalValueOfCards(20);
        ArrayList<Player> players = new ArrayList<>(){
            {
                add(player1);
                add(player2);
                add(player3);
            }
        };
        GameMaster gameMaster= new GameMaster(players,new Deck());


        Player highestValuePlayer = new Player(cards);
        Assertions.assertEquals(23,gameMaster.highestValuePlayer().getTotalValueOfCards());


    }

//    @Test
//    void createDeckTest(){
//        Card card = new Card();
//        Stack<Card>cardDeck = new Stack<>();
//        GameMaster dealer = new GameMaster(cardDeck,card);
//        dealer.createDeck();
//
//        String[] suits = {"HEART", "SPADES", "DIAMONDS", "CLUBS"};
//        for (String s: suits){
//            int count = 0;
//            for (Card c: cardDeck){
//                if (c.getSuit() == s){
//                    ++count;
//                }
//
//            }
//            Assertions.assertEquals(13,count);
//
//        }
//
//
//    }
//
//    @Test
//    void deckShuffleTest(){
//        Card card1 = new Card();
//        Stack<Card>cardDeck1 = new Stack<>();
//        GameMaster dealer1 = new GameMaster(cardDeck1,card1);
//        dealer1.createDeck();
//
//        Card card2 = new Card();
//        Stack<Card>cardDeck2 = new Stack<>();
//        GameMaster dealer2 = new GameMaster(cardDeck2,card2);
//        dealer2.createDeck();
//        dealer2.shuffle();
//
//        Assertions.assertNotEquals(dealer1.getCardDeck(),dealer2.getCardDeck());
//
//    }
}
