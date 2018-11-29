package com.shelydexter;

/*
Given a string, return its encoding defined as follows:
- First, the string is divided into the least possible number of disjoint
substrings consisting of identical characters
    - for example, `"aabbbc"` is divided into `["aa", "bbb", "c"]`
- Next, each substring with length greater than one is replaced with a
concatenation of its length greater and the repeating character
    - for example, substring `"bbb"` is replaced by `"3b"`
- Finally, all the new strings are concatenated together in the same order and
a new string is returned.

Example:
For `s = "aabbbc"`, the output should be `lineEncoding(s) = "2a3bc"`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string s
    String consisting of lowercase English letters.
    Guaranteed constraints:
    `4 ≤ s.length ≤ 15`.
- [output] string
    - Encoded version of `s`.
 */

import java.util.ArrayList;

public class LineEncoding {

    public static void main(String[] args) {
        test("aabbbc", "2a3bc");
        test("abbcabb", "a2bca2b");
        test("abcd", "abcd");
        test("zzzz", "4z");
        test("wwwwwwwawwwwwww", "7wa7w");
        test("ccccccccccccccc", "15c");
        test("qwertyuioplkjhg", "qwertyuioplkjhg");
        test("ssiiggkooo", "2s2i2gk3o");
        test("adfaaa", "adf3a");
        test("bbjaadlkjdl", "2bj2adlkjdl");
    }

    // My answer
    private static String lineEncoding(String s) {
        char[] arr = s.toCharArray();
        ArrayList<String> sub = new ArrayList<>();
        char letter = arr[0];
        int counter = 0;
        sub.add(letter + "");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == letter) {
                sub.set(counter, sub.get(counter) + arr[i] + "");
            } else {
                sub.add(arr[i] + "");
                letter = arr[i];
                counter++;
            }
        }
        String output = "";
        for (String part: sub) {
            if (part.length() == 1) {
                output += part;
            } else {
                output += part.length();
                output += part.toCharArray()[0];
            }
        }
        return output;
    }

    // Test methods
    private static boolean test(String s, String expected, boolean verbose) {
        String output = lineEncoding(s);
        if (verbose) {
            System.out.println("Input: s = " + s +
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

    private static boolean test(String s, String expected) {
        return test(s, expected, true);
    }
}
