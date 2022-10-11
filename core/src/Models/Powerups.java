package Models;

public class Powerups extends Entity{
    Powerups(Position position) {
        super(position);
    }

    @Override
    protected Entity copyThis() {
        return new Powerups(position);
    }
}
