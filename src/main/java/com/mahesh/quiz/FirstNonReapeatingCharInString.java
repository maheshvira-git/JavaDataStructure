/**
 * 
 */
package com.mahesh.quiz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * @author mahesh.vira
 *
 */
public class FirstNonReapeatingCharInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<Character, Integer> charCountMap = new LinkedHashMap<>();

		String s = "aabcdb";

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			charCountMap.computeIfPresent(c, (ch, ct) -> ++ct);

			charCountMap.computeIfAbsent(c, f -> 1);

		}

		Optional<Entry<Character, Integer>> findFirst = charCountMap.entrySet().stream().filter(v -> v.getValue() == 1)
				.findFirst();

		if (findFirst.isPresent()) {
			System.out.println(findFirst.get().getKey());
		}

	}

}
