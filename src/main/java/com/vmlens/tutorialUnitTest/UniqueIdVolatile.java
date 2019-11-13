package com.vmlens.tutorialUnitTest;

public class UniqueIdVolatile {
	private volatile long counter = 0;
	public  long nextId() {
		return counter++;	
	}	
}
