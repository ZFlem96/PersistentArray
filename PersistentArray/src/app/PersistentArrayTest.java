package app;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class PersistentArrayTest {

	@Test
	public void test() {
		int testLength = 10;
		PersistentArray.initialize("test.bin", testLength, -1);
		PersistentArray array = new PersistentArray("test.bin");
		for (int x = 0; x < testLength; x++) {
			assertEquals(array.get(x),-1);
		}
		Random rand = new Random();
		long value;
		long[] longArray = new long[testLength]; 
		for (int x = 0; x < testLength; x++) {
			value = rand.nextLong();
			longArray[x] = value;
			array.set(x, value);
			
		}
		for (int x = 0; x < testLength; x++) {
			assertEquals(array.get(x),longArray[x]);
		}
		array.close();
		 PersistentArray.delete("test.bin");
	}

}
