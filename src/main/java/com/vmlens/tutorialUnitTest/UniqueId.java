package com.vmlens.tutorialUnitTest;

public class UniqueId {
	private long counter = 0;
	public  long nextId() {
		return counter++;	
	}	
}
