package main;

import blackjack.BlackjackGame;
import blackjack.GameMaster;
import card.Card;
import card.CardValue;
import card.Deck;
import player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Stack<Card>cardDeck = new Stack<>();
        Deck deck = new Deck(cardDeck);
//        Player player = new Player();
        deck.createDeck();
        deck.shuffle();



        GameMaster gameMaster = new GameMaster(players, deck);
        BlackjackGame blackjackGame = new BlackjackGame(gameMaster,deck);
        blackjackGame.startNewGame();


    }

}
