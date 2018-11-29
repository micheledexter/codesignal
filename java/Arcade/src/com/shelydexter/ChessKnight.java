package com.shelydexter;

/*
Given a position of a knight on the standard chessboard, find the number of
different moves the knight can perform.
The knight can move to a square that is two squares away horizontally and one
square vertically, or two squares vertically and one square horizontally away
from it. The complete move therefore looks like the letter L. Check out the
image below to see all valid moves for a knight piece that is placed on one of
the central squares.
┌───┬───┬───┬───┬───┬───┬───┬───┐
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │ O │   │ O │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │ O │   │   │   │ O │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │ K │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │ O │   │   │   │ O │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │ O │   │ O │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │   │   │
└───┴───┴───┴───┴───┴───┴───┴───┘

Example:
- For `cell = "a1", the output should be `chessKnight(cell) = 2`.
┌───┬───┬───┬───┬───┬───┬───┬───┐
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │ O │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │ O │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│ K │   │   │   │   │   │   │   │
└───┴───┴───┴───┴───┴───┴───┴───┘
- For `cell = "c2"`, the output should be `chessKnight(cell) = 6`.
┌───┬───┬───┬───┬───┬───┬───┬───┐
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │ O │   │ O │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│ O │   │   │   │ O │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │ K │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│ O │   │   │   │ O │   │   │   │
└───┴───┴───┴───┴───┴───┴───┴───┘

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string cell
    String consisting of 2 letters - coordinates of the knight on an `8 x 8`
    chessboard in chess notation.
- [output] integer
 */

public class ChessKnight {

    public static void main(String[] args) {
        test("a1", 2);
        test("c2", 6);
        test("d4", 8);
        test("g6", 6);
    }

    // My answer
    private static int chessKnight(String cell) {
        char[] arr = cell.toCharArray();
        int counter = 0;
        for (int i = -2; i <= 2; i++) {
            if (i == 0) continue;
            for (int j = -2; j <= 2; j++) {
                if (j == 0 || Math.abs(i) == Math.abs(j)) continue;
                String test = (char)((byte)arr[0] + i) + "" + (char)((byte)arr[1] + j);
                if (test.matches("[a-h][1-8]")) counter++;
            }
        }
        return counter;
    }

    // Test methods
    private static boolean test(String cell, int expected, boolean verbose) {
        int output = chessKnight(cell);
        if (verbose) {
            System.out.println("Input: cell = " + cell +
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

    private static boolean test(String cell, int expected) {
        return test(cell, expected, true);
    }
}
