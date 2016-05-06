import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.BitSet;

import org.denisg.utils.Algorithm;
import org.junit.Test;

public class AlgorithmTest {

	@Test
	public void testBinarySearch() {
		assertEquals(-1, Algorithm.binarySearch(new int[] {}, 1));
		
		assertEquals(-1, Algorithm.binarySearch(null, 1));
		
		assertEquals(-1, Algorithm.binarySearch(new int[] {1}, 0));
		assertEquals(0, Algorithm.binarySearch(new int[] {1}, 1));
		assertEquals(-1, Algorithm.binarySearch(new int[] {1}, 2));
		
		assertEquals(-1, Algorithm.binarySearch(new int[] {1, 2, 3}, 0));
		assertEquals(0, Algorithm.binarySearch(new int[] {1, 2, 3}, 1));
		assertEquals(1, Algorithm.binarySearch(new int[] {1, 2, 3}, 2));
		assertEquals(2, Algorithm.binarySearch(new int[] {1, 2, 3}, 3));
		assertEquals(-1, Algorithm.binarySearch(new int[] {1, 2, 3}, 4));
		
		assertEquals(-1, Algorithm.binarySearch(new int[] {1, 3, 5}, 0));
		assertEquals(0, Algorithm.binarySearch(new int[] {1, 3, 5}, 1));
		assertEquals(-1, Algorithm.binarySearch(new int[] {1, 3, 5}, 2));
		assertEquals(1, Algorithm.binarySearch(new int[] {1, 3, 5}, 3));
		assertEquals(-1, Algorithm.binarySearch(new int[] {1, 3, 5}, 4));
		assertEquals(2, Algorithm.binarySearch(new int[] {1, 3, 5}, 5));
		assertEquals(-1, Algorithm.binarySearch(new int[] {1, 3, 5}, 10));

	}
	
	@Test
	public void testIsPrime() {
		assertTrue(Algorithm.isPrime(2));
		assertTrue(Algorithm.isPrime(3));
		assertTrue(Algorithm.isPrime(5));
		assertTrue(Algorithm.isPrime(7));
		assertTrue(Algorithm.isPrime(11));
		assertTrue(Algorithm.isPrime(13));
		assertTrue(Algorithm.isPrime(17));
		assertTrue(Algorithm.isPrime(19));
		assertTrue(Algorithm.isPrime(1000000007));
		
		assertFalse(Algorithm.isPrime(-17));
		assertFalse(Algorithm.isPrime(-1));
		assertFalse(Algorithm.isPrime(0));
		assertFalse(Algorithm.isPrime(1));
		assertFalse(Algorithm.isPrime(4));
		assertFalse(Algorithm.isPrime(2020202020));
	}

	@Test(timeout=1000)
	public void testGeneratePrimes() {
		final int maxN = 1000000; 
		BitSet primes = Algorithm.generatePrimes(maxN);
		for (int i = 0; i <= maxN; i++) {
			assertEquals(Algorithm.isPrime(i), primes.get(i));
		}
	}
	
	@Test(timeout=1000)
	public void testGenerateFactorials() {
		int[] factorials = Algorithm.generateFactorials(10, 1000000007);
		assertEquals(1, factorials[1]);
		assertEquals(2, factorials[2]);
		assertEquals(6, factorials[3]);
		assertEquals(24, factorials[4]);
		assertEquals(120, factorials[5]);
		assertEquals(720, factorials[6]);
		assertEquals(5040, factorials[7]);
		assertEquals(40320, factorials[8]);
		assertEquals(362880, factorials[9]);
		assertEquals(3628800, factorials[10]);
	}
	
	@Test(timeout=1000)
	public void testGenerateFactorialsSmallModulo() {
		final int maxN = 1009;
		int[] factorials = Algorithm.generateFactorials(10, maxN);
		assertEquals(1 % maxN, factorials[1]);
		assertEquals(2 % maxN, factorials[2]);
		assertEquals(6 % maxN, factorials[3]);
		assertEquals(24 % maxN, factorials[4]);
		assertEquals(120 % maxN, factorials[5]);
		assertEquals(720 % maxN, factorials[6]);
		assertEquals(5040 % maxN, factorials[7]);
		assertEquals(40320 % maxN, factorials[8]);
		assertEquals(362880 % maxN, factorials[9]);
		assertEquals(3628800 % maxN, factorials[10]);
	}
	
	@Test(timeout=1000)
	public void testGenerateFactorialsBig() {
		Algorithm.generateFactorials(10000000, 1000000007);
	}

}
