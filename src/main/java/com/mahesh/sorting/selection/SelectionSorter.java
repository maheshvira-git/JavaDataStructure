package com.mahesh.sorting.selection;

import java.util.Arrays;

public class SelectionSorter {

	public static void main(String[] args) {
		int[] data = { 8, 7, 6, 4, 2 };
		new SelectionSorter().sort(data);
		System.out.println(Arrays.toString(data));
	}

	public void sort(int[] data) {

		for (int i = 0; i < data.length; i++) {
			
			int minAtIndex = i;
			
			for (int j = i; j < data.length; j++) {

				if (data[j] < data[minAtIndex]) {
					minAtIndex = j;
				}
			}
			
			int tmp = data[i];
			data[i] = data[minAtIndex];
			data[minAtIndex] = tmp;
		}
	}

}
