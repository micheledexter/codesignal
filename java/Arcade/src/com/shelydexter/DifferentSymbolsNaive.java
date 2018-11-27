package com.shelydexter;

/*
Given a string, find the number of different characters in it.

Example:
For `s = "cabca"`, the output should be `differentSymbolsNaive(s) = 3`.
There are `3` different characters `a`, `b` and `c`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string s
    A string of lowercase English letters.
    Guaranteed constraints:
    `3 ≤ s.length ≤ 1000`.
- [output] integer
 */

import java.util.HashMap;

public class DifferentSymbolsNaive {

    public static void main(String[] args) {
        test("cabca", 3);
        test("aba", 2);
        test("ccccccccccc", 1);
        test("bcaba", 3);
        test("codesignal", 10);
    }

    // My answer
    private static int differentSymbolsNaive(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, true);
        }
        return map.size();
    }

    // Test methods
    private static boolean test(String s, int expected, boolean verbose) {
        int output = differentSymbolsNaive(s);
        if (verbose) System.out.println("Input: s = " + s +
                "\nOutput = " + output +
                "\nExpected = " + expected);
        System.out.print("Result: ");
        if (output == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static boolean test(String s, int expected) {
        return test(s, expected, true);
    }
}
