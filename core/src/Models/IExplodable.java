package Models;

import java.util.List;

/**
 * Classes that implements IEexplodable must implement these methods for bomb management
 */
public interface IExplodable {
    boolean tryAddBombToWorld(Position pos, Bomb ent);
    List<Boolean> tryToKillEntity(Position position);
    boolean removeBombFromWorld(Bomb bomb);
}
