import Models.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import static org.junit.jupiter.api.Assertions.*;


public class MapTest {
    private final Map map = new Map();

    @Test
    void test_notNull() {
        for (Bomb bomb: map.getBombs()) {
            assertNotNull(bomb);
        }
        for (SoftWall softWall: map.getSoftWalls()) {
            assertNotNull(softWall);
        }
        for (Wall perWall: map.getPermWalls()) {
            assertNotNull(perWall);
        }
        for (Player player: map.getPlayers()) {
            assertNotNull(player);
        }
    }

    @Test
    void test_getPlayers() { //test for one of the getters since all work the same way.
        final List<Player> testPlayers = map.getPlayers();
        assertEquals(testPlayers.get(0).getPosition().getX(), 1);
        assertEquals(testPlayers.get(0).getPosition().getY(), 18);
    }

    @Test
    void test_playersPositions(){
        final List<Player> testPlayers = map.getPlayers();
        List<Player> expected = new ArrayList<>(2);
        Position pos = new Position(18, 1);
        expected.add(new Player(new Position(1, 18), map, testPlayers));
        expected.add(new Player(new Position(pos), map, testPlayers));
        for (int i=0; i<testPlayers.size(); i++){
            assertEquals(testPlayers.get(i).getPosition().getX(), expected.get(i).getPosition().getX());
            assertEquals(testPlayers.get(i).getPosition().getY(), expected.get(i).getPosition().getY());
        }
    }

    @Test
    void test_tryMove(){
        final List<Player> testPlayers = map.getPlayers();
        testPlayers.get(1).walk(Direction.RIGHT);  //This is going to go to map's tryMove(position, player). Player 2 is the player at the top left.
        assertEquals(testPlayers.get(1).getPosition().getX(), 18);
        assertEquals(testPlayers.get(1).getPosition().getY(), 2);
        testPlayers.get(0).walk(Direction.LEFT);  //This is going to go to map's tryMove(position, player). Player 1 is on the bottom right.
        assertEquals(testPlayers.get(0).getPosition().getX(), 1);
        assertEquals(testPlayers.get(0).getPosition().getY(), 17);
        testPlayers.get(0).walk(Direction.LEFT);  //Player 1 is not going to be able to move since the left position it is blocked, so isTileEmpty() returns false.
        assertEquals(testPlayers.get(0).getPosition().getX(), 1);
        assertEquals(testPlayers.get(0).getPosition().getY(), 17);
    }

    @Test
    void test_dropBomb(){ //tests tryAddBombToWorld() Also
        final Player player = map.getPlayers().get(0);
        assertTrue(player.isAlive());
        assertEquals(0, map.getBombs().size());
        player.dropBomb();
        assertEquals(1, map.getBombs().size());
        player.walk(Direction.UP);
        player.walk(Direction.UP); //player avoids the bomb by beings two steps away
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                assertEquals(0, map.getBombs().size()); //because the player has exploded by now and removed from the list of bombs.
                assertTrue(player.isAlive()); //check that player is still alive two squares away.
            }
        }, 2500); //bomb detonates after 2 seconds and size is checked after 2.5 seconds.
        try{
            Thread.sleep(3000); //Let the main thread wait for the size check timer to run out.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void test_tryToKillEntity(){
        final Player player = map.getPlayers().get(0);
        assertTrue(player.isAlive());
        map.tryToKillEntity(new Position(player.getPosition().getX(), player.getPosition().getY())); //remove player
        assertFalse(player.isAlive());
    }

}