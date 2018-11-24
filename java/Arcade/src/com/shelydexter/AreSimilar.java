package com.shelydexter;

/*
Two arrays are called similar if one can be obtained from another by swapping
at most one pair of elements in one of the arrays.
Given two arrays `a` and `b`, check whether they are similar.

Example:
- For `a = [1, 2, 3]` and `b = [1, 2, 3]`, the output should be
    `areSimilar(a, b) = true`.
    The arrays are equal, no need to swap any elements.
- For `a = [1, 2, 3]` and `b = [2, 1, 3]`, the output should be
    `areSimilar(a, b) = true`.
    We can obtain `b` from `a` by swapping `2` and `1` in `b`.
- For `a = [1, 2, 2]` and `b = [2, 1, 1]`, the output should be
    `areSimilar(a, b) = false`.
    Any swap of two elements either in `a` or in `b` won't make `a` and `b`
    equal.

Input/Output
- [execution time limit] 3 seconds (java)
- [input] array.integer a
    Array of integers.
    Guaranteed constraints:
    `3 ≤ a.length ≤ 10^5`,
    `1 ≤ a[i] ≤ 1000`.
- [input] array.integer b
    Array of integers of the same length as `a`.
    Guaranteed constraints:
    `b.length = a.length`,
    `1 ≤ b[i] ≤ 1000`.
- [output] boolean
    - `true` if `a` and `b` are similar, false otherwise.
 */

import java.util.Arrays;

public class AreSimilar {

    public static void main(String[] args) {
        test(new int[] {1, 2, 3}, new int[] {1, 2, 3}, true, true);
        test(new int[] {1, 2, 3}, new int[] {2, 1, 3}, true, true);
        test(new int[] {1, 2, 2}, new int[] {2, 1, 1}, false, true);
        test(new int[] {1, 1, 4}, new int[] {1, 2, 3}, false, true);
        test(new int[] {1, 2, 3}, new int[] {1, 10, 2}, false, true);
        test(new int[] {2, 3, 1}, new int[] {1, 3, 2}, true, true);
        test(new int[] {2, 3, 9}, new int[] {10, 3, 2}, false, true);
        test(new int[] {4, 6, 3}, new int[] {3, 4, 6}, false, true);
        test(new int[] {832, 998, 148, 570, 533, 561, 894, 147, 455, 279}, new int[] {832, 998, 148, 570, 533, 561, 455, 147, 894, 279}, true, true);
        test(new int[] {832, 998, 148, 570, 533, 561, 894, 147, 455, 279}, new int[] {832, 570, 148, 998, 533, 561, 455, 147, 894, 279}, false, true);
    }

    // My answer
    public static boolean areSimilar(int[] a, int[] b) {
        int diff = 0;
        int[] aDiff = new int[2];
        int[] bDiff = new int[2];
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (diff > 1) return false;
                aDiff[diff] = a[i];
                bDiff[diff] = b[i];
                diff++;
            }
        }
        if (diff == 0) return true;
        if (aDiff[0] == bDiff[1] && aDiff[1] == bDiff[0]) return true;
        return false;
    }

    // Test method
    public static boolean test(int[] a, int[] b, boolean expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: a = " + Arrays.toString(a) + "; b = " + Arrays.toString(b) +
                    "\nOutput: " + areSimilar(a, b) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (areSimilar(a, b) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
