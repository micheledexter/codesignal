package com.shelydexter;

/*
Find the leftmost digit that occurs in a given string.

Example:
For `inputString = "var_1__Int"`, the output should be
`firstDigit(inputString) = '1'`;
For `inputString = "q2q-q"`, the output should be
`firstDigit(inputString) = '2'`;
For `inputString = "0ss"`, the output should be
`firstDigit(inputString) = '0'`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string inputString
    A string containing at least one digit.
    Guaranteed constraints:
    `3 ≤ inputString.length ≤ 10`.
- [output] char
 */

public class FirstDigit {

    public static void main(String[] args) {
        test("var_1__Int", '1');
        test("q2q-q", '2');
        test("0ss", '0');
        test("_Aas_23", '2');
        test("a a_933", '9');
        test("ok0", '0');
    }

    // My answer
    private static char firstDigit(String inputString) {
        char output = 'x';
        char[] arr = inputString.toCharArray();
        for (int i = arr.length-1; i >= 0; i--) {
            byte test = (byte)arr[i];
            if (test >= 48 && test <= 57) output = arr[i];
        }
        return output;
    }

    // Test methods
    private static boolean test(String inputString, char expected, boolean verbose) {
        char output = firstDigit(inputString);
        if (verbose) {
            System.out.println("Input: inputString = " + inputString +
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

    private static boolean test(String inputString, char expected) {
        return test(inputString, expected, true);
    }
}
