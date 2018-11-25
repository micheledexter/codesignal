package com.shelydexter;

/*
Given a string, replace each its character by the next one in the English
alphabet (`z` would be replaced by `a`).

Example:
For `inputString = "crazy"`, the output should be
`alphabeticShift(inputString) = "dsbaz"`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string inputString
    Non-empty string consisting of lowercase English characters.
    Guaranteed constraints:
    `1 ≤ inputString.length ≤ 1000`.
- [output] string
    - The result string after replacing all of its characters.
 */

public class AlphabeticShift {

    public static void main(String[] args) {
        test("crazy", "dsbaz");
        test("z", "a");
        test("aaaabbbccd", "bbbbcccdde");
        test("fuzzy", "gvaaz");
        test("codesignal", "dpeftjhobm");
    }

    // My answer
    private static String alphabeticShift(String inputString) {
        String outputString = "";
        char[] arr = inputString.toCharArray();
        for (char letter: arr) {
            byte current = (byte)letter;
            current -= 97;
            current++;
            current %= 26;
            current += 97;
            letter = (char)current;
            outputString += letter;
        }
        return outputString;
    }

    // Test method
    private static boolean test(String inputString, String expected, boolean verbose) {
        String output = alphabeticShift(inputString);
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
