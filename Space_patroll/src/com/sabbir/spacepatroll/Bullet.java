package com.sabbir.spacepatroll;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {
	Sprite b;
	float speed= 10f;
	public Bullet (float x, float y)
	{
		b=new Sprite(new Texture(Gdx.files.internal("bullet.png")));
		
		
		b.setPosition(x, y);
	}
	public void render (SpriteBatch batch)
	{
		b.draw(batch);
	}
	
	public void update(){
		b.translateX(speed);
	}

}
