package com.vmlens.tutorialUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConcurrencyTestUniqueId {

	UniqueId uniqueId = new UniqueId();
	
	long firstId;
	long secondId;
	
	
	@Test
	public void testUniqueId() throws InterruptedException {
		// Use two threads to call the method under test.
		Thread first = new Thread( () ->    { firstId  = uniqueId.nextId();  } ) ;
		Thread second = new Thread( () ->   { secondId = uniqueId.nextId();  } ) ;
		// start the threads
		first.start();
		second.start();
		// Wait till both threads stopped
		first.join();
		second.join();	
		// check the result
		assertTrue(  firstId != secondId );
	}

}
