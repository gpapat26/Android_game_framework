package com.jamescho.game.main;

import javax.swing.JPanel;

import com.jamescho.game.state.LoadState;
import com.jamescho.game.state.State;

import java.awt.Color;
import java.awt.Dimension;
import java .awt.Image;

@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable{
	
	private int gameWidth;
	private int gameHeight;
	private Image gameImage;
	
	private Thread gameThread;
	
	private volatile State currentState;
	
	private volatile boolean running;
	
	public Game(int gameWidth , int gameHeight){
		this.gameHeight= gameHeight;
		this.gameWidth = gameWidth;
		setPreferredSize(new Dimension(gameWidth, gameHeight));
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocus();
		
	}
	
	public void setCurrentState(State newState){
		System.gc();
		newState.init();
		currentState = newState;
	}
	
	@Override
	public void addNotify(){
		super.addNotify();
		setCurrentState(new LoadState());
		initGame();
	}

	private void initGame() {
		running  = true;
		gameThread = new Thread(this,"Game Thread");
		gameThread.start();
		
	}

	@Override
	public void run() {
		while(running){
			
		}
		System.exit(0);
	}
	
	
}
