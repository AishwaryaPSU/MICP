package week2;

import java.util.HashSet;

public class LongestSubstrOptimized {

	public static void main(String[] args) {
		String inputStr = "hello,world";
		longestSubstr(inputStr);
	}

	private static void longestSubstr(String inputStr) {
		int count = 0;
		String longestSubStr = inputStr;
		int strLength = inputStr.length();
		int longestSubStrLength = 0;
		for (int i = 0; i < strLength; i++) {
			for (int j = strLength - 1; j >= i; j--) {
				count++;
				String subStr = inputStr.substring(i, j + 1);
				int tempSubStrLength = subStr.length();
				if (!isDuplicateOptimized(subStr) && tempSubStrLength > longestSubStrLength) {
					longestSubStrLength = tempSubStrLength;
					longestSubStr = subStr;
					break;
				}
			}
		}
		System.out.println(String.format("longest substring is '%s' and its length is %s, number of iterations is %s",
				longestSubStr, longestSubStrLength, count));
	}

	private static boolean isDuplicateOptimized(String inputStr) {
		HashSet<Character> uniqueSet = new HashSet<Character>();
		char[] array = inputStr.toCharArray();
		for (char a : array) {
			uniqueSet.add(a);
		}
		return uniqueSet.size() != inputStr.length();
	}

}
