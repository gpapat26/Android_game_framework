package com.jamescho.game.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.GameMain;
import com.jamescho.game.main.Resources;
import com.jamescho.game.model.Paddle;

public class PlayState extends State {
	
	private Paddle paddleLeft , paddleRight;
	
	private static final int PADDLE_WIDTH = 15;
	
	private static final int PADDLE_HEIGHT = 60;
	
	

	@Override
	public void init() {
		paddleLeft = new Paddle(0, 195, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddleRight = new Paddle(785, 195, PADDLE_WIDTH, PADDLE_HEIGHT);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Resources.darkBlue);
		g.fillRect(0, 0, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT);
		g.setColor(Resources.darkRed);
		g.fillRect(GameMain.GAME_WIDTH/2, 0, GameMain.GAME_WIDTH/2, GameMain.GAME_HEIGHT);
		g.drawImage(Resources.line,  (GameMain.GAME_WIDTH/2) -2 , 0, null);
		
		//Draw paddles
		g.setColor(Color.WHITE);
		g.fillRect(paddleLeft.getX(), paddleLeft.getY(), paddleLeft.getWidth(), paddleLeft.getHeight());
		g.fillRect(paddleRight.getX(), paddleRight.getY(), paddleRight.getWidth(), paddleRight.getHeight());

	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKeyPress(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
