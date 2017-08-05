package week3;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class UniqueTripletsOptimized {
	public static void main(String[] args) {
		int array[] = { -1, 0, 2, 1, -1, 1, 5, -2 };
		int sum = 0;
		Arrays.sort(array);
		HashSet<List<Integer>> result = triplets(array, sum);
		System.out.println(result);
	}

	private static HashSet<List<Integer>> triplets(int[] array, int sum) {
		HashSet<List<Integer>> resultset = new HashSet<List<Integer>>();
		// test case1: when array has less than 3 elements
		if (array.length < 3)
			return null;
		// test case 2: if the first element is greater than the sum then
		// no 3 integers in the array can add up to give the sum
		if (array[0] > sum)
			return null;
		// two pointers- one running from left to right(pleft) and another
		// running from right to left(pright)
		int pright = array.length - 1;
		for (int i = 0; i < array.length - 2; i++) {
			int pleft = i + 1;
			while (pleft < pright) {
				if ((array[i] + array[pleft] + array[pright]) == sum) {
					List<Integer> tripletList = new ArrayList<Integer>();
					tripletList.add(array[i]);
					tripletList.add(array[pleft]);
					tripletList.add(array[pright]);
					resultset.add(tripletList);
					break;
				}
				if ((array[i] + array[pleft] + array[pright]) > sum) {
					pright--;
				}
				if ((array[i] + array[pleft] + array[pright]) < sum) {
					pleft++;
				}
			}
		}
		return resultset;
	}
}
