package Models;

/**
 * Classes that implements IEexplodable must implement these methods to se if it's
 */
public interface IExplodable {
    boolean tryAddBombToWorld(Position pos, Bomb ent);
    boolean tryToKillEntity(Position position);
    boolean removeBombFromWorld(Bomb bomb);
}
