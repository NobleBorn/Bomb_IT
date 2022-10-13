import Models.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MapTest {
    private final Map map = new Map();
    private final Tile[][] matrix = map.getMapMatrix();
    private final List<Player> testPlayers = map.getPlayers();

    @Test
    void matrix_row_length() {
        for (Tile[] row: matrix) {
            assertEquals(20, row.length);
        }
    }
    @Test
    void matrix_col_length() {
        int counter = 0;
        for (Tile[] row: matrix) {
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
        expected.add(new Player(new Position(16, 2), map));
        for (int i=0; i<testPlayers.size(); i++){
            assertEquals(testPlayers.get(i).getPosition().getX(), expected.get(i).getPosition().getX());
            assertEquals(testPlayers.get(i).getPosition().getY(), expected.get(i).getPosition().getY());
        }
    }

}