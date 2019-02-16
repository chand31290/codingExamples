package com.stackabuse.search;

import java.util.Arrays;

public class JumpSearch {

	private static int search(int[] integers, int elementToSearch) {

		int arrayLength = integers.length;
		int jumpStep = (int) Math.sqrt(integers.length);
		int previousStep = 0;

		while (integers[Math.min(jumpStep, arrayLength) - 1] < elementToSearch) {
			previousStep = jumpStep;
			jumpStep += (int)(Math.sqrt(arrayLength));
			if (previousStep >= arrayLength)
				return -1;
		}
		while (integers[previousStep] < elementToSearch) {
			previousStep++;

			if (previousStep == Math.min(jumpStep, arrayLength))
				return -1;
		}

		if (integers[previousStep] == elementToSearch)
			return previousStep;

		return -1;
	}

	public static void main(String[] args) {

		int[] integers = { 89, 57, 91, 47, 95, 3, 27, 22, 67, 99 };

		Arrays.sort(integers);

		System.out.println(Arrays.toString(integers));

		int elementToSearch = 100;
		int index = JumpSearch.search(integers, elementToSearch);
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
