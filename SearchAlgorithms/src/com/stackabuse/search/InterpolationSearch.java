package com.stackabuse.search;

import java.util.Arrays;

public class InterpolationSearch {
	
	private static int search(int[] integers, int elementToSearch) {
        
		int startIndex = 0;
		int lastIndex = (integers.length - 1); 
       
        while ((startIndex <= lastIndex) && (elementToSearch >= integers[startIndex]) && (elementToSearch <= integers[lastIndex])) 
        { 
        	//using interpolation formulae to find the best probable position for this element to exist
            int pos = startIndex + (((lastIndex-startIndex) / 
                  (integers[lastIndex]-integers[startIndex]))*(elementToSearch - integers[startIndex])); 
       
            if (integers[pos] == elementToSearch) 
                return pos; 
       
            if (integers[pos] < elementToSearch) 
                startIndex = pos + 1; 
       
            else
                lastIndex = pos - 1; 
        } 
        return -1; 
	}

	public static void main(String[] args) {

		int[] integers = {1,2,3,4,5,6,8,10,11,13};
		
		Arrays.sort(integers);
		
		System.out.println(Arrays.toString(integers));
		
		int elementToSearch = 4;
		int index = InterpolationSearch.search(integers, elementToSearch);
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

