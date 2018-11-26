package com.shelydexter;

/*
Given array of integers, remove each `kth` element from it.

Example:
For `inputArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]` and `k = 3`, the output
should be `extractEachKth(inputArray, k) = [1, 2, 4, 5, 7, 8, 10]`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.integer inputArray
    Guaranteed constraints:
    `5 ≤ inputArray.length ≤ 15`,
    `-20 ≤ inputArray[i] ≤ 20`.
- [input] integer k
    Guaranteed constraints:
    `1 ≤ k ≤ 10`
- [output] array.integer
    - `inputArray` without elements `k - 1`, `2k - 1`, `3k -1` etc.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class ExtractEachKth {

    public static void main(String[] args) {
        test(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3, new int[] {1, 2, 4, 5, 7, 8, 10});
        test(new int[] {1, 1, 1, 1, 1}, 1, new int[] {});
        test(new int[] {1, 2, 1, 2, 1, 2, 1, 2}, 2, new int[] {1, 1, 1, 1});
        test(new int[] {1, 2, 1, 2, 1, 2, 1, 2}, 10, new int[] {1, 2, 1, 2, 1, 2, 1, 2});
        test(new int[] {2, 4, 6, 8, 10}, 2, new int[] {2, 6, 10});
    }

    // My answer
    private static int[] extractEachKth(int[] inputArray, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if ((i+1) % k != 0) list.add(inputArray[i]);
        }
        int[] output = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }

    // Test methods
    private static boolean test(int[] inputArray, int k, int[] expected, boolean verbose) {
        int[] output = extractEachKth(inputArray, k);
        if (verbose) {
            System.out.println("Input: inputArray = " + Arrays.toString(inputArray) + "; k = " + k +
                    "\nOutput: " + Arrays.toString(output) +
                    "\nExpected: " + Arrays.toString(expected));
            System.out.print("Result: ");
        }
        if (arraysAreEqual(output, expected)) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static boolean test(int[] inputArray, int k, int[] expected) {
        return test(inputArray, k, expected, true);
    }

    private static boolean arraysAreEqual(int[] first, int[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) return false;
        }
        return true;
    }
}
