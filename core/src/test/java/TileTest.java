import Models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TileTest {
    private final Map map = new Map();
    private final Tile[][] matrix = map.getMapMatrix();
    private final List<Player> testPlayers = map.getPlayers();
    private final Entity testEnt = new Wall(new Position(1, 1));
/*
    @Test
    void testAddEntity(){
        Tile testTile = new Tile(1, 1);
        assertEquals(0, testTile.getEntities().size());
        testTile.addEntity(testEnt);
        assertEquals(1, testTile.getEntities().size());
    }


    @Test
    void testRemoveEntity(){
        Tile testTile = new Tile(1, 1);
        testTile.addEntity(testEnt);
        assertEquals(1, testTile.getEntities().size());
        testTile.removeEntity();
        assertEquals(0, testTile.getEntities().size());
    }
    @Test
    void testIsTileEmpty(){
        Tile testTile = new Tile(1, 1);
        assertTrue(testTile.isTileEmpty());
        testTile.addEntity(testEnt);
        assertFalse(testTile.isTileEmpty());
    }
    @Test
    void testGetEntities(){
        Tile testTile = new Tile(1, 1);
        List<Entity> testWalls = new ArrayList<>();
        testTile.addEntity(testEnt);
        testWalls.add(testEnt);

        assertNotEquals(testEnt, testTile.getEntities().get(0)); //the type of both objects is the same, but getEntities() creates a deep-copy
        assertNotEquals(testWalls, testTile.getEntities()); //the list type and element object's type are the same, but deep-copied
    }

*/
}