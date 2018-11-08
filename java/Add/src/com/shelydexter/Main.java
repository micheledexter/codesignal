package com.shelydexter;

/*
Write a function that returns the sum of two numbers.

Example:
For `param1 = 1` and `param2 = 2`, the output should be
`add(param1, param2) = 3`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer param1
    Guaranteed constraints:
    `-1000 ≤ param1 ≤ 1000`.
- [input] integer param2
    Guaranteed constraints:
    `-1000 ≤ param2 ≤ 1000`.
- [output] integer
    - The sum of the two inputs
 */

public class Main {

    public static void main(String[] args) {
        test(1, 2, 3, true);
        test(0, 1000, 1000, true);
        test(2, -39, -37, true);
        test(99, 100, 199, true);
        test(-100, 100, 0, true);
        test(-1000, -1000, -2000, true);
    }

    // My answer
    private static int add(int param1, int param2) {
        return param1 + param2;
    }

    // Test method
    private static boolean test(int param1, int param2, int expected, boolean verbose){
        if (verbose) {
            System.out.println("Input: param1 = " + param1 + "; param2 = " + param2 +
                    "\nOutput: " + add(param1, param2) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (add(param1, param2) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
