package com.shelydexter;

/*
Given a rectangular matrix of characters, add a border of asterisks(`*`) to it.

Example:
For
    `picture = ["abc",
                "ded"]`
the output should be
    `addBorder(picture) = ["*****",
                           "*abc*",
                           "*ded*",
                           "*****"]`

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.string picture
    A non-empty array of non-empty equal-length strings.
    Guaranteed constraints:
    `1 ≤ picture.length ≤ 100`,
    `1 ≤ picture[i].length ≤ 100`.
- [output] array.string
    - The same matrix of characters, framed with a border of asterisks of width
    `1`.
 */

import java.util.Arrays;

public class AddBorder {

    public static void main(String[] args) {
        test(new String[] {"abc", "ded"}, new String[] {"*****", "*abc*", "*ded*", "*****"}, true);
        test(new String[] {"a"}, new String[] {"***", "*a*", "***"}, true);
        test(new String[] {"aa", "**", "zz"}, new String[] {"****", "*aa*", "****", "*zz*", "****"}, true);
        test(new String[] {"abcde", "fghij", "klmno", "pqrst", "uvwxy"}, new String[] {"*******", "*abcde*", "*fghij*", "*klmno*", "*pqrst*", "*uvwxy*", "*******"}, true);
        test(new String[] {"wzy**"}, new String[] {"*******", "*wzy***", "*******"}, true);
    }

    // My answer
    private static String[] addBorder(String[] picture) {
        int capLength = picture[0].length() + 2;
        String[] borderPicture = new String[picture.length+2];
        for (int i = 0; i < borderPicture.length; i++) {
            String newString = "";
            if (i == 0 || i == borderPicture.length-1) {
                for (int j = 0; j < capLength; j++) {
                    newString += "*";
                }
            } else {
                newString += "*" + picture[i-1] + "*";
            }
            borderPicture[i] = newString;
        }
        return borderPicture;
    }

    // Test method
    private static boolean test(String[] picture, String[] expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: picture = " + Arrays.toString(picture) +
                    "\nOutput: " + Arrays.toString(addBorder(picture)) +
                    "\nExpected: " + Arrays.toString(expected));
            System.out.print("Result: ");
        }
        if (arraysAreEqual(addBorder(picture), expected)) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static boolean arraysAreEqual(String[] first, String[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (first[i].equals(second[i])) continue;
            return false;
        }
        return true;
    }
}
