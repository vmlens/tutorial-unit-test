package com.vmlens.tutorialUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConcurrencyTestUniqueId {

	UniqueId uniqueId = new UniqueId();
	
	long firstId;
	long secondId;
	
	
	@Test
	public void testUniqueId() throws InterruptedException {
		
		Thread first = new Thread( () ->    { firstId  = uniqueId.nextId();  } ) ;
		Thread second = new Thread( () ->   { secondId = uniqueId.nextId();  } ) ;
		first.start();
		second.start();
		first.join();
		second.join();
		
		assertTrue(  firstId != secondId );
	}

}
