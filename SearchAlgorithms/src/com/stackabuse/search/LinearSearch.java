package com.stackabuse.search;

public class LinearSearch {

	public static int search(int arr[], int elementToSearch) {

		for (int index = 0; index < arr.length; index++) {
			if (arr[index] == elementToSearch)
				return index;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] integers = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99};
		
		int elementToSearch = 67;
		int index = LinearSearch.search(integers, elementToSearch);
		print(elementToSearch, index);		
		
	}

	private static void print(int elementToSearch, int index) {
		if(index == -1)
		{
			System.out.println(elementToSearch+" not found.");
		}
		else
		{
			System.out.println(elementToSearch+" found at position "+index);
		}
	}
	
}
