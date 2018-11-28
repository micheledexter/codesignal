package com.shelydexter;

/*
Given the positions of a white `bishop` and a black `pawn` on the standard
chess board, determine whether the bishop can capture the pawn in one move.
The bishop has no restrictions in the distance for each move, but is limited to
diagonal movement. Check out the example below to see how it can move:
┌───┬───┬───┬───┬───┬───┬───┬───┐
│   │   │   │   │   │   │   │ O │
├───┼───┼───┼───┼───┼───┼───┼───┤
│ O │   │   │   │   │   │ O │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │ O │   │   │   │ O │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │ O │   │ O │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │ B │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │ O │   │ O │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │ O │   │   │   │ O │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│ O │   │   │   │   │   │ O │   │
└───┴───┴───┴───┴───┴───┴───┴───┘

Example:
For `bishop = "a1"` and `pawn = "c3"`, the output should be
`bishopAndPawn(bishop, pawn) = true`.
┌───┬───┬───┬───┬───┬───┬───┬───┐
│   │   │   │   │   │   │   │ O │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │ O │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │ O │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │ O │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │ O │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │ P │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │ / │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│ B │   │   │   │   │   │   │   │
└───┴───┴───┴───┴───┴───┴───┴───┘
For `bishop = "h1"` and `pawn = "h3"`, the output should be
`bishopAndPawn(bishop, pawn) = false`.
┌───┬───┬───┬───┬───┬───┬───┬───┐
│ O │   │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │ O │   │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │ O │   │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │ O │   │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │ O │   │   │   │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │ O │   │ P │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │ O │ X │
├───┼───┼───┼───┼───┼───┼───┼───┤
│   │   │   │   │   │   │   │ B │
└───┴───┴───┴───┴───┴───┴───┴───┘

Input/Output:
- [execution time limit] 3 seconds (java)
- [input]
 */

public class BishopAndPawn {

    public static void main(String[] args) {
        test("a1", "c3", true);
        test("h1", "h3", false);
        test("a5", "c3", true);
        test("g1", "f3", false);
        test("e7", "d6", true);
        test("e7", "a3", true);
        test("e3", "a7", true);
        test("a1", "h8", true);
        test("a1", "h7", false);
        test("h1", "a8", true);
    }

    // My answer
    private static boolean bishopAndPawn(String bishop, String pawn) {
        char[] bishopArr = bishop.toCharArray();
        char[] pawnArr = pawn.toCharArray();
        return Math.abs((byte)bishopArr[0] - (byte)pawnArr[0]) == Math.abs((byte)bishopArr[1] - (byte)pawnArr[1]);
    }

    // Test methods
    private static boolean test(String bishop, String pawn, boolean expected, boolean verbose) {
        boolean output = bishopAndPawn(bishop, pawn);
        if (verbose) {
            System.out.println("Input: bishop = " + bishop + "; pawn = " + pawn +
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

    private static boolean test(String bishop, String pawn, boolean expected) {
        return test(bishop, pawn, expected, true);
    }
}
