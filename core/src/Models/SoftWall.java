package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class contains a list of all soft wall objects
 */
public class SoftWall extends Wall implements Destroyable { //marker interface
    private List<SoftWall> objArray;

    /**
     * Constructor
     *
     * @param position - position of the soft wall object
     * @param objArray - a list of all soft wall objects on the map
     */
    public SoftWall(Position position, List<SoftWall> objArray) {
        super(position);
        this.objArray = objArray;
    }

    /**
     * Removes the soft wall object from the map
     */
    @Override
    public void terminate() {
        objArray.remove(this);
    }


}
