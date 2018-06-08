package com.sabbir.spacepatroll;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemyBoss {
	Sprite b;
	float speed = 4.5f, maxX = 1000.0f, ySpeed = 5.0f;
	Random r;
	public int bulletes;
	public EnemyBoss() {
		// TODO Auto-generated constructor stub
		b=new Sprite(new Texture(Gdx.files.internal("giphy.png")));
		b.setPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2-b.getHeight()/2);
		
		bulletes = -1;
		r = new Random();
	}
	public void update()
	{
		if(b.getX() > maxX)
			b.translate(-speed, 0);
		b.translate(0, ySpeed);
		
		if(b.getY() >= 520 || b.getY() <= 0)
			ySpeed *= -1;
	}
	
	public boolean isFire(){
		int n = r.nextInt(60);
		return n == 5;
	}
	
	public void render(SpriteBatch batch){
		b.draw(batch);
		
	}
	
	
}
