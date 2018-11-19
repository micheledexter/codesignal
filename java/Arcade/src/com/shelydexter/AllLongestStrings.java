package com.shelydexter;

/*
Given an array of strings, return another array containing all of its longest
strings.

Example:
For `inputArray = ["aba", "aa", "ad", "vcd", "aba"]`, the output should be
`allLongestStrings(inputArray) = ["aba", "vcd", "aba"]`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.string inputArray
    A non-empty array.
    Guaranteed constraints:
    `1 ≤ inputArray.length ≤ 10`,
    `1 ≤ inputArray[i].length ≤ 10`.
- [output] array.string
    - Array of the longest strings, stored in the same order as in the
    `inputArray`.
 */

import java.util.Arrays;

public class AllLongestStrings {

    public static void main(String[] args) {
        test(new String[] {"aba", "aa", "ad", "vcd", "aba"}, new String[] {"aba", "vcd", "aba"}, true);
        test(new String[] {"aa"}, new String[] {"aa"}, true);
        test(new String[] {"abc", "eeee", "abcd", "dcd"}, new String[] {"eeee", "abcd"}, true);
        test(new String[] {"a", "abc", "cbd", "zzzzzz", "a", "abcdef", "asasa", "aaaaaa"}, new String[] {"zzzzzz", "abcdef", "aaaaaa"}, true);
    }

    // My answer
    public static String[] allLongestStrings(String[] inputArray) {
        int length = 0;
        for (String item: inputArray) {
            if (item.length() > length) {
                length = item.length();
            }
        }
        int counter = 0;
        for (String item: inputArray) {
            if (item.length() == length) {
                counter++;
            }
        }
        String[] returnArray = new String[counter];
        counter = 0;
        for (String item: inputArray) {
            if (item.length() == length) {
                returnArray[counter] = item;
                counter++;
            }
        }
        return returnArray;
    }

    // Test method
    public static boolean test(String[] inputArray, String[] expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: inputArray = " + Arrays.toString(inputArray) +
                    "\nOutput: " + Arrays.toString(allLongestStrings(inputArray)) +
                    "\nExpected: " + Arrays.toString(expected));
            System.out.print("Result: ");
        }
        if (stringArraysAreEqual(allLongestStrings(inputArray), expected)) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    public static boolean stringArraysAreEqual(String[] first, String[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) return false;
        }
        return true;
    }
}
