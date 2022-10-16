package Views;

//import Controllers.KeyHandler;
import Controllers.PlayerController;
import Models.Bomb;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class BombView extends ApplicationAdapter {
    SpriteBatch batch;
    Bomb bomb;
    PlayerController playerController;

    Texture bombImage;
    //KeyHandler keyH;
    TextureRegion bombPlayerImage;

    public BombView(Bomb bomb){
        //keyH = new KeyHandler();
        bombImage = new Texture("bombImage.png");
        addsprite();
    }

    private void addsprite(){
        bombPlayerImage = new TextureRegion(bombImage, 0, 0, 64, 64);
    }

    public TextureRegion getBombImage(){
        TextureRegion image = bombPlayerImage;

        /*if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
            image = bombPlayerImage;
        }*/
        return image;
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


