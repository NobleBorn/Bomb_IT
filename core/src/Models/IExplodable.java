package Models;

public interface IExplodable {
    boolean tryAddBombToWorld(Position pos, Bomb ent);
    boolean tryToKillEntity(Position position);
    boolean removeBombFromWorld(Bomb bomb);
}
