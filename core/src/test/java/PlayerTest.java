import com.mygdx.game.Models.*;
import com.mygdx.game.Models.Direction;
import com.mygdx.game.Models.Map;
import com.mygdx.game.Models.Player;
import org.junit.jupiter.api.Test;

import java.util.TimerTask;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private final Map map = new Map();

    @Test
    void testWalkingMethods(){
        Player testPlayer = map.getPlayers().get(0);
        assertEquals(1, testPlayer.getPosition().getX());
        assertEquals(18, testPlayer.getPosition().getY());
        testPlayer.walk(Direction.LEFT);
        //assertTrue(testPlayer.isWalking());
        //testPlayer.setWalking(false);
        //assertFalse(testPlayer.isWalking());
        assertEquals(1, testPlayer.getPosition().getX());
        assertEquals(17, testPlayer.getPosition().getY());
        testPlayer.walk(Direction.RIGHT);
        assertEquals(1, testPlayer.getPosition().getX());
        assertEquals(18, testPlayer.getPosition().getY());
        testPlayer.walk(Direction.RIGHT);
        assertEquals(1, testPlayer.getPosition().getX());
        assertEquals(18, testPlayer.getPosition().getY()); // same y-coordinate because wall blocks desired new position.
    }
    @Test
    void testGetDirection(){
        Player testPlayer = map.getPlayers().get(1);
        assertEquals(Direction.UP, testPlayer.getDirection()); //default direction is UP.
        testPlayer.walk(Direction.DOWN);
        assertEquals(Direction.DOWN, testPlayer.getDirection());
    }
    @Test
    void testGetScore(){
        final Player player = map.getPlayers().get(0);
        assertEquals(0, player.getScore());
        player.walk(Direction.UP);
        player.walk(Direction.UP);
        player.walk(Direction.UP);
        player.dropBomb();
        player.walk(Direction.DOWN);
        player.walk(Direction.DOWN);
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                assertEquals(1, player.getScore()); //one softWall destroyed and therefore one point added.
            }
        }, 3000); //bomb detonates after 2 seconds, and wait extra 0.5 seconds.
        try{
            Thread.sleep(4000); //Let the main thread wait for the score check timer to run out.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}