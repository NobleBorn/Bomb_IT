package Models;

import Models.Position;

public class Wall extends Entity{


    public Wall(Position position){
        super(position);
    }

    @Override
    protected Entity copyThis() {
        return new Wall(new Position(this.position));
    }
}
