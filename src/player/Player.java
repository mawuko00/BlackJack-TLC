package player;

import card.Card;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards = new ArrayList<>();
    private String playerState;

    public Player() {
        this.playerState = "Hit";
    }

    public String getPlayerState() {
        return playerState;
    }

    public void setPlayerState(String playerState) {
        this.playerState = playerState;
    }
}
