package com.shelydexter;

/*
Let's define digit degree of some positive integer as the number of times we
need to replace this number with the sum of its digits until we get to a one
digit number.
Given an integer, find its digit degree.

Example:
For `n = 5`, the output should be `digitDegree(n) = 0`;
For `n = 100`, the output should be `digitDegree(n) = 1`;. `1 + 0 + 0 + 0 = 1`.
For `n = 91`, the output should be `digitDegree(n) = 2`. `9 + 1 = 10` ->
`1 + 0 = 1`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer n
    Guaranteed constraints:
    `5 ≤ n ≤ 10^9`.
- [output] integer
 */

public class DigitDegree {

    public static void main(String[] args) {
        test(5, 0);
        test(100, 1);
        test(91, 2);
        test(99, 2);
    }

    // My answer
    private static int digitDegree(int n) {
        if (n < 10) return 0;
        int replace = 0;
        while (n > 9) {
            int total = 0;
            while (n > 0) {
                total += n % 10;
                n /= 10;
            }
            n = total;
            replace++;
        }
        return replace;
    }

    // Test methods
    private static boolean test(int n, int expected, boolean verbose) {
        int output = digitDegree(n);
        if (verbose) {
            System.out.println("Input: n = " + n +
                    "\nOutput: " + output +
                    "\nExpected: " + expected);
            System.out.println("Result: ");
        }
        if (output == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static boolean test(int n, int expected) {
        return test(n, expected, true);
    }
}
