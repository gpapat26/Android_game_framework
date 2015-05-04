package com.jamescho.game.state;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.jamescho.game.main.GameMain;
import com.jamescho.game.main.Resources;
import com.jamescho.game.model.Block;
import com.jamescho.game.model.Cloud;
import com.jamescho.game.model.Player;

public class PlayState extends State {

	
	private Player player;
	private ArrayList<Block> blocks;
	private Cloud cloud, cloud2;
	private Font scoreFont;
	private int playerScore = 0;
	
	private static final int BLOCK_HEIGHT = 50;
	private static final int BLOCK_WIDTH = 20;
	private int blockSpeed = -200;
	
	private static final int PLAYER_WIDTH = 66;
	private static final int PLAYER_HEIGHT = 92;
	
	
	
	
	@Override
	public void init() {
		player = new Player(160,GameMain.GAME_HEIGHT-45 - PLAYER_HEIGHT ,PLAYER_WIDTH,PLAYER_HEIGHT);
		blocks = new ArrayList<Block>();
		cloud = new Cloud(100,100);
		cloud2 = new Cloud(500,50);
		scoreFont = new Font("SansSerif",Font.BOLD,25);
		
		for(int i =0; i< 5;i++){
			Block b = new Block(i*200,GameMain.GAME_HEIGHT-95,BLOCK_WIDTH,BLOCK_HEIGHT);
			blocks.add(b);
		}
		
		

	}

	@Override
	public void update(float delta) {
		if(!player.isAlive()){
			setCurrentState(new GameOverState(playerScore/100 +""));
		}
		playerScore +=1;
		if(playerScore % 500 == 0 && blockSpeed > -280){
			blockSpeed -=10;
		}
		
		cloud.update(delta);
		cloud2.update(delta);
		Resources.runAnim.update(delta);
		player.update(delta);
		updateBlocks(delta);

	}

	private void updateBlocks(float delta) {
		for (Block b : blocks){
			b.update(delta, blockSpeed);
			if(b.isVisible()){
				if(player.isDucked()&&b.getRect().intersects(player.getDuckRect())){
					b.onCollide(player);
				}else if (!player.isDucked() && b.getRect().intersects(player.getRect())){
					b.onCollide(player);
				}
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKeyPress(KeyEvent e) {
		if(e.getKeyCode() ==KeyEvent.VK_SPACE){
			player.jump();
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			player.duck();
		}

	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
