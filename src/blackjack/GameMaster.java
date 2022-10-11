package blackjack;

import card.Card;
import card.Deck;
import player.Player;


import java.util.ArrayList;

public class GameMaster {
    private int round;
    private int numberOfPlayers;
    private Player winner;

    private Player player;

    private ArrayList<Player> players;

    private Deck deck;


    public GameMaster(int numberOfPlayers, Deck deck, ArrayList<Player> players) {
        this.numberOfPlayers = numberOfPlayers;
        this.deck = deck;
        this.round = 1;
        this.players = players;

    }

    public GameMaster(ArrayList<Player> players, Deck deck) {
        this.numberOfPlayers = 3;
        this.round = 1;
        this.players = players;
        this.deck = deck;
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }


    public void addPlayers() {
        for (int i = 0; i < numberOfPlayers; ++i) {
            Player player = new Player(i + 1);
            this.players.add(player);
        }

    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void dealCard() {
        System.out.println("ROUND " + this.round);

        for (Player p : players) {
            if (this.round == 1) {
                p.addCard(this.deck.getCardDeck().pop());
                p.addCard(this.deck.getCardDeck().pop());
                System.out.println("Player " + p.getID()+ " " + p.getTotalValueOfCards());
            } else {
                p.addCard(this.deck.getCardDeck().pop());
                System.out.println("Player " + p.getID()+ " " + p.getTotalValueOfCards());
            }
        }
        ++this.round;

    }


    public boolean checkNumberOfPlayers() {
        if (this.numberOfPlayers < 1 || this.numberOfPlayers > 6) {
            System.out.println("Invalid number of players");
            return false;
        } else {
            return true;
        }

    }

    public Player highestValuePlayer() {
        Player highestValuePlayer = new Player();
        for (Player p : players) {
            if (p.getTotalValueOfCards() > highestValuePlayer.getTotalValueOfCards()) {
                highestValuePlayer = p;
            }
        }
        return highestValuePlayer;
    }

    public void determineWinner() {
        int count = 0;
        for (Player player : players) {
            if (player.getTotalValueOfCards() == 21) {
                this.winner = player;
            } else if (player.getPlayerState() == "Stick") {
                ++count;
                if (count == this.numberOfPlayers) {
                    this.winner = highestValuePlayer();
                }
            } else if (player.getPlayerState() == "Bust") {
                this.players.remove(player);
                if (players.size() == 1) {
                    this.winner = players.get(0);

                }

            }

        }


    }

    public Player getWinner() {
        return winner;
    }

    public boolean gameOver() {
        if (this.winner != null) {
            System.out.println("The Winner is Player " + this.winner.getID());
            return true;
        }
        return false;
    }


}
