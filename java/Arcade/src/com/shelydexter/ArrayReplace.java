package com.shelydexter;

/*
Given an array of integers, replace all the occurrences of `elemToReplace` with
`substitutionElem`.

Example:
For `inputArray = [1, 2, 1]`, `elemToReplace = 1`, and `substitutionElem = 3`,
the output should be
`arrayReplace(inputArray, elemToReplace, substitutionElem) = [3, 2, 3]`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.integer inputArray
    Guaranteed constraints:
    `2 ≤ inputArray.length ≤ 10`,
    `0 ≤ inputArray[i] ≤ 10`.
- [input] integer elemToReplace
    Guaranteed constraints:
    `0 ≤ substitutionElem ≤ 10`.
- [output] array.integer
 */

import java.util.Arrays;

public class ArrayReplace {

    public static void main(String[] args) {
        test(new int[] {1, 2, 1}, 1, 3, new int[] {3, 2, 3}, true);
        test(new int[] {1, 2, 3, 4, 5}, 3, 0, new int[] {1, 2, 0, 4, 5}, true);
        test(new int[] {1, 1, 1}, 1, 10, new int[] {10, 10, 10}, true);
        test(new int[] {1, 2, 1, 2, 1}, 2, 1, new int[] {1, 1, 1, 1, 1}, true);
        test(new int[] {1, 2, 1, 2, 1}, 2, 2, new int[] {1, 2, 1, 2, 1}, true);
        test(new int[] {3, 1}, 3, 9, new int[] {9, 1}, true);
    }

    // My answer
    public static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == elemToReplace) inputArray[i] = substitutionElem;
        }
        return inputArray;
    }

    // Test method
    public static boolean test(int[] inputArray, int elemToReplace, int substitutionElem, int[] expected, boolean verbose) {
        int[] output = arrayReplace(inputArray, elemToReplace, substitutionElem);
        if (verbose) {
            System.out.println("Input: inputArray = " + Arrays.toString(inputArray) + "; elemToReplace = " + elemToReplace + "; substitutionElem = " + substitutionElem +
                    "\nOutput: " + Arrays.toString(output) +
                    "\nExpected: " + Arrays.toString(expected));
            System.out.print("Result: ");
        }
        if (areEqual(output, expected)) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    public static boolean areEqual(int[] first, int[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) return false;
        }
        return true;
    }
}
