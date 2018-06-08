package com.sabbir.spacepatroll;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderer {
	
	GameWorld world;
	
	public Renderer(GameWorld w){
		world = w;
	}
	
	public void render(SpriteBatch batch){
		
		world.background.draw(batch);
		
		if(world.gameOver){
			world.font.draw(batch, "Game Over Score:" + world.score, 500, 500);
			return;
		}
		
		world.player.render(batch);
		if(world.boss.bulletes > 0)
			world.boss.render(batch);
		
		for(int i = 0; i < world.enemies.size(); i++){
			world.enemies.get(i).render(batch);
		}
		for(int i = 0; i< world.enemies2.size();i++){
			world.enemies2.get(i).render(batch);
		}
//		for(int i = 0; i< world.enemies3.size();i++){
//			world.enemies3.get(i).render(batch);
//		}
//		for(int i = 0; i< world.enemies4.size();i++){
//			world.enemies4.get(i).render(batch);
//		}
		
		
		for(int i = 0; i < world.bulletes.size(); i++){
			world.bulletes.get(i).render(batch);
		}
		
		for(int i = 0; i < world.bulletes1.size(); i++){
			world.bulletes1.get(i).render(batch);	
		}
		for(int i = 0;i < world.bulletes2.size();i++)
		{
			world.bulletes2.get(i).render(batch);
		}
		
		
		world.font.draw(batch, "Score: " + world.score, 0, 750);
		world.font.draw(batch, "Life: " + world.life, 1250, 750);
		world.font.draw(batch, "Level: " + world.level, 650, 750);
	}
	
}
