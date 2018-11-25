package com.shelydexter;

/*
Given a sorted array of integers `a`, find an integer `x` from `a` such that
the value of `abs(a[0] - x) + abs(a[1] - x) + ... + abs(a[a.length - 1] - x)`
is the smallest possible (here `abs` denotes the absolute value).
If there are several possible answers, output the smallest one.

Example:
For `a = [2, 4, 7]`, the output should be
`absoluteValuesSumMinimization(a) = 4`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.integer a
    A non-empty array of integers, sorted in ascending order.
    Guaranteed constraints:
    `1 ≤ a.length ≤ 200`.
    `-10^6 ≤ a[i] ≤ 10^6`.
- [output] integer
 */

import java.util.Arrays;

public class AbsoluteValuesSumMinimization {

    public static void main(String[] args) {
        test(new int[] {2, 4, 7}, 4);
        test(new int[] {1, 1, 3, 4}, 1);
        test(new int[] {23}, 23);
        test(new int[] {-10, -10, -10, -10, -10, -9, -9, -9, -8, -8, -7, -6, -5, -4, -3, -2, -1, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50}, 15);
        test(new int[] {-4, -1}, -4);
        test(new int[] {0, 7, 9}, 7);
        test(new int[] {-1000000, -10000, -10000, -1000, -100, -10, -1, 0, 1, 10, 100, 1000, 10000, 100000, 1000000}, 0);
    }

    // My answer
    private static int absoluteValuesSumMinimization(int[] a) {
        boolean flip = true;
        int current = 0;
        int lowest = Integer.MAX_VALUE;
        int record = 0;
        while (current < 1000) {
            System.out.println(lowest);
            int total = 0;
            for (int i = 0; i < a.length; i++) {
                total += Math.abs(a[i] - current);
            }
            if (Math.abs(total) < Math.abs(lowest)) {
                lowest = total;
                record = current;
            }
            if (Math.abs(total) == Math.abs(lowest)) {
                if (record > current) {
                    record = current;
                }
            }
            if (flip) {
                if (current < 0) current--;
                if (current >= 0) current++;
                flip = false;
            } else {
                current = -(current);
                flip = true;
            }
        }
        return record;
    }

    // Test method
    private static boolean test(int[] a, int expected, boolean verbose) {
        int output = absoluteValuesSumMinimization(a);
        if (verbose) {
            System.out.println("Input: a = " + Arrays.toString(a) +
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

    private static boolean test(int[] a, int expected) {
        return test(a, expected, true);
    }
}
