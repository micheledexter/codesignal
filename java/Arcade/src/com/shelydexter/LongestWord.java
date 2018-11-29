package com.shelydexter;

/*
Define a word as a sequence of consecutive English letters. Find the longest
word from the given string.

Example:
For `text = "Ready, steady, go!"`, the output should be
`longestWord(text) = "steady"`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string text
    Guaranteed constraints:
    `4 ≤ text.length ≤ 50`.
- [output] string
    - The longest word from `text`. It's guaranteed that there is a unique
    output.
 */

public class LongestWord {

    public static void main(String[] args) {
        test("Ready, steady, go!", "steady");
        test("Ready[[[, steady, go!", "steady");
        test("ABCd", "ABCd");
        test("To be or not to be", "not");
        test("You are the best!!!!!!!!!!!! CodeFighter ever!", "CodeFighter");
    }

    // My answer
    private static String longestWord(String text) {
        String[] arr = text.split("[^A-Za-z]");
        int longest = 0;
        String output = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > longest) {
                longest = arr[i].length();
                output = arr[i];
            }
        }
        return output;
    }

    // Test method
    private static boolean test(String text, String expected) {
        String output = longestWord(text);
        System.out.println("Input: text = " + text +
                "\nOutput: " + output +
                "\nExpected: " + expected);
        System.out.print("Result: ");
        if (output.equals(expected)) {
            System.out.println("SUCCESSFUL\n");
            return true;
        }
        System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
