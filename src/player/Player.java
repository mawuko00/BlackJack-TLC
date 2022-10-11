package player;

import card.Card;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards ;
    private String playerState;
    private int totalValueOfCards;

    private int ID;


    public Player(int id) {
        this.ID = id;
        this.playerState = "Hit";
        this.cards = cards;
    }



    public Player(ArrayList<Card> cards){
        this.cards = cards;
    }


    public Player() {
    }



    public ArrayList<Card> getCards() {
        return cards;
    }



    public String getPlayerState() {
        return playerState;
    }


    public void setPlayerState(String playerState) {
        this.playerState = playerState;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void calcCardValue(Card card) {
        this.totalValueOfCards += card.getValue().getValue();
    }

    public void setPlayerState(int totalValueOfCards) {
        if (totalValueOfCards < 17) {
            this.setPlayerState("Hit");
        } else if (totalValueOfCards >= 21) {
            this.setPlayerState("Bust");
        } else {
            setPlayerState("Stick");
        }

    }

    public Player notBustState(ArrayList<Player> players) {
        Player player = new Player();
        for (Player p : players) {
            if (!p.getPlayerState().equals("Bust")) {
                player = p;

            }
        }

        return player;
    }

    public void setTotalValueOfCards(int totalValueOfCards) {
        this.totalValueOfCards = totalValueOfCards;
    }

    public int getTotalValueOfCards() {
        return totalValueOfCards;
    }

    public int getID() {
        return ID;
    }
}
