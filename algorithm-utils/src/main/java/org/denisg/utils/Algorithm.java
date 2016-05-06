package org.denisg.utils;

import java.util.BitSet;

public class Algorithm {

	/**
	 * Finds index of <code>n</code> in <code>array</code>.
	 * 
	 * @param array - the array
	 * @param n - the number to find
	 * @return index of <code>n</code> in <code>array</code>, or <code>-1</code> if not found.
	 */
	public static int binarySearch(int[] array, int n) {
		if (array == null) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		int index = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] == n) {
				index = mid;
				break;
			} else if (array[mid] > n) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return index;
	}
	
	/**
	 * Check if <code>n</code> is prime.
	 * 
	 * @param n - number to check
	 * @return <code>true</code> if prime, <code>false</code> otherwise
	 */
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		} else if (n <= 3) {
			return true;
		} else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		long i = 5;
		while (i * i <= n) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
			i += 6;
		}
		return true;
	}
	
	/**
	 * Generate primes which are not greater than number <code>maxN</code>
	 * 
	 * @param maxN - limit for prime generation 
	 * @return <code>BitSet</code> of numbers where <code>true</code> at index <code>i</code> 
	 * means the number <code>i</code> is prime 
	 */
	public static BitSet generatePrimes(int maxN) {
		BitSet primes = new BitSet(maxN + 1);
		primes.set(2, maxN);
		long n = 0;
		while ((n = primes.nextSetBit((int) n + 1)) != -1 && n < (long) Math.sqrt(maxN) + 1) {
			for (long i = n * n; i <= maxN; i += n) {
				primes.clear((int) i);
			}
		}
		return primes;
	}
	
	/**
	 * Generate factorials modulo <code>mod</code>
	 * 
	 * @param maxN - number of factorials
	 * @param mod - modulo
	 * @return - int array of factorials
	 */
	public static int[] generateFactorials(int maxN, int mod) {
		int[] factorials = new int[maxN + 1];
		factorials[1] = 1;
		for (int i = 2; i <= maxN; i++) {
			long f = factorials[i - 1];
			f *= i;
			f %= mod;
			factorials[i] = (int) f;
		}
		return factorials;
	}
}
