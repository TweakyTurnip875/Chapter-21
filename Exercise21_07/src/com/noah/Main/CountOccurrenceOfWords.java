package com.noah.Main;

import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		HashMap<String, Integer> map = new HashMap<>();
		
		

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		List<Map.Entry<String, Integer>> arr = new ArrayList<>(map.entrySet());

		System.out.println();
		// Display key and value for each entry
		
		arr.sort((e1, e2) -> {
			return e1.getValue().compareTo(e2.getValue());
		});
		
		System.out.println(arr);
		
	}
}