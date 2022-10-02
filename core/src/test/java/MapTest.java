import Models.Map;
import Models.Tile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    Map map = new Map();
    @Test
    void matrix_length() {
        assertEquals(20, map.getMapMatrix().length);
    }
    @ParameterizedTest
    void empty_entities() {
        map.addObjects();
        Tile[][] matrix = map.getMapMatrix();

    }
}