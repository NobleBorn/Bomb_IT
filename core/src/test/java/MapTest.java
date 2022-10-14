import Models.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MapTest {
    private final Map map = new Map();
    private final List<Player> testPlayers = map.getPlayers();

    @Test
    void matrix_row_length() {
        for (Tile[] row: map.getMapMatrix()) {
            assertEquals(20, row.length);
        }
    }
    @Test
    void matrix_col_length() {
        int counter = 0;
        for (Tile[] row: map.getMapMatrix()) {
            for (Tile tile: row) {
                counter++;
            }
            assertEquals(20, counter);
            counter = 0;
        }
    }
    @Test
    void test_players_positions(){
        List<Player> expected = new ArrayList<>(2);
        expected.add(new Player(new Position(1, 18), map));
        expected.add(new Player(new Position(18, 1), map));
        for (int i=0; i<testPlayers.size(); i++){
            assertEquals(testPlayers.get(i).getPosition().getX(), expected.get(i).getPosition().getX());
            assertEquals(testPlayers.get(i).getPosition().getY(), expected.get(i).getPosition().getY());
        }
    }

    @Test
    void test_tryMove(){
        assertEquals(testPlayers.get(1).getPosition().getX(), 18);
        assertEquals(testPlayers.get(1).getPosition().getY(), 1);

        testPlayers.get(1).walk(Direction.RIGHT); //This is going to go to map's tryMove(position, player)
        assertEquals(testPlayers.get(1).getPosition().getX(), 18);
        assertEquals(testPlayers.get(1).getPosition().getY(), 2);

    }

    @Test
    void test_addEntityToWorld(){
        assertTrue(map.getMapMatrix()[16][2].isTileEmpty()); //check that Tile is empty when starting

        Entity ent = new Wall(new Position(16, 2));
        map.addEntityToWorld(new Position(16, 2), ent);

        assertFalse(map.getMapMatrix()[16][2].isTileEmpty());

    }

    @Test
    void test_tryToKillEntity(){
        assertFalse(map.getMapMatrix()[16][3].isTileEmpty()); //checking that there is an entity at position
        assertTrue(map.getMapMatrix()[16][3].getEntities().get(0) instanceof SoftWall); //checking that the entity is destroyable

        map.tryToKillEntity(new Position(16,3)); //remove SoftWall

        assertTrue(map.getMapMatrix()[16][3].isTileEmpty()); //Check that it is removed

    }

}