package Models;

public class Wall extends Entity{

    private boolean isDestroyable;
    //private Position position;

    public Wall(boolean isDestroyable, Position position){
        super(position);
        this.isDestroyable = isDestroyable;
        //this.position = super.position;
    }

    public boolean isDestroyable() {
        return isDestroyable;
    }

    @Override
    protected Entity copyThis() {
        return new Wall(this.isDestroyable, new Position(this.position));
    }
}
