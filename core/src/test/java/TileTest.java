import Models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TileTest{
    private final Map map = new Map();
    private Tile[][] matrix = map.getMapMatrix();

    @Test
    void testIsTileEmpty(){
        Entity testEnt = new Wall(new Position(1, 17));

        assertTrue(matrix[1][17].isTileEmpty());
        map.addEntityToWorld(new Position(1, 17), testEnt);
        matrix = map.getMapMatrix();
        assertFalse(matrix[1][17].isTileEmpty());
    }
    @Test
    void testGetEntities(){
        Entity testEnt = new Wall(new Position(2, 17));

        List<Entity> testArray = matrix[2][17].getEntities();
        assertEquals(matrix[2][17].getEntities().size(), testArray.size());
        map.addEntityToWorld(new Position(2, 17), testEnt);
        matrix = map.getMapMatrix();

        assertNotEquals(testArray.size(), matrix[2][17].getEntities().size());
    }

}