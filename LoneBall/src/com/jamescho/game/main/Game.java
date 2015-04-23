package com.jamescho.game.main;

import javax.swing.JPanel;

import com.jamescho.framework.util.InputHandler;
import com.jamescho.game.state.LoadState;
import com.jamescho.game.state.State;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java .awt.Image;

@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable{
	
	private int gameWidth;
	private int gameHeight;
	private Image gameImage;
	private InputHandler inputHandler;
	
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
		
		currentState = newState;
		
		newState.init();
		
		inputHandler.setCurrentState(currentState);
		
	}
	
	@Override
	public void addNotify(){
		super.addNotify();
		initInput();
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
			currentState.update();
			
			prepareGameImage();
			
			currentState.render(gameImage.getGraphics());
			
			repaint(); // calls default paintComponent(Graphics g) of Component  := JPanel
			try {
				Thread.sleep(14);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.exit(0);
	}

	private void prepareGameImage() {
		if(gameImage == null){
			gameImage = createImage(gameWidth,gameHeight);
		}
		Graphics g = gameImage.getGraphics();
		g.clearRect(0, 0, gameWidth, gameHeight);
		
	}
	
	public void exit(){
		running = false;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if(gameImage == null){
			return;
		}
		g.drawImage(gameImage, 0, 0, null);
	}
	
	
	private void initInput(){
		inputHandler = new InputHandler();
		addKeyListener(inputHandler);
		addMouseListener(inputHandler);		
	}
	
	
}
