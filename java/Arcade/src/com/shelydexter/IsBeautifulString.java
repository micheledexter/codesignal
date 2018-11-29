package com.shelydexter;

/*
A string is said to be beautiful if `b` occurs in it no more times than `a`;
`c` occurs in it no more times than `b`; etc.
Given a string, check whether it is beautiful.

Example:
For `inputString = "bbbaacdafe"`, the output should be
`isBeautifulString(inputString) = true`;
For `inputString = "aabbb"`, the output should be
`isBeautifulString(inputString) = false`;
For `inputString = "bbc", the output should be
`isBeautifulString(inputString) = false`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string inputString
    A string of lowercase letters.
    Guaranteed constraints:
    `3 ≤ inputString.length ≤ 50`.
- [output] boolean
 */

import java.util.HashMap;

public class IsBeautifulString {

    public static void main(String[] args) {
        test("bbbaacdafe", true);
        test("aabbb", false);
        test("bbc", false);
        test("bbbaa", false);
        test("abcdefghijklmnopqrstuvwxyzz", false);
        test("abcdefghijklmnopqrstuvwxyz", true);
        test("abcdefghijklmnopqrstuvwxyzqwertuiopasdfghjklxcvbnm", true);
        test("fyudhrygiuhdfeis", false);
        test("zaa", false);
        test("zyy", false);
    }

    // My answer
    private static boolean isBeautifulString(String inputString) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 97; i < 123; i++) {
            map.put((char)i, 0);
        }
        int highestLetter = 0;
        for (char letter: inputString.toCharArray()) {
            if ((byte)(letter) > highestLetter) highestLetter = (byte)letter;
            map.put(letter, map.get(letter)+1);
        }
        for (int i = 98; i <= highestLetter; i++) {
            if (map.get((char)i) > map.get((char)(i-1))) return false;
        }
        return true;
    }

    // Test methods
    private static boolean test(String inputString, boolean expected, boolean verbose) {
        boolean output = isBeautifulString(inputString);
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

    private static boolean test(String inputString, boolean expected) {
        return test(inputString, expected, true);
    }
}
