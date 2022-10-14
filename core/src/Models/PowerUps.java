package Models;

public class PowerUps extends Entity{

    PowerUps(Position position) {
        super(position);
    }

    @Override
    protected Entity copyThis() {
        return new PowerUps(position);
    }
}
