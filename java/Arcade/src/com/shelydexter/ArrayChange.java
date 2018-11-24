package com.shelydexter;

/*
You are given an array of integers. On each move you are allowed to increase
exactly one of its elements by one. Find the minimal number of moves required
to obtain a strictly increasing sequence from the input.

Example:
For `inputArray = [1, 1, 1]`, the output should be
`arrayChange(inputArray) = 3`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input array.integer inputArray
    Guaranteed constraints:
    `3 ≤ inputArray.length ≤ 10^5`,
    `-10^5 ≤ inputArray[i] ≤ 10^5`.
- [output] integer
    - The minimal number of moves needed to obtain a strictly increasing
    sequence from `inputArray`.
    It's guaranteed that for the given test cases the answer always fits signed
    32-bit integer type.
 */

import java.util.Arrays;

public class ArrayChange {

    public static void main(String[] args) {
        test(new int[] {1, 1, 1}, 3, true);
        test(new int[] {-1000, 0, -2, 0}, 5, true);
        test(new int[] {2, 1, 10, 1}, 12, true);
        test(new int[] {2, 3, 3, 5, 5, 5, 4, 12, 12, 10, 15}, 13, true);
    }

    private static int arrayChange(int[] inputArray) {
        int counter = 0;
        int[] testArray = inputArray.clone();
        for (int i = 1; i < testArray.length; i++) {
            while (testArray[i] <= testArray[i-1]) {
                testArray[i]++;
                counter++;
            }
        }
        return counter;
    }

    private static boolean test(int[] inputArray, int expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: inputArray = " + Arrays.toString(inputArray) +
                    "\nOutput: " + arrayChange(inputArray) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (arrayChange(inputArray) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
