package com.shelydexter;

/*
Given a sequence of integers as an array, determine whether it is possible to
obtain a strictly increasing sequence by removing no more than one element
from the array.

Example:
- For `sequence = [1, 3, 2, 1]`, the output should be
`almostIncreasingSequence(sequence) = false`.
    There is no one element in this array that can be removed in order to get a
    strictly increasing sequence.
- For `sequence = [1, 3, 2]`, the output should be
`almostIncreasingSequence(sequence) = true`.
    You can remove `3` from the array to get the strictly increasing sequence
    `[1, 2]`. Alternatively you can remove `2` to get the strictly increasing
sequence `[1, 3]`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.integer sequence
    Guaranteed constraints:
    `2 ≤ sequence.length ≤ 10^5`,
    `-10^5 ≤ sequence[i] ≤ 10^5`.
- [output] boolean
    - Return `true` if it is possible to remove one element from the array in
    order to get a strictly increasing sequence, otherwise return `false`
 */

import java.util.Arrays;

public class AlmostIncreasingSequence {

    public static void main(String[] args) {
        test(new int[] {1, 3, 2, 1}, false, true);
        test(new int[] {1, 3, 2}, true, true);
        test(new int[] {1, 2, 1, 2}, false, true);
        test(new int[] {1, 4, 10, 4, 2}, false, true);
        test(new int[] {10, 1, 2, 3, 4, 5}, true, true);
        test(new int[] {1, 1, 1, 2, 3}, false, true);
        test(new int[] {0, -2, 5, 6}, true, true);
        test(new int[] {1, 2, 3, 4, 5, 3, 5, 6}, false, true);
        test(new int[] {40, 50, 60, 10, 20, 30}, false, true);
        test(new int[] {1, 1}, true, true);
        test(new int[] {1, 2, 5, 3, 5}, true, true);
        test(new int[] {1, 2, 5, 5, 5}, false, true);
        test(new int[] {10, 1, 2, 3, 4, 5, 6, 1}, false, true);
        test(new int[] {1, 2, 3, 4, 3, 6}, true, true);
        test(new int[] {1, 2, 3, 4, 99, 5, 6}, true, true);
        test(new int[] {123, -17, -5, 1, 2, 3, 12, 43, 45}, true, true);
        test(new int[] {3, 5, 67, 98, 3}, true, true);
    }

    // My answer
    public static boolean almostIncreasingSequence(int[] sequence) {
        int ticker = sequence[0];
        int memory = sequence[0];
        boolean doubleCheck = false;
        for (int i = 1; i < sequence.length; i++) {
            if (ticker < sequence[i]) {
                ticker = sequence[i];
                continue;
            }
            if (doubleCheck || sequence[i] == memory) return false;
            doubleCheck = true;
            memory = sequence[i];
            ticker = sequence[i];
        }
        return true;
    }

    // Test method
    public static boolean test(int[] sequence, boolean expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: sequence = " + Arrays.toString(sequence) +
                    "\nOutput: " + almostIncreasingSequence(sequence) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (almostIncreasingSequence(sequence) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
