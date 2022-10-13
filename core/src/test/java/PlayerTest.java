import Models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private final Map map = new Map();
    MovementListener listener = new MovementListener(map);


    @Test
    void testWalk(){
        Player testPlayer = map.getPlayers().get(0);
        testPlayer.observable.addSubscriber(listener);
        assertEquals(1, testPlayer.getPosition().getX());
        assertEquals(18, testPlayer.getPosition().getY());
        testPlayer.walk(Direction.LEFT);
        assertEquals(1, testPlayer.getPosition().getX());
        assertEquals(17, testPlayer.getPosition().getY());
        testPlayer.walk(Direction.RIGHT);
        assertEquals(1, testPlayer.getPosition().getX());
        assertEquals(18, testPlayer.getPosition().getY());
        testPlayer.walk(Direction.RIGHT);
        assertEquals(1, testPlayer.getPosition().getX());
        assertEquals(18, testPlayer.getPosition().getY()); // same y-coordinate because wall blocks desired position.
    }
    @Test
    void testGetDirection(){
        Player testPlayer = map.getPlayers().get(1);
        assertEquals(Direction.UP, testPlayer.getDirection());
        testPlayer.walk(Direction.DOWN);
        assertEquals(Direction.DOWN, testPlayer.getDirection());
    }

}