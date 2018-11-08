package com.shelydexter;

/*
Given an array of integers, find the pair of adjacent elements that has the
largest product and return that product.

Example:
For `inputArray = [3, 6, -2, -5, 7, 3]`, the output should be
`adjacentElementsProduct(inputArray) = 21`.
`7` and `3` produce the largest product.

Input/Output
- [execution time limit] 3 seconds (java)
- [input] array.integer inputArray
    An array of integers containing at least two elements.
    Guaranteed constraints:
    `2 ≤ inputArray.length ≤ 10`,
    `-1000 ≤ inputArray[i] ≤ 1000`.
- [output] integer
    - The largest product of adjacent elements.
 */

import java.util.Arrays;

public class AdjacentElementsProduct {

    public static void main(String[] args) {
        test(new int[] {3, 6, -2, -5, 7, 3}, 21, true);
        test(new int[] {-1, -2}, 2, true);
        test(new int[] {5, 1, 2, 3, 1, 4}, 6, true);
        test(new int[] {1, 2, 3, 0}, 6, true);
        test(new int[] {9, 5, 10, 2, 24, -1, -48}, 50, true);
        test(new int[] {5, 6, -4, 2, 3, 2, -23}, 30, true);
        test(new int[] {4, 1, 2, 3, 1, 5}, 6, true);
        test(new int[] {-23, 4, -3, 8, -12}, -12, true);
        test(new int[] {1, 0, 1, 0, 1000}, 0, true);
    }

    // My answer
    private static int adjacentElementsProduct(int[] inputArray) {
        int highest = inputArray[0] * inputArray[1];
        for (int i = 1; i < inputArray.length-1; i++) {
            int match = inputArray[i] * inputArray[i+1];
            if (match > highest) {
                highest = match;
            }
        }
        return highest;
    }

    // Test method
    private static boolean test(int[] inputArray, int expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: inputArray = " + Arrays.toString(inputArray) +
                    "\nOutput: " + adjacentElementsProduct(inputArray) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (adjacentElementsProduct(inputArray) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
