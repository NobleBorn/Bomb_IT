package Models;

public class Powerups extends Entity{
    public Powerups(Position position) {
        super(position);
    }

    @Override
    protected Entity copyThis() {
        return new Powerups(position);
    }
}
