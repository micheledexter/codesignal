package com.shelydexter;

/*
Given two cells on the standard chess board, determine whether they have the
same color or not.

Example:
- For `cell1 = "A1"` and `cell2 = "C3"`, the output should be
`chessBoardCellColor(cell1, cell2) = true`.
- For `cell1 = "A1"` and `cell2 = "H3"`, the output should be
`chessBoardCellColor(cell1, cell2) = false`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string cell1
- [input] string cell2
- [output] boolean
    - `true` if both cells have the same color, `false` otherwise.
 */

public class ChessBoardCellColor {

    public static void main(String[] args) {
        test("A1", "C3", true);
        test("A1", "H3", false);
        test("A1", "A2", false);
        test("A1", "B2", true);
        test("B3", "H8", false);
        test("C3", "B5", false);
        test("G5", "E7", true);
        test("C8", "H8", false);
        test("D2", "D2", true);
        test("A2", "A5", false);
    }

    // My answer
    private static boolean chessBoardCellColor(String cell1, String cell2) {
        char[] first = cell1.toCharArray();
        char[] second = cell2.toCharArray();
        int letters = Math.abs((byte)first[0] - (byte)second[0]);
        int numbers = Math.abs((int)first[1] - (int)second[1]);
        int total = letters + numbers;
        return total % 2 == 0;
    }

    // Test method
    private static boolean test(String cell1, String cell2, boolean expected, boolean verbose) {
        boolean output = chessBoardCellColor(cell1, cell2);
        if (verbose) {
            System.out.println("Input: cell1 = " + cell1 + "; cell2 = " + cell2 +
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

    private static boolean test(String cell1, String cell2, boolean expected) {
        return test(cell1, cell2, expected, true);
    }
}
