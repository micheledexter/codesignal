package com.shelydexter;

/*
Given a string, find out if its characters can be rearranged to form a
palindrome.

Example:
For `inputString = "aabb"`, the output should be
`palindromeRearranging(inputString) = true`.
We can rearrange `"aabb"` to make `"abba"`, which is a palindrome.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string inputString
    A string consisting of lowercase English letters.
    Guaranteed constraints:
    `1 ≤ inputString.length ≤ 50`.
- [output] boolean
    - `true` if the characters of the `inputString` can be rearranged to form a
    palindrome, `false` otherwise.
 */

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class PalindromeRearranging {

    public static void main(String[] args) {
        test("aabb", true, true);
        test("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc", false, true);
        test("abbcabb", true, true);
        test("zyyzzzzz", true, true);
        test("z", true, true);
        test("zaa", true, true);
        test("abca", false, true);
        test("abcad", false, true);
        test("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbccccaaaaaaaaaaaaa", false, true);
        test("abdhuierf", false, true);
    }

    // My answer
    private static boolean palindromeRearranging(String inputString) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (String letter: inputString.split("")) {
            if (hashmap.get(letter) == null) {
                hashmap.put(letter, 1);
            } else {
                hashmap.put(letter, hashmap.get(letter)+1);
            }
        }
        boolean oddFound = false;
        for (int count: hashmap.values()) {
            if (count % 2 == 1) {
                if (oddFound) return false;
                oddFound = true;
            }
        }
        return true;
    }

    // Test method
    private static boolean test(String inputString, boolean expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: inputString = " + inputString +
                    "\nOutput: " + palindromeRearranging(inputString) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (palindromeRearranging(inputString) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
