package com.shelydexter;

/*
Given the string, check if it is a palindrome.

Example:
- For `inputString = "aabaa"`, the output should be
`checkPalindrome(inputString) = true`;
- For `inputString = "abac"`, the output should be
`checkPalindrome(inputString) = false`;
- For `inputString = "a"`, the output should be
`checkPalindrome(inputString) = true`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string inputString
    A non-empty string consisting of lowercase characters.
    Guaranteed constraints:
    `1 ≤ inputString.length ≤ 10^5`.
- [output] boolean
    - `true` if `inputString` is a palindrome, `false` otherwise.
 */

public class CheckPalindrome {

    public static void main(String[] args) {
        test("aabaa", true, true);
        test("abac", false, true);
        test("a", true, true);
        test("az", false, true);
        test("abacaba", true, true);
        test("z", true, true);
        test("aaabaaaa", false, true);
        test("zzzazzazz", false, true);
        test("hlbeeykoqqqqokyeeblh", true, true);
        test("hlbeeykoqqqokyeeblh", true, true);
    }

    // My answer
    private static boolean checkPalindrome(String inputString) {
        String[] stringArray = inputString.toLowerCase().split("\\s*[^A-Za-z0-9]\\s*");
        String forwards = String.join("", stringArray);
        String backwards = new StringBuilder(forwards).reverse().toString();
        if (forwards.equals(backwards)) {
            return true;
        }
        return false;
    }

    // Test method
    private static boolean test(String inputString, boolean expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: inputString = " + inputString +
                    "\nOutput: " + checkPalindrome(inputString) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (checkPalindrome(inputString) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!");
        return false;
    }
}
