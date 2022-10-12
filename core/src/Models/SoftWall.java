package Models;

public class SoftWall extends Wall implements Destroyable {
    public SoftWall(Position position) {
        super(position);
    }

    @Override
    public void terminate() {
        //here goes code to generate power-ups
    }
}
