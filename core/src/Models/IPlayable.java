package Models;

/**
 * An interface that manages player movement {@link Player}
 */
public interface IPlayable {

    /**
     *
     * @param newPos - the new position that player is trying to move to in type {@link Position}
     * @param player - an instance of the player {@link Player}
     * @return true if player can move the new position and false otherwise
     */
    boolean tryMove(Position newPos, Player player);

    /**
     *
     * @param player - an instance of the player {@link Player} that drops the bomb {@link Bomb}
     */
    void dropBomb(Player player);
}
