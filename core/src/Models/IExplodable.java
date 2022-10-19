package Models;

import java.util.List;

public interface IExplodable {
    boolean tryAddBombToWorld(Position pos, Bomb ent);
    List<Boolean> tryToKillEntity(Position position);
    boolean removeBombFromWorld(Bomb bomb);
}
