package com.shelydexter;

/*
In the popular Minesweeper game you have a board with some mines and those
cells that don't contain a mine have a number in it that indicates the total
number of mines in the neighboring cells. Starting off with some arrangement of
mines we want to create a Minesweeper game setup.

Example:
For
`matrix = [[true, false, false],
           [false, true, false],
           [false, false, false]]`
the output should be
`minesweeper(matrix) = [[1, 2, 1],
                        [2, 1, 1],
                        [1, 1, 1]]`
Check out the image below for a better understanding:
┌───┬───┬───┐   ┌───┬───┬───┐
│ * │   │   │   │ 1 │ 2 │ 1 │
├───┼───┼───┤   ├───┼───┼───┤
│   │ * │   │-->│ 2 │ 1 │ 1 │
├───┼───┼───┤   ├───┼───┼───┤
│   │   │   │   │ 1 │ 1 │ 1 │
└───┴───┴───┘   └───┴───┴───┘

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.array.boolean matrix
    A non-empty rectangular matrix consisting of boolean values - `true` if the
    corresponding cell contains a mine, `false` otherwise.
    Guaranteed constraints:
    `2 ≤ matrix.length ≤ 100`,
    `2 ≤ matrix[0].length ≤ 100`.
- [output] array.array.integer
    - Rectangular matrix of the same size as `matrix` each cell of which
    contains an integer equal to the number of mines in the neighboring cells.
    Two cells are called neighboring if they share at least one corner.
 */

public class Minesweeper {

    public static void main(String[] args) {
        test(new boolean[][] {{true, false, false}, {false, true, false}, {false, false, false}}, new int[][] {{1, 2, 1}, {2, 1, 1}, {1, 1, 1}}, true);
        test(new boolean[][] {{false, false, false}, {false, false, false}}, new int[][] {{0, 0, 0}, {0, 0, 0}}, true);
        test(new boolean[][] {{true, false, false, true}, {false, false, true, false}, {true, true, false, true}}, new int[][] {{0, 2, 2, 1}, {3, 4, 3, 3}, {1, 2, 3, 1}}, true);
        test(new boolean[][] {{true, true, true}, {true, true, true}, {true, true, true}}, new int[][] {{3, 5, 3}, {5, 8, 5}, {3, 5, 3}}, true);
        test(new boolean[][] {{false, true, true, false}, {true, true, false, true}, {false, false, true, false}}, new int[][] {{3, 3, 3, 2}, {2, 4, 5, 2}, {2, 3, 2, 2}}, true);
        test(new boolean[][] {{true, false}, {true, false}, {false, true}, {false, false}, {false, false}}, new int[][] {{1, 2}, {2, 3}, {2, 1}, {1, 1}, {0, 0}}, true);
    }

    // My answer
    private static int[][] minesweeper(boolean[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] board = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int counter = 0;
                if (i > 0) {
                    if (j > 0 && matrix[i-1][j-1]) counter++;
                    if (matrix[i-1][j]) counter++;
                    if (j < cols-1 && matrix[i-1][j+1]) counter++;
                }
                if (j > 0 && matrix[i][j-1]) counter++;
                if (j < cols-1 && matrix[i][j+1]) counter++;
                if (i < rows-1) {
                    if (j > 0 && matrix[i+1][j-1]) counter++;
                    if (matrix[i+1][j]) counter++;
                    if (j < cols-1 && matrix[i+1][j+1]) counter++;
                }
                board[i][j] = counter;
            }
        }
        return board;
    }

    // Test method
    private static boolean test(boolean[][] matrix, int[][] expected, boolean verbose) {
        int[][] output = minesweeper(matrix);
        if (verbose) {
            System.out.println("Input: matrix = " + matrixToString(matrix) +
                    "\nOutput: " + matrixToString(output) +
                    "\nExpected: " + matrixToString(expected));
            System.out.print("Result: ");
        }
        if (matricesAreEqual(output, expected)) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static String matrixToString(boolean[][] matrix) {
        String output = "[";
        for (int i = 0; i < matrix.length; i++) {
            output += "[";
            for (int j = 0; j < matrix[i].length; j++) {
                output += matrix[i][j];
                if (j != matrix[i].length-1) output += ", ";
            }
            output += "]";
            if (i != matrix.length-1) output += ", ";
        }
        return output + "]";
    }

    private static String matrixToString(int[][] matrix) {
        String output = "[";
        for (int i = 0; i < matrix.length; i++) {
            output += "[";
            for (int j = 0; j < matrix[i].length; j++) {
                output += matrix[i][j];
                if (j != matrix[i].length-1) output += ", ";
            }
            output += "]";
            if (i != matrix.length -1) output += ", ";
        }
        return output + "]";
    }

    private static boolean matricesAreEqual(int[][] first, int[][] second) {
        if (first.length != second.length || first[0].length != second[0].length) return false;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                if (first[i][j] != second[i][j]) return false;
            }
        }
        return true;
    }
}
