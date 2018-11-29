package com.shelydexter;

/*
Given a rectangular matrix containing only digits, calculate the number of
different `2 x 2` squares in it.

Example:
for
    `matrix = [[1, 2, 1],
               [2, 2, 2],
               [2, 2, 2],
               [1, 2, 3],
               [2, 2, 1]]`
the output should be `differentSquares(matrix) = 6`.
Here are all `6` different `2 x 2` squares:
* 1 2
  2 2
* 2 1
  2 2
* 2 2
  2 2
* 2 2
  1 2
* 2 2
  2 3
* 2 3
  2 1

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.array.integer matrix
    Guaranteed constraints:
    `1 ≤ matrix.length ≤ 100`,
    `1 ≤ matrix[i].length ≤ 100`,
    `0 ≤ matrix[i][j] ≤ 9`.
- [output] integer
    - The number of different `2 x 2` squares in `matrix`
 */

import java.util.HashMap;

public class DifferentSquares {

    public static void main(String[] args) {
        test(new int[][] {{1, 2, 1}, {2, 2, 2}, {2, 2, 2}, {1, 2, 3}, {2, 2, 1}}, 6);
        test(new int[][] {{9, 9, 9, 9, 9}, {9, 9, 9, 9, 9}, {9, 9, 9, 9, 9}, {9, 9, 9, 9, 9}, {9, 9, 9, 9, 9}}, 1);
        test(new int[][] {{3}}, 0);
        test(new int[][] {{3, 4, 5, 6, 7, 8, 9}}, 0);
        test(new int[][] {{3}, {4}, {5}, {6}, {7}}, 0);
        test(new int[][] {{2, 5, 3, 4, 3, 1, 3, 2}, {4, 5, 4, 1, 2, 4, 1, 3}, {1, 1, 2, 1, 4, 1, 1, 5}, {1, 3, 4, 2, 3, 4, 2, 4}, {1, 5, 5, 2, 1, 3, 1, 1}, {1, 2, 3, 3, 5, 1, 2, 4}, {3, 1, 4, 4, 4, 1, 5, 5}, {5, 1, 3, 3, 1, 5, 3, 5}, {5, 4, 4, 3, 5, 4, 4, 4}}, 54);
        test(new int[][] {{1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 9, 9, 9, 2, 3, 9}}, 0);
    }

    // My answer
    private static int differentSquares(int[][] matrix) {
        if (matrix.length < 2 || matrix[0].length < 2) return 0;
        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                String check = "" + matrix[i-1][j-1] + matrix[i-1][j] + matrix[i][j-1] + matrix[i][j];
                try {
                    if (map.get(check)) continue;
                } catch (Exception e) {
                    map.put(check, true);
                }
            }
        }
        return map.size();
    }

    // Test method
    private static boolean test(int[][] matrix, int expected) {
        int output = differentSquares(matrix);
        System.out.println("Input = " + matrixToString(matrix) +
                "\nOutput: " + output +
                "\nExpected: " + expected);
        if (output == expected) {
            System.out.println("SUCCESSFUL\n");
            return true;
        } else {
            System.out.println("!--- FAILED ---!\n");
            return false;
        }
    }

    // Support method
    private static String matrixToString(int[][] matrix) {
        String output = "[";
        for (int i = 0; i < matrix.length; i++) {
            output += "[";
            for (int j = 0; j < matrix[i].length; j++) {
                output += matrix[i][j];
                if (j < matrix[i].length-1) output += ", ";
            }
            output += "]";
            if (i < matrix.length-1) output += ", ";
        }
        output += "]";
        return output;
    }
}
