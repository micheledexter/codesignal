package com.shelydexter;

/*
Given two strings, find the number of common characters between them.

Example:
For `s1 = "aabcc"` and `s2 = "adcaa"`, the output should be
`commonCharacterCount(s1, s2) = 3`.
Strings have `3` common characters - `2` "a"s and `1` "c".

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string s1
    A string consisting of lowercase English letters.
    Guaranteed constraints:
    `1 ≤ s1.length ≤ 15`.
- [input] string s2
    A string consisting of lowercase English letters.
    Guaranteed constraints:
    `1 ≤ s2.length ≤ 15`.
- [output] integer
 */

public class CommonCharacterCount {

    public static void main(String[] args) {
        test("aabcc", "adcaa", 3, true);
        test("zzzz", "zzzzzzz", 4, true);
        test("abca", "xyzbac", 3, true);
        test("a", "b", 0, true);
        test("a", "aaa", 1, true);
    }

    // My answer
    private static int commonCharacterCount(String s1, String s2) {
        boolean[] tracker = new boolean[s2.length()];
        for (int i = 0; i < tracker.length; i++) {
            tracker[i] = true;
        }
        int counter = 0;
        String[] sa1 = s1.split("");
        String[] sa2 = s2.split("");
        for (int i = 0; i < sa1.length; i++) {
            for (int j = 0; j < sa2.length; j++) {
                if (tracker[j]) {
                    if (sa1[i].equals(sa2[j])) {
                        tracker[j] = false;
                        counter++;
                        break;
                    }
                }
            }
        }
        return counter;
    }

    // Test method
    private static boolean test(String s1, String s2, int expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: s1 = " + s1 + "; s2 = " + s2 +
                    "\nOutput: " + commonCharacterCount(s1, s2) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (commonCharacterCount(s1, s2) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
