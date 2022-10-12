package Models;

public class SoftWall extends Wall implements Destroyable {

    public SoftWall(Position position) {
        super(position);
    }

    @Override
    public void terminate() {
        //here goes code to generate power-ups
    }

    @Override //does this break Interface Segregation Principle?
    protected Entity copyThis() {
        return new SoftWall(new Position(this.position));
    }

}
