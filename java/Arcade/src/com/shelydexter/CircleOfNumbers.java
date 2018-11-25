package com.shelydexter;

/*
Consider integer numbers from `0` to `n - 1` written down along the circle in
such a way that the distance between any two neighboring numbers is equal (note
that `0` and `n - 1` are neighboring, too).
Given `n` and `firstNumber`, find the number which is written in the radially
opposite position to `firstNumber`.

Example:
For `n = 10` and `firstNumber = 2`, the output should be
`circleOfNumbers(n, firstNumber) = 7`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer n
    A positive even integer.
    Guaranteed constraints:
    `4 ≤ n ≤ 20`.
- [input] integer firstNumber
    Guaranteed constraints:
    `0 ≤ firstNumber ≤ n - 1`.
- [output] integer
 */

public class CircleOfNumbers {

    public static void main(String[] args) {
        test(10, 2, 7);
        test(10, 7, 2);
        test(4, 1, 3);
        test(6, 3, 0);
    }

    // My answer
    private static int circleOfNumbers(int n, int firstNumber) {
        return (firstNumber + (n / 2)) % n;
    }

    // Test method
    private static boolean test(int n, int firstNumber, int expected, boolean verbose) {
        int output = circleOfNumbers(n, firstNumber);
        if (verbose) {
            System.out.println("Input: n = " + n + "; firstNumber = " + firstNumber +
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

    private static boolean test(int n, int firstNumber, int expected) {
        return test(n, firstNumber, expected, true);
    }
}
