package Views;

//import Controllers.KeyHandler;
import Controllers.PlayerController;
import Models.Bomb;
import Models.Position;
import Models.Tile;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class BombView extends ApplicationAdapter implements IDrawable{
    SpriteBatch batch;
    Bomb bomb;
    PlayerController playerController;

    Texture bombImage;
    TextureRegion bombPlayerImage;

    /**
     *
     * @param bomb - an instance of bomb
     * @param bombImage - the bomb image
     */
    public BombView(Bomb bomb, Texture bombImage){
        this.bomb = bomb;
        this.bombImage = bombImage;

    }

    /**
     *
     * @return - current bomb image
     */
    public Texture getBombImage(){
        return bombImage;
    }

    /**
     *
     * @param sb - an instance of spritebatch
     */
    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(getBombImage(), bomb.getPosition().getY()* Tile.tileSize, bomb.getPosition().getX()*Tile.tileSize);
    }


}


