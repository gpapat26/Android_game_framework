package com.jamescho.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.jamescho.game.main.GameMain;
import com.jamescho.game.main.Resources;
import com.jamescho.game.model.Ball;
import com.jamescho.game.model.Paddle;

public class PlayState extends State {
	
	private Paddle paddleLeft , paddleRight;
	
	private static final int PADDLE_WIDTH = 15;
	
	private static final int PADDLE_HEIGHT = 60;
	
	private int playerScore = 0;
	
	private Font scoreFont;
	
	private Ball ball;
	
	private final int BALL_DIAMETER = 20;
	
	

	@Override
	public void init() {
		paddleLeft = new Paddle(0, 195, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddleRight = new Paddle(785, 195, PADDLE_WIDTH, PADDLE_HEIGHT);
		scoreFont = new Font("SansSerif",Font.BOLD,25);
		ball = new Ball(300, 200, BALL_DIAMETER, BALL_DIAMETER);
	}

	@Override
	public void update() {
		paddleLeft.update();
		paddleRight.update();
		ball.update();
		
		if(ballCollides(paddleLeft)){
			ball.onCollideWith(paddleLeft);
			playerScore++;
				Resources.hit.play();
		}
		else if(ballCollides(paddleRight)){
			ball.onCollideWith(paddleRight);
			playerScore++;
			Resources.hit.play();
		}
		if(ball.isDead()){
			playerScore -=3;
			ball.reset();
		}

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Resources.darkBlue);
		g.fillRect(0, 0, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT);
		g.setColor(Resources.darkRed);
		g.fillRect(GameMain.GAME_WIDTH/2, 0, GameMain.GAME_WIDTH/2, GameMain.GAME_HEIGHT);
		g.drawImage(Resources.line,  (GameMain.GAME_WIDTH/2) -2 , 0, null);
		
		g.setFont(scoreFont);
		g.drawString(Integer.toString(playerScore), 350, 40);
		
		//Draw paddles
		g.setColor(Color.WHITE);
		g.fillRect(paddleLeft.getX(), paddleLeft.getY(), paddleLeft.getWidth(), paddleLeft.getHeight());
		g.fillRect(paddleRight.getX(), paddleRight.getY(), paddleRight.getWidth(), paddleRight.getHeight());
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		
		
		
	}

	@Override
	public void onClick(MouseEvent e) {
		

	}

	@Override
	public void onKeyPress(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			paddleLeft.accelUp();
			paddleRight.accelDown();
			}
			else if(e.getKeyCode()==KeyEvent.VK_DOWN){
				paddleLeft. accelDown();
				paddleRight.accelUp();
			}
		

	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP ||e.getKeyCode()==KeyEvent.VK_DOWN ){
			paddleLeft.stop();
			paddleRight.stop();
		}

	}
	
	public boolean ballCollides(Paddle p){
		return ball.getRect().intersects(p.getRect());
	}

}
