package com.shelydexter;

/*
Given an array of integers, find the maximal absolute difference between any
two of its adjacent elements.

Example:
For `inputArray = [2, 4, 1, 0]`, the output should be
`arrayMaximalAdjacentDifference(inputArray) = 3`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.integer inputArray
    Guaranteed constraints:
    `3 ≤ inputArray.length ≤ 10`,
    `-15 ≤ inputArray[i] ≤ 15`.
-[output] integer
    - The maximal absolute difference
 */

import java.util.Arrays;

public class ArrayMaximalAdjacentDifference {

    public static void main(String[] args) {
        test(new int[] {2, 4, 1, 0}, 3, true);
        test(new int[] {1, 1, 1, 1}, 0, true);
        test(new int[] {-1, 4, 10, 3, -2}, 7, true);
        test(new int[] {10, 11, 13}, 2, true);
        test(new int[] {-2, -2, -2, -2, -2}, 0, true);
        test(new int[] {-1, 1, -3, -4}, 4, true);
    }

    // My answer
    private static int arrayMaximalAdjacentDifference(int[] inputArray) {
        int maxDiff = 0;
        for (int i = 1; i < inputArray.length; i++) {
            int currentDiff = Math.abs(inputArray[i] - inputArray[i-1]);
            if (currentDiff > maxDiff) maxDiff = currentDiff;
        }
        return maxDiff;
    }

    // Test method
    private static boolean test(int[] inputArray, int expected, boolean verbose) {
        int result = arrayMaximalAdjacentDifference(inputArray);
        if (verbose) {
            System.out.println("Input: inputArray = " + Arrays.toString(inputArray) +
                    "\nOutput: " + result +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (result == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
