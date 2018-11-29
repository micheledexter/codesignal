package com.shelydexter;

/*
Determine if the given character is a digit or not.

Example:
- For `symbol = '0'`, the output should be `isDigit(symbol) = true`;
- for `symbol = '-'`, the output should be `isDigit(symbol) = false`;

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] char symbol
    A character which is either a digit or not.
- [output] boolean
    - `true` if `symbol` is a digit, `false` otherwise.
 */

public class IsDigit {

    public static void main(String[] args) {
        test('0', true);
        test('-', false);
        test('O', false);
        test('1', true);
        test('2', true);
        test('!', false);
        test('@', false);
        test('+', false);
        test('6', true);
        test('(', false);
        test(')', false);
    }

    // My answer
    private static boolean isDigit(char symbol) {
        return ("" + symbol).matches("[0-9]");
    }

    // Test methods
    private static boolean test(char symbol, boolean expected, boolean verbose) {
        boolean output = isDigit(symbol);
        if (verbose) {
            System.out.println("Input: symbol = " + symbol +
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

    private static boolean test(char symbol, boolean expected) {
        return test(symbol, expected, true);
    }
}
