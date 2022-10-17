package Models;

public interface IPlayable {
    boolean tryMove(Position newPos, Player player);
    void dropBomb(Player player);
}
