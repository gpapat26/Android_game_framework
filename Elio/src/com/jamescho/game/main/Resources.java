package com.jamescho.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Resources {
	
	public static BufferedImage welcome , iconImage,block, cloud1,cloud2,duck,grass,jump,run1,run2,run3,run4,run5,selector;
	public static AudioClip hit,onjump;
	
	public static void load(){
		 welcome = loadImage("welcome.png");
		 iconImage = loadImage("iconimage.png");;
		 block = loadImage("block.png");
		 cloud1 = loadImage("cloud1.png");
		 cloud2 = loadImage("cloud2.png");
		 duck = loadImage("duck.png");
		 grass = loadImage("grass.png");
		 jump =loadImage("jump.png");
		 run1 = loadImage("run_anim1.png");
		 run2 = loadImage("run_anim2.png");
		 run3 = loadImage("run_anim3.png");
		 run4 = loadImage("run_anim4.png");
		 run5 = loadImage("run_anim5.png");
		 selector = loadImage("selector.png");
		 hit = loadSound("hit.wav");
		 onjump = loadSound("onjump.wav");
		 
	}
	
	
	private static AudioClip loadSound(String filename){
	URL fileURL = Resources.class.getResource("/resources/"+filename);	
	return Applet.newAudioClip(fileURL);
	}
	
	private static BufferedImage loadImage(String filename){
		BufferedImage img = null;
		try {
			img = ImageIO.read(Resources.class.getResourceAsStream("/resources/"+filename));
		} catch (IOException e) {
			System.out.println("Error while reading :"+filename);
			//e.printStackTrace();
		}
		return img;
	}

}
