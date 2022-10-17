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
    //KeyHandler keyH;
    TextureRegion bombPlayerImage;

    public BombView(Bomb bomb, Texture bombImage){
        this.bomb = bomb;
        keyH = new KeyHandler();
        this.bombImage = bombImage;

    }

    private void addsprite(){
        bombPlayerImage = new TextureRegion(bombImage, 0, 0, 64, 64);
    }

    public Texture getBombImage(){
        //TextureRegion image = bombPlayerImage;

        /*if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
            image = bombPlayerImage;
        }*/
        return bombImage;
    }

    @Override
    public void draw(SpriteBatch sb) {
        /* for (Position explosionPosition: bomb.getExplosions()){
            sb.draw(getBombImage(), explosionPosition.getY()* Tile.tileSize, explosionPosition.getX()*Tile.tileSize);
        } */
        sb.draw(getBombImage(), bomb.getPosition().getY()* Tile.tileSize, bomb.getPosition().getX()*Tile.tileSize);
    }

    /*public Texture setupPlayerImage() {
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
                return bombImage;
        } return null;
    }*/

    /*@Override
    public void create () {
        batch = new SpriteBatch();
        bombImage = new Texture("bomb.png");
    }

    @Override
    public void render () {
        //ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(bombImage, bomb.getPosition().getX(), bomb.getPosition().getY());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bombImage.dispose();
    }*/

}


