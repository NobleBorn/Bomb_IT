import Models.Direction;
import Models.Map;
import Models.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombTest {
    private final Map map = new Map();

    @Test
    void testWalk() {
        Player testPlayer = map.getPlayers().get(0);
        testPlayer.dropBomb();
    }
}
