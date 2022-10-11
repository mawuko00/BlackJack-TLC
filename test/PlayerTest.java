import card.Card;
import card.CardValue;
import card.SuitValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.Player;

import java.util.ArrayList;

public class PlayerTest {
    private Player player;
    private Card card;

    @BeforeEach
    public void initPlayerCardObjects(){

    }
    @Test
    public void addCardTest(){
        Player player = new Player();
        Card card = new Card(SuitValue.HEART, CardValue.ACE);
        player.addCard(card);

        Assertions.assertEquals(1,player.getCards().size() );
    }

    @Test
    public void calcCardValueTest(){
        Player player = new Player();
        Card card = new Card(SuitValue.HEART, CardValue.ACE);
        player.calcCardValue(card);

        Assertions.assertEquals(11,player.getTotalValueOfCards());

    }

    @Test
    public void setPlayerStateTest(){
        Player player = new Player();

        player.setPlayerState(12);
        Assertions.assertEquals("Hit",player.getPlayerState());

        player.setPlayerState(19);
        Assertions.assertEquals("Stick",player.getPlayerState());

        player.setPlayerState(22);
        Assertions.assertEquals("Bust",player.getPlayerState());
    }

    @Test
    public void notBustStateTest(){
        Player player1 = new Player();
        player1.setPlayerState(22);
        Player player2 = new Player();
        player2.setPlayerState(23);
        Player player3 = new Player();
        player3.setPlayerState(20);
        ArrayList<Player> players = new ArrayList<>(){
            {
                add(player1);
                add(player2);
                add(player3);
            }
        };

        Assertions.assertNotEquals("Bust",player1.notBustState(players).getPlayerState());
    }
}
