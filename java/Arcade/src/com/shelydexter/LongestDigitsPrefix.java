package com.shelydexter;

/*
Given a string, output its longest prefix which contains only digits.

Example:
For `inputString = "123aa1"`, the output should be
`longestDigitsPrefix(inputString) = "123"`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string inputString
    Guaranteed constraints:
    `3 ≤ inputString.length ≤ 35`.
- [output] string
 */

public class LongestDigitsPrefix {

    public static void main(String[] args) {
        test("123aa1", "123");
        test("0123456789", "0123456789");
        test("  3) always check for whitespaces", "");
        test("12abc34", "12");
        test("the output is 42", "");
    }

    // My answer
    private static String longesDigitsPrefix(String inputString) {
        String digits = "";
        for (char item: inputString.toCharArray()) {
            if ((byte)item >= 48 && (byte)item <= 57) {
                digits += item;
            } else {
                break;
            }
        }
        return digits;
    }

    // Test methods
    private static boolean test(String inputString, String expected, boolean verbose) {
        String output = longesDigitsPrefix(inputString);
        if (verbose) {
            System.out.println("Input: inputString = " + inputString +
                    "\nOutput: " + output +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (output.equals(expected)) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static boolean test(String inputString, String expected) {
        return test(inputString, expected, true);
    }
}
