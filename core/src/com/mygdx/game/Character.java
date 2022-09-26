package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class Character extends ApplicationAdapter implements Destroyable, HavePosition{

    private void createObject() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,0);
    }

    SpriteBatch batch;
    Sprite sprite;
    Texture image;

    @Override
    public abstract void create();

    //logic
    @Override
    public void render () {
        batch.begin();
        batch.draw(sprite, 0, 0);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        image.dispose();
    }

    // skapa karaktärer
    // koppla karaktärer till varje spelare
    // koppla spelaren till bomben, boolean om spelarens bomb är aktiv eller ej
}
