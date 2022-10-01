import Models.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest {
    @Test
    void empty_entities() {
        Map map = new Map();
        assertEquals(20, map.getMapMatrix().length);
    }
}