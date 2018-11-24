package com.shelydexter;

/*
Check if all digits of the given integer are even.

Example:
- For `n = 248622`, the output should be `evenDigitsOnly(n) = true`;
- For `n = 642386`, the output should be `evenDigitsOnly(n) = false`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer n
    Guaranteed constraints:
    `1 ≤ n ≤ 10^9`.
- [output] boolean
    - `true` if all digits of `n` are even, `false` otherwise
 */

public class EvenDigitsOnly {

    public static void main(String[] args) {
        test(248622, true);
        test(642386, false);
        test(248842, true);
        test(1, false);
        test(8, true);
        test(2462487, false);
        test(468402800, true);
        test(2468428, true);
        test(5468428, false);
        test(7468428, false);
    }

    // My answer
    private static boolean evenDigitsOnly(int n) {
        while (n > 0) {
            if (n % 2 == 1) return false;
            n /= 10;
        }
        return true;
    }

    // Test method
    private static boolean test(int n, boolean expected, boolean verbose) {
        boolean output = evenDigitsOnly(n);
        if (verbose) {
            System.out.println("Input: n = " + n +
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

    private static boolean test(int n, boolean expected) {
        return test(n, expected, true);
    }
}
