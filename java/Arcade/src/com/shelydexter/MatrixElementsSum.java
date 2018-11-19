package com.shelydexter;

/*
After they became famous, the CodeBots all decided to move to a new building
and live together. The building is represented by a rectangular `matrix` of
rooms. Each cell  in the `matrix` contains an integer that represents the price
of the room. Some rooms are free (their cost is `0`), but that's probably
because they are haunted, so all the bots are afraid of them. That is why any
room that is free or is located anywhere below a free room in the same column
is not considered suitable for the bots to live in.
Help the bots calculate the total price of all the rooms that are suitable for
them.

Example:
- For
    `matrix = [[0, 1, 1, 2],
               [0, 5, 0, 0],
               [2, 0, 3, 3]]`
    the output should be `matrixElementsSum(matrix) = 9`.
    Here's the rooms matrix with unsuitable rooms marked with `x`:
    `[[x, 1, 1, 2],
      [x, 5, x, x],
      [x, x, x, x]]`
    Thus, the answer is `1 + 5 + 1 + 2 = 9`.
- For
    `matrix = [[1, 1, 1, 0],
               [0, 5, 0, 1],
               [2, 1, 3, 10]]`
    the output should be `matrixElementsSum(matrix) = 9`.
    Here's the rooms matrix with unsuitable rooms marked with `x`:
    `[[1, 1, 1, x],
      [x, 5, x, x],
      [x, 1, x, x]]`
    Note that the free room in the first row make the full column unsuitable
    for bots.
    Thus, the answer is `1 + 1 + 1 + 5 + 1 = 9`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.array.integer matrix
    A 2-dimensional array of integers representing a rectangular matrix of the
    building.
    Guaranteed constraints:
    `1 ≤ matrix.length ≤ 5`,
    `1 ≤ matrix[i].length ≤ 5`,
    `0 ≤ matrix[i].[j] ≤ 10`.
- [output] integer
    - The total price of all the rooms that are suitable for the CodeBots to
    live in.
 */

public class MatrixElementsSum {

    public static void main(String[] args) {
        test(new int[][] {{0, 1, 1, 2}, {0, 5, 0, 0}, {2, 0, 3, 3}}, 9, true);
        test(new int[][] {{1, 1, 1, 0}, {0, 5, 0, 1}, {2, 1, 3, 10}}, 9, true);
        test(new int[][] {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}, 18, true);
        test(new int[][] {{0}}, 0, true);
    }

    // My answer
    private static int matrixElementsSum(int[][] matrix) {
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int item = 0; item < matrix[row].length; item++) {
                if (row == 0) {
                    total += matrix[row][item];
                    continue;
                }
                if (matrix[row-1][item] == 0) {
                    matrix[row][item] = 0;
                }
                total += matrix[row][item];
            }
        }
        return total;
    }

    // Test method
    private static boolean test(int[][] matrix, int expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: matrix = " + matrixToString(matrix) +
                    "\nOutput: " + matrixElementsSum(matrix) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (matrixElementsSum(matrix) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static String matrixToString(int[][] matrix) {
        String matrixString = "[";
        for (int i = 0; i < matrix.length; i++) {
            matrixString += "[";
            for (int j = 0; j < matrix[i].length; j++) {
                if (j != matrix[i].length-1) {
                    matrixString += matrix[i][j] + ", ";
                } else {
                    matrixString += matrix[i][j];
                }
            }
            if (i != matrix.length-1) {
                matrixString += "], ";
            } else {
                matrixString += "]";
            }
        }
        matrixString += "]";
        return matrixString;
    }
}
