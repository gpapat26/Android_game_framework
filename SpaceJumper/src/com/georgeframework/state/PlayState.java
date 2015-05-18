package com.georgeframework.state;

import java.util.ArrayList;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;

import com.georgeframework.model.Block;
import com.georgeframework.model.Cloud;
import com.georgeframework.model.Player;
import com.georgeframework.simpleandroidgdf.Assets;
import com.georgeframework.simpleandroidgdf.GameMainActivity;
import com.georgegramework.util.Painter;

public class PlayState extends State {

	
	private Player player;
	private ArrayList<Block> blocks;
	private Cloud cloud , cloud2;
	
	private int playerScore = 0;
	 
	private static final int BLOCK_HEIGHT = 50;
	private static final int BLOCK_WIDTH = 20;
	private int blockSpeed = -200;
	private int recentTouchY;
	
	private static final int PLAYER_WIDTH = 66;
	private static final int PLAYER_HEIGHT = 92;
	
	
	
	@Override
	public void init() {
													// 450 - edafos - paixths
		player = new Player(160, GameMainActivity.GAME_HEIGHT-45-PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		blocks = new ArrayList<Block>();
		cloud = new Cloud(100, 100);
		cloud2 = new Cloud(500, 50);
		
		for(int i = 0;i<5;i++){
			Block b = new Block(i*200,GameMainActivity.GAME_HEIGHT-95,BLOCK_WIDTH,BLOCK_HEIGHT);
			blocks.add(b);
		}
		
	}

	@Override
	public void update(float delta) {
		if(!player.isAlive()){
			setCurrentState(new GameOverState(playerScore/100));
		}
		
		playerScore +=1;
		
		if(playerScore % 500 == 0 && blockSpeed > -280){
			blockSpeed -=10;
		}
		
		cloud.update(delta);
		cloud2.update(delta);
		Assets.runAnimation.update(delta);
		player.update(delta);
		updateBlocks(delta);

	}

	private void updateBlocks(float delta) {
		for (Block block : blocks) {
			block.update(delta, blockSpeed);
			
			if(block.isVisible()){
				if(player.isDucked() && Rect.intersects(block.getRect(), player.getDuckRect())){
					block.onCollide(player);
					
				}
				else if(!player.isDucked() && Rect.intersects(block.getRect(), player.getRect())){
					block.onCollide(player);
				}
			}
		}
		
	}
	
	

	@Override
	public void render(Painter g) {
			g.setColor(Color.rgb(208, 244, 247));
			g.fillRect(0, 0, GameMainActivity.GAME_WIDTH, GameMainActivity.GAME_HEIGHT);
			
			renderPlayer(g);
			renderBlocks(g);
			renderSun(g);
			renderClouds(g);
			g.drawImage(Assets.grass, 0, 405);
			renderScore(g);

	}

	private void renderScore(Painter g) {
		//playerScore
		g.setColor(Color.GREEN);
		g.setFont(Typeface.SANS_SERIF, 25);
		g.drawString("Score: " +playerScore/100, 20, 30);
		
	}

	private void renderClouds(Painter g) {
		cloud.render(g, Assets.cloud1);
		cloud2.render(g, Assets.cloud2);
		
	}

	private void renderSun(Painter g) {
		g.setColor(Color.rgb(255, 165, 0));
		g.fillOval(715, -85, 170, 170);
		g.setColor(Color.YELLOW);
		g.fillOval(725, -75, 150, 150);
		
	}

	private void renderBlocks(Painter g) {
		for (Block block : blocks) {
			block.render(g);
		}
		
	}

//	private void renderPlayer(Painter g) {
//		if(player.isGrounded){
//			if(player.isDucked()){
//				g.drawImage(Assets.duck,(int)player.getX(),(int)player.getY());
//			}
//			else{
//				Assets.runAnimation.render(g, (int)player.getX(), (int)player.getVelY(),player.getWidth(),player.getHeight());
//			}
//		}else{
//			//player.render(Assets.jump, g);
//			g.drawImage(Assets.jump,(int)player.getX(),(int)player.getY(),player.getWidth(),player.getHeight());
//
//		}
//		
//		
//	}
	

	private void renderPlayer(Painter g) {
		if (player.isGrounded()) {
			if (player.isDucked()) {
				g.drawImage(Assets.duck, (int) player.getX(),
						(int) player.getY());
			} else {
				Assets.runAnimation.render(g, (int) player.getX(),
						(int) player.getY(), player.getWidth(),
						player.getHeight());
			}
		} else {
			g.drawImage(Assets.jump, (int) player.getX(), (int) player.getY(),
					player.getWidth(), player.getHeight());
		}
	}
	
//	private void renderPlayer(Painter g) {
//		if(player.isGrounded){
//			if(player.isDucked()){
//				player.render(Assets.duck,g);
//			}
//			else{
//				Assets.runAnimation.render(g, (int)player.getX(), (int)player.getVelY(),player.getWidth(),player.getHeight());
//			}
//		}else{
//			player.render(Assets.jump, g);
//
//		}
//		
//		
//	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {
		if(e.getAction() == MotionEvent.ACTION_DOWN){
			recentTouchY = scaledY;
		}
		else if(e.getAction() == MotionEvent.ACTION_UP){
			if(scaledY - recentTouchY < -50){
				player.jump();
			}else if(scaledY - recentTouchY > 50){
				player.duck();
			}
		}
		return true;
	}
}
