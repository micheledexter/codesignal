package com.shelydexter;

/*
You have a string `s` that consists of English letters, punctuation marks,
whitespace characters, and brackets. It is guaranteed that the parentheses in
`s` form a regular bracket sequence.
Your task is to reverse the strings contained in each pair of matching
parentheses, starting from the innermost pair. The result string should not
contain any parentheses.

Example:
For string `s = "a(bc)de"`, the output should be
`reverseParentheses(s) = "acbde"`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string s
    A string consisting of English letters, punctuation marks, whitespace
    characters and brackets. It is guaranteed that parentheses form a regular
    bracket sequence.
    Constraints:
    `5 ≤ s.length ≤ 55`.
- [output] string
 */

import java.util.Arrays;

public class ReverseParentheses {

    public static void main(String[] args) {
        test("a(bc)de", "acbde", true);
        test("a(bcdefghijkl(mno)p)q", "apmnolkjihgfedcbq", true);
        test("co(de(fight)s)", "cosfighted", true);
        test("Code(Cha(lle)nge)", "CodeegnlleahC", true);
        test("Where are the parentheses?", "Where are the parentheses?", true);
        test("abc(cba)ab(bac)c", "abcabcabcabc", true);
        test("The ((quick (brown) (fox) jumps over the lazy) dog)", "The god quick nworb xof jumps over the lazy", true);
    }

    private static String reverseParentheses(String s) {
        String[] arr = s.split("");
        if (arr.length <= 1) return s;
        int stickyLo = 0;
        int stickyHi = 0;
        int counter = 0;
        String newString = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(") && counter == 0) {
                counter++;
                stickyLo = i;
            } else if (arr[i].equals(")") && counter == 1) {
                counter--;
                stickyHi = i;
                break;
            } else if (arr[i].equals("(") && counter > 0) {
                counter++;
            } else if (arr[i].equals(")") && counter >1) {
                counter--;
            }
            if (counter == 0) {
                newString += arr[i];
            }
        }
        if (stickyHi == stickyLo) return newString;
        for (int i = stickyHi-1; i > stickyLo; i--) {
            if (arr[i].equals("(")) {
                newString += ")";
            } else if (arr[i].equals(")")) {
                newString += "(";
            } else {
                newString += arr[i];
            }
        }
        if (stickyHi < arr.length-1) {
            for (int i = stickyHi+1; i < arr.length; i++) {
                newString += arr[i];
            }
        }
        return reverseParentheses(newString);
    }

    private static boolean test(String s, String expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: s = " + s +
                    "\nOutput: " + reverseParentheses(s) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (reverseParentheses(s).equals(expected)) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
