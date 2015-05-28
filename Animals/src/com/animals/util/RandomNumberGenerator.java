package com.animals.util;

import java.util.Random;

public class RandomNumberGenerator {
	
	private static Random rand = new Random();
	
	public static int getRandIntBetween(int low, int high){
		return rand.nextInt(high - low)+low;
	}
	
	public static int getRandInt(int upperBound){
		return rand.nextInt(upperBound);
	}

}
