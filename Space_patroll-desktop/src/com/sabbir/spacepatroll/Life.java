package com.sabbir.spacepatroll;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Life {
	Sprite l;
	float speed= 7f;
	public void render (SpriteBatch batch)
	{
		l.draw(batch);
	}
	
	public void update(){
		l.translateX(-speed);
	}

}
