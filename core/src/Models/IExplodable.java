package Models;

/**
 * Classes that implements IEexplodable must implement these methods for bomb management
 */
public interface IExplodable {
    /**
     *
     * @param pos - position of the bomb see {@link Bomb}
     * @param ent -
     * @return true if bomb can be placed on the map and false if not possible
     */
    boolean tryAddBombToWorld(Position pos, Bomb ent);

    /**
     *
     * @param position - position of the entity see {@link Entity} in explosion area
     * @return true if entity can be killed and false if not possible
     */
    boolean tryToKillEntity(Position position);

    /**
     *
     * @param bomb - an instance of the bomb that is to be removed from the map
     */
    boolean removeBombFromWorld(Bomb bomb);
}
