package com.sabbir.spacepatroll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main implements ActionListener {
	
	//JFrame win;
	
	
	
	public static void mai() {
		//new Main();
		
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
		
		cfg.title = "Space_patroll";
		cfg.useGL20 = false;
		cfg.width = 1366;
		cfg.height = 768;
		cfg.fullscreen = true;
		
		new LwjglApplication(new Game(), cfg);
	}
	
//	public Main(){
//		
//		win = new JFrame("Game UI");
//		JButton bt1 = new JButton("Play");
//		win.add(bt1);
//		win.show();
//		
//		JButton bt2 = new JButton("Exit");
//		win.add(bt2);
//		win.show();
//		
//		
//		bt1.addActionListener(this);
//		bt2.addActionListener(this);
//	}
//	
//	private void startGame(){
//		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
//		cfg.title = "Space_patroll";
//		cfg.useGL20 = false;
//		cfg.width = 1366;
//		cfg.height = 768;
//		cfg.fullscreen = true;
//		
//		new LwjglApplication(new Game(), cfg);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println("Clicked");
//		startGame();
//	}
}
