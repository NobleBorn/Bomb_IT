import com.mygdx.game.Models.*;
import com.mygdx.game.Models.Direction;
import com.mygdx.game.Models.Map;
import com.mygdx.game.Models.Player;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TimerTask;

import static org.junit.jupiter.api.Assertions.*;

public class BombTest{
    private final Map map = new Map();
    private final List<Player> playerList = map.getPlayers();

    @Test
    void bombTest(){
        final Player playerOne = playerList.get(0);
        final int softWallCount = map.getSoftWalls().size();
        assertEquals(1, playerOne.getPosition().getX()); //check that we are looking at the right player.
        assertEquals(18, playerOne.getPosition().getY());
        playerOne.walk(Direction.LEFT);
        playerOne.walk(Direction.UP);
        playerOne.walk(Direction.UP);
        assertTrue(playerOne.isAlive());
        playerOne.dropBomb();
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                assertFalse(playerOne.isAlive()); //check that player is dead since it is on the same square.
                assertEquals(softWallCount-1, map.getSoftWalls().size()); //check that softWall in position (3, 16) is destroyed and removed from the list of softWalls.
            }
        }, 2500); //bomb detonates after 2 seconds.
        try{
            Thread.sleep(3000); //Let the main thread wait for the alive check timer to run out.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
