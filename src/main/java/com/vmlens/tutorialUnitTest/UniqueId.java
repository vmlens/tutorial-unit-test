package com.vmlens.tutorialUnitTest;

public class UniqueId {

	// Using a normal fields leads to data races
	// see reportNonVolatileField for the test result
	private long counter = 0;
	
	
	// using a volatile field fixes the data races but leads
	// to duplicate values. see reportVolatileField for the test result
	//private volatile long counter = 0;

	public  long nextId() {
		long c = counter;
		c++;
		counter = c;
		return c;	
	}
	
	
	// A correct solution with a synchronized block.
	// see reportSynchronized for the test result
	//	private final Object LOCK = new Object();
	//	public  long nextId() {
	//		synchronized(LOCK)
	//		{
	//			long c = counter;
	//			c++;
	//			counter = c;
	//			return c;	
	//		}	
	//	}
	
	
	
}
