package com.shelydexter;

/*
Ticket numbers usually consist of an even number of digits. A ticket number is
considered lucky if the sum of the first half of the digits is equal to the sum
of the second half.
Given a ticket number `n`, determine if it's lucky or not.

Example:
For `n = 1230`, the output should be `isLucky(n) = true`,
For `n = 239017`, the output should be `isLucky(n) = false`.

Input/Output
- [execution time limit] 3 seconds (java)
- [input] integer n
    A ticket number represented as a positive integer with an even number of
    digits.
    Guaranteed constraints:
    `10 ≤ n < 10^6`.
- [output] boolean
    - `true` if `n` is a lucky ticket number, `false` otherwise.
 */

public class IsLucky {

    public static void main(String[] args) {
        test(1230, true, true);
        test(239017, false, true);
        test(134008, true, true);
        test(10, false, true);
        test(11, true, true);
        test(1010, true, true);
        test(261534, false, true);
        test(100000, false, true);
        test(999999, true, true);
        test(123321, true, true);
    }

    // My answer
    private static boolean isLucky(int n) {
        String[] strArr = Integer.toString(n).split("");
        int half = strArr.length/2;
        int firstHalf = 0;
        int secondHalf = 0;
        for (int i = 0; i < half; i++) {
            firstHalf += Integer.parseInt(strArr[i]);
        }
        for (int i = half; i < strArr.length; i++) {
            secondHalf += Integer.parseInt(strArr[i]);
        }
        return firstHalf == secondHalf;
    }

    // Test method
    private static boolean test(int n, boolean expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: n = " + n +
                    "\nOutput: " + isLucky(n) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (isLucky(n) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
