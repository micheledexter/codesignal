package com.shelydexter;

/*
Given an array of equal-length strings, check if it is possible to rearrange
the strings in such a way that after the rearrangement the strings at
consecutive positions would differ by exactly one character.

Example:
For `inputArray = `["aba", "bbb", "bab"]`, the output should be
`stringsRearrangement(inputArray) = false`.
All rearrangements don't satisfy the description condition.
For `inputArray = ["ab", "bb", "aa"]`, the output should be
`stringsRearrangement(inputArray) = true`.
Strings can be rearranged in the following way: `"aa", "ab", "bb"`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.string inputArray
    A non-empty array of strings of lowercase letters.
    Guaranteed constraints:
    `2 ≤ inputArray.length ≤ 10`,
    `1 ≤ inputArray[i].length ≤ 15`.
- [output boolean]
 */

import java.util.Arrays;

public class StringsRearrangement {

    public static void main(String[] args) {
        test(new String[] {"aba", "bbb", "bab"}, false);
        test(new String[] {"ab", "bb", "aa"}, true);
        test(new String[] {"q", "q"}, false);
        test(new String[] {"zzzzab", "zzzzbb", "zzzzaa"}, true);
        test(new String[] {"ab", "ad", "ef", "eg"}, false);
        test(new String[] {"abc", "bef", "bcc", "bec", "bbc", "bdc"}, true);
        test(new String[] {"abc", "abx", "axx", "abc"}, false);
        test(new String[] {"abc", "abx", "axx", "abx", "abc"}, true);
        test(new String[] {"f", "g", "a", "h"}, true);
        test(new String[] {"ff", "gf", "af", "ar", "hf"}, true);
        test(new String[] {"a", "b", "c"}, true);
    }

    // My answer
    private static boolean stringsRearrangement(String[] inputArray) {
        String head = inputArray[0];
        String tail = inputArray[0];
        System.out.println("SEED " + inputArray[0]);
        int length = 1;
        for (int i = 1; i < inputArray.length; i++) {
            boolean found = false;
            for (int j = i; j < inputArray.length; j++) {
                if (!found) {
                    for (int k = 0; k < inputArray[j].length(); k++) {
                        char[] working = inputArray[j].toCharArray();
                        working[k] = '.';
                        if (head.matches(new String(working)) && !inputArray[j].equals(head) && !found) {
                            head = inputArray[j];
                            length++;
                            System.out.println("HEAD " + inputArray[j]);
                            found = true;
                        }
                    }
                    for (int k = inputArray[j].length()-1; k >= 0; k--) {
                        char[] working = inputArray[j].toCharArray();
                        working[k] = '.';
                        if (tail.matches(new String(working)) && !inputArray[j].equals(tail) && !found) {
                            tail = inputArray[j];
                            length++;
                            found = true;
                        }
                    }
                }
            }
        }
        return length == inputArray.length;
    }

    // Test methods
    private static boolean test(String[] inputArray, boolean expected, boolean verbose) {
        boolean output = stringsRearrangement(inputArray);
        if (verbose) {
            System.out.println("Input: inputArray = " + Arrays.toString(inputArray) +
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

    private static boolean test(String[] inputArray, boolean expected) {
        return test(inputArray, expected, true);
    }
}
