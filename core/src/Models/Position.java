package Models;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;

    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Boolean isCollide(Position otherPosition){
        return ((this.x == otherPosition.x) && (this.y == otherPosition.y));
    }
}
