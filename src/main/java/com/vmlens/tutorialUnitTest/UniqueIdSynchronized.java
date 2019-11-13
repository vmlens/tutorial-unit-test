package com.vmlens.tutorialUnitTest;

public class UniqueIdSynchronized {
	private long counter = 0;
	public  synchronized long nextId() {
		return counter++;	
	}	
}
