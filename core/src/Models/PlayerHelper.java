package Models;

public class PlayerHelper { //purpose of class is to hide Map from Player
    private Map map;
    private Position newPosition;

    public PlayerHelper(Position newPosition){
        this.newPosition = newPosition;
    }

    public boolean callCollisionChecker(){
        return map.isPlayerNextTileFree(newPosition);
    }
}
