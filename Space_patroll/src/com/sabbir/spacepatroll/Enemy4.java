package com.sabbir.spacepatroll;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy4 {
	Sprite e;
	float speed = 4.5f,maxX = 000.0f, ySpeed = 5.0f;
	Random r;
	int bulletes;
	
	private String names[] = {
			"as_0",
			"as_1"
			//"enemy3_2",
			//"enemy3_3",
			//"enemy3_4",
			//"enemy3_5"
	};
	public Enemy4()
	{
		r = new Random();
		
		e = new Sprite(new Texture(Gdx.files.internal(names[r.nextInt(names.length)] + ".png")));
		e.setPosition(Gdx.graphics.getWidth(), r.nextInt((int) Gdx.graphics.getHeight() - (int) e.getHeight()));
		
	//	bulletes = 5;
	}
	
	public void update() {
		//e.translate(-speed, 0);
		//if(e.getX() > maxX)
			//e.translate(-speed, 0);
		e.translate(-speed, ySpeed);
		
		if(e.getY() >= 720 || e.getY() <= 0)
			ySpeed *= -1;
	}

	public void render(SpriteBatch batch) {
		e.draw(batch);
	}
	
	public boolean isFire(){
		int n = r.nextInt(300);
		return n == 5;
	}

}
