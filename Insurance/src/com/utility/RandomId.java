package com.utility;

import java.util.Random;

public class RandomId {
	
	public static int getRandomId() {
		Random random = new Random();
		int randomNumber = random.nextInt();
		int rId = randomNumber < 0 ? randomNumber*-1 : randomNumber;
		return rId;
	}
}
