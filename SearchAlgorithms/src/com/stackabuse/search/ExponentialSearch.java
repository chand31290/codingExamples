package com.stackabuse.search;

import java.util.Arrays;

public class ExponentialSearch {

	private static int search(int[] integers, int elementToSearch) {

		if (integers[0] == elementToSearch)
			return 0;
		if (integers[integers.length - 1] == elementToSearch)
			return integers.length;

		int range = 1;

		while (range < integers.length && integers[range] <= elementToSearch) {
			range = range * 2;
		}

		return Arrays.binarySearch(integers, range / 2, Math.min(range, integers.length), elementToSearch);

	}

	public static void main(String[] args) {

		int[] integers = { 89, 57, 91, 47, 95, 3, 27, 22, 67, 99 };

		Arrays.sort(integers);

		System.out.println(Arrays.toString(integers));

		int elementToSearch = 67;
		int index = ExponentialSearch.search(integers, elementToSearch);
		print(elementToSearch, index);

	}

	private static void print(int elementToSearch, int index) {
		if (index == -1) {
			System.out.println(elementToSearch + " not found.");
		} else {
			System.out.println(elementToSearch + " found at Index " + index);
		}
	}

}
