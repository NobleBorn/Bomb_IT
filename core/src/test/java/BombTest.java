import Models.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Timer;

import static org.junit.jupiter.api.Assertions.*;

public class BombTest implements Runnable{
    private final Map map = new Map();
    private final List<Player> playerList = map.getPlayers();

    @Test
    void bombTest(){
        assertFalse(map.getMapMatrix()[3][16].isTileEmpty()); //check that there is a SoftWall at 3, 16.
        Player playerOne = playerList.get(0);
        assertEquals(1, playerOne.getPosition().getX()); //check that we are looking at the right player.
        assertEquals(18, playerOne.getPosition().getY());
        playerOne.walk(Direction.LEFT);
        playerOne.walk(Direction.UP);
        playerOne.walk(Direction.UP);
        playerOne.dropBomb();
        run();  // we have to wait with checking if the bomb exploded correctly because of the bomb's timer.
        assertTrue(map.getMapMatrix()[3][16].isTileEmpty()); //check that the wall has exploded away.
        assertFalse(playerOne.isAlive()); //check that the player has died to their own song.

    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
