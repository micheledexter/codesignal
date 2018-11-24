package com.shelydexter;

/*
Correct variable names consist only of English letters, digits and underscores
and they can't start with a digit.
Check if the given string is a correct variable name.

Example:
For `name = "var_1__Int"`, the output should be `variableName(name) = true`;
For `name = "qq-q"`, the output should be `variableName(name) = false`;
for `name = "2w2"`, the output should be `variableName(name) = false`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string name
    Guaranteed constraints:
    `1 ≤ name.length ≤ 10`.
- [output] boolean
    - `true` if `name` is a correct variable name, `false` otherwise.
 */

import java.util.regex.Pattern;

public class VariableName {

    public static void main(String[] args) {
        test("var_1__Int", true);
        test("qq-q", false);
        test("2w2", false);
        test(" variable", false);
        test("va[riable0", false);
        test("variable0", true);
        test("a", true);
        test("_Aas_23", true);
        test("a a_2", false);
        test("0ss", false);
    }

    // My answer
    private static boolean variableName(String name) {
        return name.matches("^[a-zA-Z_]{1}[0-9a-zA-Z_]*$");
    }

    // Test method
    private static boolean test(String name, boolean expected, boolean verbose) {
        boolean output = variableName(name);
        if (verbose) {
            System.out.println("Input: name = " + name +
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

    private static boolean test(String name, boolean expected) {
        return test(name, expected, true);
    }
}
