package com.shelydexter;

/*
Some people are standing in a row in a park. There are trees between them which
cannot be moved. Your task is to rearrange the people by their heights in a
non-descending order without moving the trees. People can be very tall!

Example:
For `a = [-1, 150, 190, 170, -1, -1, 160, 180]`, the output should be
`sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190]`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input array.integer a
    if `a[i] = -1`, then the `ith` position is occupied by a tree. Otherwise
    `a[i]` is the height of a person standing in the `ith` position.
    Guaranteed constraints:
    `1 ≤ a.length ≤ 1000`,
    `-1 ≤ a[i] ≤ 1000`.
- [output] array.integer
    - Sorted array `a` with all the trees untouched.
 */

import java.util.Arrays;

public class SortByHeight {

    public static void main(String[] args) {
        test(new int[] {-1, 150, 190, 170, -1, -1, 160, 180}, new int[] {-1, 150, 160, 170, -1, -1, 180, 190}, true);
        test(new int[] {-1, -1, -1, -1, -1}, new int[] {-1, -1, -1, -1, -1}, true);
        test(new int[] {-1}, new int[] {-1}, true);
        test(new int[] {4, 2, 9, 11, 2, 16}, new int[] {2, 2, 4, 9, 11, 16}, true);
    }

    private static int[] sortByHeight(int[] a) {

    }

    private static boolean test(int[] a, int[] expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: a = " + Arrays.toString(a) +
                    "\nOutput: " + Arrays.toString(sortByHeight(a)) +
                    "\nExpected: " + Arrays.toString(expected));
            System.out.print("Result: ");
        }
        if (sortByHeight(a) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
