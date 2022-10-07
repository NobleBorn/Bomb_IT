import Models.Entity;
import Models.Map;
import Models.Tile;
import Models.Wall;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;

import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private final Map map = new Map();
    private final Tile[][] matrix = map.getMapMatrix();


    @BeforeAll
    void count_matrix() {
        int playerCount = 0;
        int permWallCount = 0;
        int tempWallCount = 0;
        int emptyCount = 0;
        Entity ent = null;
        for (Tile[] row: matrix) {
            for (Tile col: row){
                if (!col.isTileEmpty()){
                    switch (col.getEntities().get(0).getClass().getName()){
                        //ent = col.getEntities().get(0);
                        case "Player": playerCount++;
                        case "Wall":

                            ent = (Wall) ent;
                            /* if (ent.isDestroyable()){
                                tempWallCount++;
                            }else{
                                permWallCount++;
                            } */
                    }
                }
                else{
                    emptyCount++;
                }
            }
        }
    }
    @Test
    void matrix_length() {
        for (Tile[] row: matrix) {
            assertEquals(20, row.length);
        }
    }
}