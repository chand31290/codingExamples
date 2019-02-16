package com.stackabuse.search;

import java.util.Arrays;

public class BinarySearch {
	public static int search(int arr[], int elementToSearch) {
		
		int firstIndex = 0;
		int lastIndex = arr.length - 1;
		
		while(firstIndex <=lastIndex)
		{
			int middleIndex = (firstIndex + lastIndex) / 2;
			if(arr[middleIndex] == elementToSearch)
			{
				return middleIndex;
			}
			else if(arr[middleIndex] < elementToSearch)
			{
				firstIndex = middleIndex + 1;
			}
			else if(arr[middleIndex] > elementToSearch)
			{
				lastIndex = middleIndex - 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {

		int[] integers = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99};
		
		Arrays.sort(integers);
		
		System.out.println(Arrays.toString(integers));
		
		int elementToSearch = 67;
		int index = BinarySearch.search(integers, elementToSearch);
		print(elementToSearch, index);		
		
	
	}
	
	private static void print(int elementToSearch, int index) {
		if(index == -1)
		{
			System.out.println(elementToSearch+" not found.");
		}
		else
		{
			System.out.println(elementToSearch+" found at Index "+index);
		}
	}
}
