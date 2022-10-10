package player;

import card.Card;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards = new ArrayList<>();
    private String playerState;
    private int totalValueOfCards;


    public Player() {
        this.playerState = "Hit";
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

    public void calcTotalCardValue(Card card){
        this.totalValueOfCards += card.getValue().getValue();
    }

    public void setPlayerState() {

    }
}
