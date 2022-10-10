package blackjack;

import card.Card;
import card.CardValue;
import player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class GameMaster {
    private int round;
    private int numberOfPlayers;
    private Stack<Card> cardDeck;
    private Card card;

    private ArrayList<Player> players;

    public GameMaster(Stack<Card> cardDeck, Card card, int numberOfPlayers, ArrayList<Player> players) {
        this.cardDeck = cardDeck;
        this.card = card;
        this.numberOfPlayers = numberOfPlayers;
        this.round = 1;
    }

    public GameMaster(Stack<Card> cardDeck, Card card) {
        this.cardDeck = cardDeck;
        this.card = card;
        this.numberOfPlayers = 3;
        this.round = 1;
    }

    public Stack<Card> getCardDeck() {
        return cardDeck;
    }

    public void addPlayers() {
        for (int i = 0; i < numberOfPlayers; ++i) {
            Player player = new Player();
            this.players.add(player);
        }

    }



    public void createDeck() {
        String[] suits = {"HEART", "SPADES", "DIAMONDS", "CLUBS"};
        for (int i = 0; i < 4; ++i) {
            Card card = new Card();
            card.setSuit(suits[i]);
            for (CardValue c : CardValue.values()) {
                card.setValue(c);
                cardDeck.add(card);
            }
        }

    }

    public void shuffle() {
        Collections.shuffle(cardDeck);
    }

    public void dealCard() {
        for (Player p : players) {
            if (this.round == 1) {
                for (int i = 0; i < 2; ++i) {
                    p.calcTotalCardValue(cardDeck.peek());
                    p.addCard(cardDeck.pop());

                }

            } else {
                p.addCard(cardDeck.pop());
                p.calcTotalCardValue(cardDeck.peek());
            }

        }
        ++this.round;
    }

    public void checkNumberOfPlayers() {
        if (this.numberOfPlayers < 1 || this.numberOfPlayers > 6) {
            System.out.println("Invalid number of players");
        }

    }

}
