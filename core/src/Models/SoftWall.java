package Models;

import java.util.ArrayList;
import java.util.List;

public class SoftWall extends Wall implements Destroyable {
    private List<SoftWall> objArray;
    public SoftWall(Position position, List<SoftWall> objArray) {
        super(position);
        this.objArray = objArray;
    }

    @Override
    public void terminate() {
        objArray.remove(this);

    }


}
