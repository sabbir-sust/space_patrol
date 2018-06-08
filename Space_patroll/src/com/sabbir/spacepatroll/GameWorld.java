package com.sabbir.spacepatroll;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameWorld implements InputProcessor {
	
	Player player;
	EnemyBoss boss;
	ArrayList<Enemy> enemies;
	ArrayList<Enemy2> enemies2;
	ArrayList<Enemy3> enemies3;
	ArrayList<Enemy4> enemies4;
	ArrayList<Bullet> bulletes;
	ArrayList<EnemyBullet>bulletes1;
	ArrayList<EnemyBossBullet>bulletes2;
	
	Sprite background;
	
	//ArrayList<Life>life1;
	float time, time1, time2,time3;
	int score, life, cnt, level;
	BitmapFont font;
	boolean gameOver;
	
	public GameWorld(){
		
		initGameWorld();
		
	}
	
	private void initGameWorld() {
		player = new Player();
		boss = new EnemyBoss();
		enemies = new ArrayList<Enemy>();
		enemies2 = new ArrayList<Enemy2>();
		enemies3 = new ArrayList<Enemy3>();
		enemies4 = new ArrayList<Enemy4>();
		bulletes = new ArrayList<Bullet>();
		bulletes1 =new ArrayList<EnemyBullet>();
		bulletes2 =new ArrayList<EnemyBossBullet>();
		time = 2.0f;
		time1 = 2.0f;
		time2 = 2.0f;
		time3 = 2.0f;
		life = 3;
		cnt = 0;
		gameOver = false;
		
		font = new BitmapFont();
		font.setColor(Color.RED);
		font.setScale(2);
		
		background = new Sprite(new Texture(Gdx.files.internal("background.png")));
		background.setScale(2, 2);
		background.setPosition(0, 0);
	}

	public void input(){
		player.input();
	}
	
	public void update(){
		
		if(boss.bulletes == 0){
			initGameWorld();
			level++;
			return;
		}
		
		if(Gdx.input.isKeyPressed(Keys.ENTER) && gameOver){
			Gdx.app.exit();
		}
		
		time += Gdx.graphics.getDeltaTime();
		time1 += Gdx.graphics.getDeltaTime();
		if(time >= 1.0f){
			enemies.add(new Enemy());
			time = 0;
		}
		if(level >= 2){
			if(time1 >= 1.0f){
				enemies2.add(new Enemy2());
				time1 = 0;
			}
		}
//		if(level >= 3){
//			if(time2 >= 1.0f){
//				enemies3.add(new Enemy3());
//				time2 = 0;
//			}
//		}
//		if(level >= 4){
//			if(time3 >= 1.0f){
//				enemies4.add(new Enemy4());
//				time3 = 0;
//			}
//		}
		for(int i = enemies.size() - 1; i >= 0; i--){
			Enemy temp = enemies.get(i);
			temp.update();
			if(temp.isFire()){
				bulletes1.add(new EnemyBullet(temp.e.getX(), temp.e.getY()-20 + temp.e.getHeight() / 2));
			}
			
			if(temp.e.getX() + temp.e.getWidth() <= 0){
				enemies.remove(i);
			}
			
		}
		
		for(int i = enemies2.size() - 1; i >= 0; i--){
			Enemy2 temp = enemies2.get(i);
			temp.update();
			if(temp.isFire()){
				bulletes1.add(new EnemyBullet(temp.e.getX(), temp.e.getY()-20 + temp.e.getHeight() / 2));
			}
			
			if(temp.e.getX() + temp.e.getWidth() <= 0){
				enemies2.remove(i);
			}
			
		}
		
//		for(int i = enemies3.size() - 1; i >= 0; i--){
//			Enemy3 temp = enemies3.get(i);
//			temp.update();
//			if(temp.isFire()){
//				bulletes1.add(new EnemyBullet(temp.e.getX(), temp.e.getY()-20 + temp.e.getHeight() / 2));
//			}
//			
//			if(temp.e.getX() + temp.e.getWidth() <= 0){
//				enemies3.remove(i);
//			}
//			
//		}
////		for(int i = enemies4.size() - 1; i >= 0; i--){
////			Enemy4 temp = enemies4.get(i);
////			temp.update();
////			if(temp.isFire()){
////				bulletes1.add(new EnemyBullet(temp.e.getX(), temp.e.getY()-20 + temp.e.getHeight() / 2));
////			}
////			
////			if(temp.e.getX() + temp.e.getWidth() <= 0){
////				enemies4.remove(i);
////			}
////			
////		}
//		
		
		if(boss.bulletes > 0){
			boss.update();
			if(boss.isFire()){
				bulletes2.add(new EnemyBossBullet(boss.b.getX(), boss.b.getY()+boss.b.getHeight() / 2));
			}
		}
		
		
		for(int i = bulletes.size() - 1; i >= 0; i--){
			Bullet tmp = bulletes.get(i);
			tmp.update();
		}
		
		for(int i = bulletes1.size() - 1; i >= 0; i--){
			EnemyBullet tmp = bulletes1.get(i);
			tmp.update();
		}
		for(int i = bulletes2.size() -1;i >=0; i--){
			EnemyBossBullet tmp =bulletes2.get(i);
			tmp.update();
		}
//		for(int i = 0; i < enemies2.size(); ++i)
//			enemies2.get(i).update();
		
		
		for(int i = enemies.size() - 1; i >= 0; --i){
			Enemy e = enemies.get(i);
			for(int j = bulletes.size() - 1; j >= 0; --j){
				Bullet b = bulletes.get(j);
				if(b.b.getBoundingRectangle().overlaps(e.e.getBoundingRectangle())){
					enemies.remove(i);
					bulletes.remove(j);
					
					cnt++;
					if(cnt >= 10)
						boss.bulletes = 10 ;
					
					if(! gameOver)
						score =score+5;
					
//					if(b.b.getBoundingRectangle().overlaps(e.e.getBoundingRectangle())){
////						e.bulletes--;
////						if(e.bulletes <= 0){
////							enemies.remove(i);
////						}
//						enemies.remove(i);
//						bulletes.remove(j);
//						//if(!gameOver)
//							score =score+5;
//					
				}
			}
		}
		
		for(int i = enemies2.size() - 1; i >= 0; --i){
			Enemy2 e = enemies2.get(i);
			for(int j = bulletes.size() - 1; j >= 0; --j){
				Bullet b = bulletes.get(j);
				if(b.b.getBoundingRectangle().overlaps(e.e.getBoundingRectangle())){
					enemies2.remove(i);
					bulletes.remove(j);
					
					cnt++;
					if(cnt >= 10)
						boss.bulletes = 10 ;
					
					if(!gameOver)
						score =score+5;
					
//					if(b.b.getBoundingRectangle().overlaps(e.e.getBoundingRectangle())){
////						e.bulletes--;
////						if(e.bulletes <= 0){
////							enemies.remove(i);
////						}
//						enemies.remove(i);
//						bulletes.remove(j);
//						//if(!gameOver)
//							score =score+5;
//					
				}
			}
		}
		for(int i = bulletes.size() -1;i >=0;--i)
		{
			Bullet b = bulletes.get(i);
			if(b.b.getBoundingRectangle().overlaps(boss.b.getBoundingRectangle()))
			{
				if(boss.bulletes > 0){
					bulletes.remove(i);
					boss.bulletes--;
					
					if(!gameOver)
						score = score+5;
				}
				
			}
		}
		for(int i=bulletes.size() -1;i>=0;--i){
			Bullet b =bulletes.get(i);
			for(int j=bulletes1.size() -1;j>=0;--j){
				EnemyBullet b1=bulletes1.get(j);
				if(b.b.getBoundingRectangle().overlaps(b1.b1.getBoundingRectangle())){ 
					bulletes.remove(i);
					bulletes1.remove(j);
				} 
			}
		}
		for(int i=bulletes.size() -1;i>=0;--i)
		{
			Bullet b=bulletes.get(i);
			for(int j=bulletes2.size() -1;j>=0;--j){
				EnemyBossBullet b1=bulletes2.get(j);
				if(b.b.getBoundingRectangle().overlaps(b1.b2.getBoundingRectangle()))
				{
					bulletes.remove(i);
					bulletes2.remove(j);
				}
			}
		}
//		Sprite ex;
//		private String names[] = {
//				"explotin_0",
//				"explotion_1",
//				"explotion_2",
//				"explotion_3",
//				"explotion_4",
//				"explotion_5"
//		};
		for(int i=enemies.size() -1;i>=0;i--){
			Enemy e =enemies.get(i);
			if(player.p.getBoundingRectangle().overlaps(e.e.getBoundingRectangle()))
			{
				life--;
				if(life <= 0){
					gameOver = true;
				}
				player =new Player();
				enemies.remove(i);
				
			}
		}
		for(int i=enemies2.size() -1;i>=0;i--){
			Enemy2 e =enemies2.get(i);
			if(player.p.getBoundingRectangle().overlaps(e.e.getBoundingRectangle()))
			{
				life--;
				if(life <= 0){
					gameOver = true;
				}
				player =new Player();
				enemies2.remove(i);
				
			}
		}
		
		for(int i=bulletes1.size() -1;i>=0;i--){
			EnemyBullet b1=bulletes1.get(i);
			if(player.p.getBoundingRectangle().overlaps(b1.b1.getBoundingRectangle()))
			{
				life--;
				if(life<=0)
				{
					gameOver = true;
				}
				player =new Player();
				bulletes1.remove(i);
			}
			
		}
		

		
		for(int i=bulletes2.size() -1;i>=0;--i)
		{
			EnemyBossBullet b2=bulletes2.get(i);
			if(player.p.getBoundingRectangle().overlaps(b2.b2.getBoundingRectangle()))
			{
				life--;
				if(life<=0)
				{
					gameOver = true;
				}
				player =new Player();
				bulletes2.remove(i);
			}
				
		}
//		FOR(INT I = ENEMIES.SIZE()-1;I >=0;I--){
//			ENEMY E = ENEMIES.GET(I);
//			FOR(INT J = PLAYER.SIZE() - 1; J>=0; --J){
//				PLAYER P = PALYER.GET(J);
//				IF(P.P.GETBOUNDINGRECTANGLE().OVERLAPS(E.E.GETBOUNDINGRECTANGLE())){
//					PLAYER.REMOVE(J);
//					ENEMIES.REMOVE(I);
//				}
//			}
//		}
	
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.SPACE){
			float x = player.p.getX() + player.p.getWidth() - 50;
			float y = player.p.getY() + player.p.getHeight() / 2 - 8;
			Bullet tmp = new Bullet(x, y);
			bulletes.add(tmp);
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
