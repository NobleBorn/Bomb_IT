package Models;

public interface INavigable {

    boolean tryMove(Position newPos, Player player);
    boolean addEntityToWorld(Position pos, Entity ent);
    boolean tryToKillEntity(Position position);

}
