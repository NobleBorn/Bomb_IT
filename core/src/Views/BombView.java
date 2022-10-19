package Views;

import Models.Bomb;
import Models.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class BombView implements IDrawable{
    private final Bomb bomb;
    private final Texture bombImage;

    /**
     *
     * @param bomb - an instance of bomb
     * @param bombImage - the bomb image
     */
    public BombView(Bomb bomb, Texture bombImage){
        this.bomb = bomb;
        this.bombImage = bombImage;
    }

    private Texture getBombImage(){
        return bombImage;
    }

    /**
     *
     * @param sb - an instance of spritebatch
     */
    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(getBombImage(), (bomb.getPosition().getY()* Tile.tileSize)+4, (bomb.getPosition().getX()*Tile.tileSize)+1);
    }

}


