package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    Sprite gemSprite;
    ShapeRenderer shape;
    float rotation;
    BitmapFont font;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
        //gemSprite = new Sprite(img);
        //gemSprite.setPosition(100, 100);
        shape = new ShapeRenderer();
        rotation = 0;

        font = new BitmapFont(Gdx.files.internal("fonts/impact_72.fnt"),false);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        drawNuclear(300, 360, 100, rotation);

        if(Gdx.input.isTouched()){
            //rotateRight();
            Gdx.app.log("TAG",String.valueOf(Gdx.app.getGraphics().getHeight()) + "," + String.valueOf(Gdx.app.getGraphics().getWidth()));
            rotation--;
        }
	}

    private void rotateRight() {
        gemSprite.setRotation(gemSprite.getRotation() - 1);
    }

    private void drawNuclear(int x, int y, int r, float rot) {
        //Spinning Icon
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(1, 1, 0, 1);
        shape.circle(x,y,r*1.3f);

        shape.setColor(0, 0, 0, 1);
        shape.circle(x,y,r*1.2f);

        shape.setColor(1, 1, 0, 1);
        shape.arc(x,y,r,rot,60);
        shape.arc(x,y,r,rot+120,60);
        shape.arc(x,y,r,rot+240,60);

        shape.setColor(0, 0, 0, 1);
        shape.circle(x,y,r*0.35f);

        shape.setColor(1, 1, 0, 1);
        shape.circle(x, y, r*0.15f);
        shape.end();

        //Text
        batch.begin();
        font.setColor(1.0f, 1.0f, 0.0f, 1.0f);
        font.setScale(2.5f,2.5f);
        font.draw(batch, "NUCLEAR", 460, 430);
        batch.end();
    }


}
