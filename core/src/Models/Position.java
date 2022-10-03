package Models;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;

    }

    public Boolean isCollide(Position otherPosition){
        return ((this.x == otherPosition.x) && (this.y == otherPosition.y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
