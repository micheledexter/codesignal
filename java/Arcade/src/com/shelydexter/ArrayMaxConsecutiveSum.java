package com.shelydexter;

/*
Given array of integers, find the maximal possible sum of its `k` consecutive
elements.

Example:
For `inputArray = [2, 3, 5, 1, 6]` and `k = 2`, the output should be
`arrayMaxConsecutiveSum(inputArray, k) = 8`.
All possible sums of `2` consecutive elements are:
* `2 + 3 = 5`;
* `3 + 5 = 8`;
* `5 + 1 = 6`;
* `1 + 6 = 7`.
Thus, the answer is `8`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.integer inputArray
    Array of positive integers.
    Guaranteed constraints:
    `3 ≤ inputArray.length ≤ 10^5`,
    `1 ≤ inputArray[i] ≤ 1000`.
- [input] integer k
    An integer (not greater than the length of `inputArray`).
    Guaranteed constraints:
    `1 ≤ k ≤ inputArray.length`.
- [output] integer
    - The maximal possible sum.
 */

import java.util.Arrays;

public class ArrayMaxConsecutiveSum {

    public static void main(String[] args) {
        test(new int[] {2, 3, 5, 1, 6}, 2, 8);
        test(new int[] {2, 4, 10, 1}, 2, 14);
        test(new int[] {1, 3, 2, 4}, 3, 9);
        test(new int[] {3, 2, 1, 1}, 1, 3);
    }

    // My answer
    private static int arrayMaxConsecutiveSum(int[] inputArray, int k) {
        if (k == inputArray.length) {
            int counter = 0;
            for (int item: inputArray) {
                counter += item;
            }
            return counter;
        }
        int highest = 0;
        for (int i = 0; i < inputArray.length - (k-1); i++) {
            int counter = 0;
            for (int j = i; j < i+k; j++) {
                counter += inputArray[j];
            }
            if (counter > highest) highest = counter;
        }
        return highest;
    }

    // Test methods
    private static boolean test(int[] inputArray, int k, int expected, boolean verbose) {
        int output = arrayMaxConsecutiveSum(inputArray, k);
        if (verbose) {
            System.out.println("Input: inputArray = " + Arrays.toString(inputArray) + "; k = " + k +
                    "\nOutput: " + output +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (output == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static boolean test(int[] inputArray, int k, int expected) {
        return test(inputArray, k, expected, true);
    }
}
