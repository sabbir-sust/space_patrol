package com.sabbir.spacepatroll;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemyBullet {
	Sprite b1;
	float speed= 10f;
	public EnemyBullet (float x, float y)
	{
		b1=new Sprite(new Texture(Gdx.files.internal("enemybullet.png")));
		b1.setScale(-1, 1);
		
		b1.setPosition(x, y);
	}
	public void render (SpriteBatch batch)
	{
		b1.draw(batch);
	}
	
	public void update(){
		b1.translateX(-speed);
	}

}
