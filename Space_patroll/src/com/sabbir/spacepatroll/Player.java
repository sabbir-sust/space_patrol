package com.sabbir.spacepatroll;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	Sprite p;
	float speed;
	
	public Player(){
		
		p = new Sprite(new Texture(Gdx.files.internal("player.png")));
		p.setSize(p.getWidth() / 2, p.getHeight() / 2);
		p.setPosition(0, Gdx.graphics.getHeight() / 2 - p.getHeight() / 2);
		
		speed = 7.0f;
	}
	
	
	public void render(SpriteBatch batch){
		p.draw(batch);
	}
	
	public void input(){
		if(Gdx.input.isKeyPressed(Keys.UP)){
			p.translateY(speed);
			if(p.getY() > Gdx.graphics.getHeight() -p.getHeight()/2)
				p.setY(Gdx.graphics.getHeight()-p.getHeight()/2);
		}
		
		if(Gdx.input.isKeyPressed(Keys.DOWN)){
			p.translateY(-speed);
			if(p.getY() < -p.getHeight()/2)
				p.setY(-p.getHeight()/2);
		}
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			p.translateX(-speed);
			if(p.getX() < -p.getWidth()/2)
				p.setX(-p.getWidth()/2);
		}
		
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			p.translateX(speed);
			if(p.getX() > Gdx.graphics.getWidth() - p.getWidth()/2)
				p.setX(Gdx.graphics.getWidth() - p.getWidth()/2);
		}
	}
}
