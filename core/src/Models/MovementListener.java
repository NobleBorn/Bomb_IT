package Models;

public class MovementListener implements MoveSubscriber {

    private Map map;
    private Player player;

    public MovementListener(Map map){
        this.map = map;
    }

    @Override
    public void update(Position oldPosition, Position newPosition) {
                Tile[][] tiles = map.getTiles();
                if (tiles[oldPosition.getX()][oldPosition.getY()].entities.get(0) instanceof Player){
                    player = (Player) tiles[oldPosition.getX()][oldPosition.getY()].entities.get(0);
                    tiles[oldPosition.getX()][oldPosition.getY()].removeEntity();
                    tiles[newPosition.getX()][newPosition.getY()].addEntity(player);
                }
    }
}

