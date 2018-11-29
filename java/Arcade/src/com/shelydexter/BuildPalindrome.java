package com.shelydexter;

/*
Given a string, find the shortest possible string which can be achieved by
adding characters to the end of initial string to make it a palindrome.

Example:
For `st = "abcdc"`, the output should be `buildPalindrome(st) = "abcdcba"`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string st
    A string consisting of lowercase English letters.
    Guaranteed constraints:
    `3 ≤ st.length ≤ 10`.
- [output] string
 */

public class BuildPalindrome {

    public static void main(String[] args) {
        test("abcdc", "abcdcba");
        test("ababab", "abababa");
        test("abba", "abba");
        test("abaa", "abaaba");
    }

    // My answer
    private static String buildPalindrome(String st) {
        if (st.equals(new StringBuilder(st).reverse().toString())) return st;
        String reverse = "";
        char[] arr = st.toCharArray();
        String test = "";
        for (int i = 0; i < arr.length; i++) {
            reverse = arr[i] + reverse;
            test = st + reverse;
            if (test.equals(new StringBuilder(test).reverse().toString())) break;
        }
        return test;
    }

    private static boolean test(String st, String expected, boolean verbose) {
        String output = buildPalindrome(st);
        if (verbose) {
            System.out.println("Input: st = " + st +
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

    private static boolean test(String st, String expected) {
        return test(st, expected, true);
    }
}
