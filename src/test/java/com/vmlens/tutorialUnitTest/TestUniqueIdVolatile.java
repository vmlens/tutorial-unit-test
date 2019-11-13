package com.vmlens.tutorialUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import com.vmlens.api.AllInterleavings;

public class TestUniqueIdVolatile {
 long firstId;
 long secondId;
 @Test
 public void testUniqueId() throws InterruptedException {
  try (AllInterleavings allInterleavings = 
    new AllInterleavings("TestUniqueIdVolatile");) {
    while (allInterleavings.hasNext()) {
		firstId  = 0L;
		secondId = 0L;
		UniqueIdVolatile uniqueId = new UniqueIdVolatile();
		Thread first = new Thread(() -> {
			firstId = uniqueId.nextId();
		});
		first.start();
		secondId = uniqueId.nextId();
		first.join();
		assertTrue(firstId != secondId);
    }
  }
 }
}
