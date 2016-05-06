package org.denisg.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
	private BufferedReader in;
	private String[] input = new String[0];
	private int index = 0;

	public InputReader() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public String next() throws IOException {
		if (index >= input.length) {
			input = in.readLine().split("\\s");
			index = 0;
		}
		return input[index++];
	}

	public int nextInt() throws NumberFormatException, IOException {
		return Integer.valueOf(next());
	}

	public long nextLong() throws NumberFormatException, IOException {
		return Long.valueOf(next());
	}
	
	public int[] nextIntArray(int n) throws NumberFormatException, IOException {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = nextInt();
		}
		return array;
	}
	
	public long[] nextLongArray(int n) throws NumberFormatException, IOException {
		long[] array = new long[n];
		for (int i = 0; i < n; i++) {
			array[i] = nextLong();
		}
		return array;
	}
	
	public int[][] nextIntMatrix(int m, int n) throws NumberFormatException, IOException {
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = nextInt();
			}
		}
		return matrix;
	}
	
	public void close() throws IOException {
		in.close();
	}
}