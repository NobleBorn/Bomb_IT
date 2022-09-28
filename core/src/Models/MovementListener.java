package Models;

public class MovementListener implements Subscriber {

    private Map map;
    private final String event = "movement";
    private Player player;

    public MovementListener(Map map){
        this.map = map;
    }

    @Override
    public void update(String eventType, Entity entity) {
        if (eventType.equals(event)){
            if (entity instanceof Player){
                player = (Player) entity;
                Tile[][] tiles = map.getTiles();
                tiles[player.getPosition().getX()][player.getPosition().getY()].removeEntity(player);
                tiles[player.getNextPosition().getX()][player.getNextPosition().getY()].addEntity(player);

            }


        }
    }
}
