package com.shelydexter;

/*
Given some integer, find the maximal number you can obtain by deleting exactly
one digit of the given number.

Example:
- For `n = 152`, the output should be `deleteDigit(n) = 52`;
- For `n = 1001`, the output should be `deleteDigit(n) = 101`;

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer n
    Guaranteed constraints:
    `10 ≤ n ≤ 10^6`.
- [output] integer
 */

public class DeleteDigit {

    public static void main(String[] args) {
        test(152, 52);
        test(1001, 101);
        test(10, 1);
        test(222219, 22229);
    }

    // My answer
    private static int deleteDigit(int n) {
        char[] temp = (n + "").toCharArray();
        int[] arr = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = (int)temp[i]-48;
        }
        int highest = 0;
        for (int i = 0; i < arr.length; i++) {
            int total = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                total *= 10;
                total += arr[j];
            }
            if (total > highest) highest = total;
        }
        return highest;
    }

    // Test methods
    private static boolean test(int n, int expected, boolean verbose) {
        int output = deleteDigit(n);
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

    private static boolean test(int n, int expected) {
        return test(n, expected, true);
    }
}
