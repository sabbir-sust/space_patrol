package com.sabbir.spacepatroll;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemyBossBullet {
	Sprite b2;
	float speed= 10f;
	public EnemyBossBullet (float x, float y)
	{
		b2=new Sprite(new Texture(Gdx.files.internal("bossbullet.png")));
		b2.setScale(-1, 1);
		
		b2.setPosition(x, y);
	}
	public void render (SpriteBatch batch)
	{
		b2.draw(batch);
	}
	
	public void update(){
		b2.translateX(-speed);
	}

}
