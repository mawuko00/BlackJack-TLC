package blackjack;

import card.Deck;

public class BlackjackGame {
    private GameMaster gameMaster;
    private Deck deck;

    public BlackjackGame(GameMaster gameMaster, Deck deck) {
        this.gameMaster = gameMaster;
        this.deck = deck;
    }

    public void startNewGame(){
        gameMaster.addPlayers();
        deck.createDeck();
        deck.shuffle();
        do {
            if (gameMaster.checkNumberOfPlayers()){
                gameMaster.dealCard();
                gameMaster.determineWinner();

            }
        }

        while (!gameMaster.gameOver());

    }
}
