package com.stackabuse.search;

import java.util.Arrays;

public class FibonacciSearch {
	
	private static int search(int[] integers, int elementToSearch) {

        int smallestFibonacciNumber = 0; 
        int middleFibonacciNumber = 1;  
        int largestFibonacciNumber = smallestFibonacciNumber + middleFibonacciNumber;  
        int arrayLength = integers.length; 
  
        while (largestFibonacciNumber < arrayLength) 
        { 
            smallestFibonacciNumber = middleFibonacciNumber; 
            middleFibonacciNumber = largestFibonacciNumber; 
            largestFibonacciNumber = smallestFibonacciNumber + middleFibonacciNumber; 
        } 
  
        int offset = -1; 
  
        while (largestFibonacciNumber > 1) 
        { 
            int i = Math.min(offset+smallestFibonacciNumber, arrayLength-1); 
  
            if (integers[i] < elementToSearch) 
            { 
                largestFibonacciNumber = middleFibonacciNumber; 
                middleFibonacciNumber = smallestFibonacciNumber; 
                smallestFibonacciNumber = largestFibonacciNumber - middleFibonacciNumber; 
                offset = i; 
            } 
  
            else if (integers[i] > elementToSearch) 
            { 
            	largestFibonacciNumber = smallestFibonacciNumber; 
                middleFibonacciNumber = middleFibonacciNumber - smallestFibonacciNumber; 
                smallestFibonacciNumber = largestFibonacciNumber - middleFibonacciNumber; 
            } 
  
            else return i; 
        } 
  
        if(middleFibonacciNumber == 1 && integers[offset+1] == elementToSearch) 
            return offset+1; 
  
        return -1; 
    }

	public static void main(String[] args) {

		int[] integers = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99};
		
		Arrays.sort(integers);
		
		System.out.println(Arrays.toString(integers));
		
		int elementToSearch = 22;
		int index = FibonacciSearch.search(integers, elementToSearch);
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
