package com.sabbir.spacepatroll;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy {

	Sprite e;
	float speed = 4.5f,ySpeed = 5.0f;
	Random r;
	int bulletes;
	
	private String names[] = {
			"enemy_0",
			"enemy_1",
			"enemy_2",
			"enemy_3",
			"enemy_4",
			"enemy_5"
	};

	public Enemy() {
		
		r = new Random();
		
		e = new Sprite(new Texture(Gdx.files.internal(names[r.nextInt(names.length)] + ".png")));
		e.setPosition(Gdx.graphics.getWidth(), r.nextInt((int) Gdx.graphics.getHeight() - (int) e.getHeight()));
		
	//	bulletes = 5;
	}

	public void update() {
		e.translate(-speed, 0);
//		e.translate(-speed, ySpeed);
//		
//		if(e.getY() >= 720 || e.getY() <= 0)
//			ySpeed *= -1;
	}

	public void render(SpriteBatch batch) {
		e.draw(batch);
	}
	
	public boolean isFire(){
		int n = r.nextInt(300);
		return n == 5;
	}
}
