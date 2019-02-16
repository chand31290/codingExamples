package com.stackabuse.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KnuthMorrisPrathPatternSearch {

	private static List<Integer> performKMPSearch(String text, String pattern) {
		int[] compliedPatternArray = compilePatternArray(pattern);

		int textIndex = 0;
		int patternIndex = 0;

		List<Integer> foundIndexes = new ArrayList<>();

		while (textIndex < text.length()) {
			if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
				patternIndex++;
				textIndex++;
			}
			if (patternIndex == pattern.length()) {
				foundIndexes.add(textIndex - patternIndex);
				patternIndex = compliedPatternArray[patternIndex - 1];
			}

			else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
				if (patternIndex != 0)
					patternIndex = compliedPatternArray[patternIndex - 1];
				else
					textIndex = textIndex + 1;
			}
		}
		return foundIndexes;
	}

	private static int[] compilePatternArray(String pattern) {
		int patternLength = pattern.length();
		int len = 0;
		int i = 1;
		int[] compliedPatternArray = new int[patternLength];
		compliedPatternArray[0] = 0;

		while (i < patternLength) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				compliedPatternArray[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = compliedPatternArray[len - 1];
				} else {
					compliedPatternArray[i] = len;
					i++;
				}
			}
		}
		System.out.println("Compiled Pattern Array " + Arrays.toString(compliedPatternArray));
		return compliedPatternArray;
	}

	public static void main(String[] args) {

		String pattern = "AAABAAA";
		String text = "ASBNSAAAAAABAAAAABAAAAAGAHUHDJKDDKSHAAJF";

		List<Integer> foundIndexes = KnuthMorrisPrathPatternSearch.performKMPSearch(text, pattern);

		if (foundIndexes.isEmpty()) {
			System.out.println("Pattern not found in the given text String");
		} else {
			System.out.println("Pattern found in the given text String at positions :"
					+ foundIndexes.stream().map(Object::toString).collect(Collectors.joining(", ")));
		}

	}
}
