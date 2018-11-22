package com.shelydexter;

/*
Several people are standing in a row and need to be divided into two teams. The
first person goes into team 1, the second goes into team 2, the third goes into
team 1 again, the fourth goes into team 2, and so on.
You are given an array of positive integers - the weights of the people. Return
an array of two integers, where the first element is the total weight of team
1, and the second element is the total weight of team 2 after the division is
complete.

Example:
For `a = [50, 60, 60, 45, 70]`, the output should be
`alternatingSums(a) = [180, 105]`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.integer a
    Guaranteed constraints:
    `1 ≤ a.length ≤ 10^5`,
    `45 ≤ a[i] ≤ 100`.
- [output] array.integer
 */

import java.util.Arrays;

public class AlternatingSums {

    public static void main(String[] args) {
        test(new int[] {50, 60, 60, 45, 70}, new int[] {180, 105}, true);
        test(new int[] {100, 50}, new int[] {100, 50}, true);
        test(new int[] {80}, new int[] {80, 0}, true);
        test(new int[] {100, 50, 50, 100}, new int[] {150, 150}, true);
        test(new int[] {100, 51, 50, 100}, new int[] {150, 151}, true);
    }

    // My answer
    private static int[] alternatingSums(int[] a) {
        int[] teams = new int[2];
        for (int i = 0; i < a.length; i++) {
            teams[i%2] += a[i];
        }
        return teams;
    }

    // Test method
    private static boolean test(int[] a, int[] expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: a = " + toString(a) +
                    "\nOutput: " + toString(alternatingSums(a)) +
                    "\nExpected: " + toString(expected));
            System.out.print("Result: ");
        }
        if (arraysAreEqual(alternatingSums(a), expected)) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static boolean arraysAreEqual(int[] first, int[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) return false;
        }
        return true;
    }

    private static String toString(int[] a) {
        String aStr = "[";
        for (int i = 0; i < a.length; i++) {
            aStr += a[i];
            if (i < a.length-1) aStr += ", ";
        }
        aStr += "]";
        return aStr;
    }
}
