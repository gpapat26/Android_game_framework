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
	public void addNotify(){//(2)
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
		long updateDurationMillis = 0;
		long sleepDurationMillis = 0;
		
		while(running){
			
			long beforUpdateRender = System.nanoTime();
			long deltaMilis = updateDurationMillis+sleepDurationMillis;
			
			updateAndRender(deltaMilis);
			
			updateDurationMillis = (System.nanoTime() - beforUpdateRender)/1000000L; 
			sleepDurationMillis = Math.max(2, 17 - updateDurationMillis);
			
		
			try {
				Thread.sleep(sleepDurationMillis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.exit(0);
	}

	private void updateAndRender(long deltaMilis) {
		currentState.update(deltaMilis/1000F);			
		prepareGameImage();
		currentState.render(gameImage.getGraphics());
		repaint(); // calls default paintComponent(Graphics g) of Component  := JPanel
		//renderGameImage(getGraphics());
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
		g.dispose();
	}
	
	private void renderGameImage(Graphics g){
		if(gameImage != null){
			g.drawImage(gameImage, 0, 0, null);
		}
		g.dispose();
		
	}
	
	
	private void initInput(){
		inputHandler = new InputHandler();
		addKeyListener(inputHandler);
		addMouseListener(inputHandler);		
	}
	
	
}
