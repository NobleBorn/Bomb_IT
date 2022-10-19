package Models;

/**
 * Classes that implements IPlayable must implement these methods for player movement
 */
public interface IPlayable {
    /**
     *
     * @param newPos - the new position that player is trying to move to
     * @param player - an instance of the player
     * @return true if player can move to appointed position on the map and false if not possible
     */
    boolean tryMove(Position newPos, Player player);

    /**
     *
     * @param player - an instance of the player that drops the bomb
     */
    void dropBomb(Player player);
}
