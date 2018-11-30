package com.shelydexter;

/*
Sudoku is a number-placement puzzle. The objective is to fill a `9 x 9` grid
with digits so that each column, each row, and each of the nine `3 x 3`
sub-grids that compose the grid contains all of the digits from `1` to `9`.
This algorithm should check if the given grid of numbers represents a correct
solution to Sudoku.

Example:
For the first example below, the output should be `true`. For the other grid,
the output should be `false`: each of the nine `3 x 3` sub-grids should contain
all of the digits from `1` to `9`.
Example 1                             Example 2
┌───┬───┬───┬───┬───┬───┬───┬───┬───┐ ┌───┬───┬───┬───┬───┬───┬───┬───┬───┐
│ 1 │ 3 │ 2 │ 5 │ 4 │ 6 │ 9 │ 8 │ 7 │ │ 1 │ 3 │>4<│ 2 │>5<│ 6 │ 9 │ 8 │ 7 │
├───┼───┼───┼───┼───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┼───┼───┼───┼───┤
│ 4 │ 6 │ 5 │ 8 │ 7 │ 9 │ 3 │ 2 │ 1 │ │>4<│ 6 │ 8 │>5<│ 7 │ 9 │ 3 │ 2 │ 1 │
├───┼───┼───┼───┼───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┼───┼───┼───┼───┤
│ 7 │ 9 │ 8 │ 2 │ 1 │ 3 │ 6 │ 5 │ 4 │ │ 7 │ 9 │ 2 │ 8 │ 1 │ 3 │ 6 │ 5 │ 4 │
├───┼───┼───┼───┼───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┼───┼───┼───┼───┤
│ 9 │ 2 │ 1 │ 4 │ 3 │ 5 │ 8 │ 7 │ 6 │ │ 9 │ 2 │>3<│ 1 │>4<│ 5 │ 8 │ 7 │ 6 │
├───┼───┼───┼───┼───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┼───┼───┼───┼───┤
│ 3 │ 5 │ 4 │ 7 │ 6 │ 8 │ 2 │ 1 │ 9 │ │>3<│ 5 │ 7 │>4<│ 6 │ 8 │ 2 │ 1 │ 9 │
├───┼───┼───┼───┼───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┼───┼───┼───┼───┤
│ 6 │ 8 │ 7 │ 1 │ 9 │ 2 │ 5 │ 4 │ 3 │ │ 6 │ 8 │ 1 │ 7 │ 9 │ 2 │ 5 │ 4 │ 3 │
├───┼───┼───┼───┼───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┼───┼───┼───┼───┤
│ 5 │ 7 │ 6 │ 9 │ 8 │ 1 │ 4 │ 3 │ 2 │ │>5<│ 7 │ 6 │ 9 │ 8 │ 1 │ 4 │ 3 │ 2 │
├───┼───┼───┼───┼───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┼───┼───┼───┼───┤
│ 2 │ 4 │ 3 │ 6 │ 5 │ 7 │ 1 │ 9 │ 8 │ │ 2 │ 4 │>5<│ 6 │>3<│ 7 │ 1 │ 9 │ 8 │
├───┼───┼───┼───┼───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┼───┼───┼───┼───┤
│ 8 │ 1 │ 9 │ 3 │ 2 │ 4 │ 7 │ 6 │ 5 │ │ 8 │ 1 │ 9 │>3<│ 2 │ 4 │ 7 │ 6 │ 5 │
└───┴───┴───┴───┴───┴───┴───┴───┴───┘ └───┴───┴───┴───┴───┴───┴───┴───┴───┘

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.array.integer grid
    A matrix representing `9 x 9` grid already filled with numbers from `1` to
    `9`.

- [output] boolean
    - `true` if given grid represents a correct solution to Sudoku, `false`
    otherwise.
 */

import java.util.Arrays;

public class Sudoku {

    public static void main(String[] args) {
        test(new int[][] {{1,3,2,5,4,6,9,8,7},
                          {4,6,5,8,7,9,3,2,1},
                          {7,9,8,2,1,3,6,5,4},
                          {9,2,1,4,3,5,8,7,6},
                          {3,5,4,7,6,8,2,1,9},
                          {6,8,7,1,9,2,5,4,3},
                          {5,7,6,9,8,1,4,3,2},
                          {2,4,3,6,5,7,1,9,8},
                          {8,1,9,3,2,4,7,6,5}}, true);
        test(new int[][] {{1,3,2,5,4,6,9,2,7},
                          {4,6,5,8,7,9,3,8,1},
                          {7,9,8,2,1,3,6,5,4},
                          {9,2,1,4,3,5,8,7,6},
                          {3,5,4,7,6,8,2,1,9},
                          {6,8,7,1,9,2,5,4,3},
                          {5,7,6,9,8,1,4,3,2},
                          {2,4,3,6,5,7,1,9,8},
                          {8,1,9,3,2,4,7,6,5}}, false);
        test(new int[][] {{1,2,3,4,5,6,7,8,9},
                          {1,2,3,4,5,6,7,8,9},
                          {1,2,3,4,5,6,7,8,9},
                          {1,2,3,4,5,6,7,8,9},
                          {1,2,3,4,5,6,7,8,9},
                          {1,2,3,4,5,6,7,8,9},
                          {1,2,3,4,5,6,7,8,9},
                          {1,2,3,4,5,6,7,8,9},
                          {1,2,3,4,5,6,7,8,9}}, false);
        test(new int[][] {{1,3,4,2,5,6,9,8,7},
                          {4,6,8,5,7,9,3,2,1},
                          {7,9,2,8,1,3,6,5,4},
                          {9,2,3,1,4,5,8,7,6},
                          {3,5,7,4,6,8,2,1,9},
                          {6,8,1,7,9,2,5,4,3},
                          {5,7,6,9,8,1,4,3,2},
                          {2,4,5,6,3,7,1,9,8},
                          {8,1,9,3,2,4,7,6,5}}, false);
        test(new int[][] {{1,3,2,5,4,6,9,8,7},
                          {4,6,5,8,7,9,3,2,1},
                          {7,9,8,2,1,3,6,5,4},
                          {9,2,1,4,3,5,8,7,6},
                          {3,5,4,7,6,8,2,1,9},
                          {6,8,7,1,9,2,5,4,3},
                          {5,4,6,9,8,1,4,3,2},
                          {2,7,3,6,5,7,1,9,8},
                          {8,1,9,3,2,4,7,6,5}}, false);
        test(new int[][] {{1,2,3,4,5,6,7,8,9},
                          {4,6,5,8,7,9,3,2,1},
                          {7,9,8,2,1,3,6,5,4},
                          {1,2,3,4,5,6,7,8,9},
                          {4,6,5,8,7,9,3,2,1},
                          {7,9,8,2,1,3,6,5,4},
                          {1,2,3,4,5,6,7,8,9},
                          {4,6,5,8,7,9,3,2,1},
                          {7,9,8,2,1,3,6,5,4}}, false);
        test(new int[][] {{5,3,4,6,7,8,9,1,2},
                          {6,7,2,1,9,5,3,4,8},
                          {1,9,8,3,4,2,5,6,7},
                          {8,5,9,9,6,1,4,2,3},
                          {4,2,6,8,5,3,7,9,1},
                          {7,1,3,7,2,4,8,5,6},
                          {9,6,1,5,3,7,2,8,4},
                          {2,8,7,4,1,9,6,3,5},
                          {3,4,5,2,8,6,1,7,9}}, false);
        test(new int[][] {{5,5,5,5,5,5,5,5,5},
                          {5,5,5,5,5,5,5,5,5},
                          {5,5,5,5,5,5,5,5,5},
                          {5,5,5,5,5,5,5,5,5},
                          {5,5,5,5,5,5,5,5,5},
                          {5,5,5,5,5,5,5,5,5},
                          {5,5,5,5,5,5,5,5,5},
                          {5,5,5,5,5,5,5,5,5},
                          {5,5,5,5,5,5,5,5,5}}, false);
        test(new int[][] {{5,3,4,6,7,8,9,1,2},
                          {6,7,2,3,9,5,3,4,8},
                          {1,9,8,1,4,2,5,6,7},
                          {8,5,9,7,6,1,4,2,3},
                          {4,2,6,8,5,3,7,9,1},
                          {7,1,3,9,2,4,8,5,6},
                          {9,6,1,5,3,7,2,8,4},
                          {2,8,7,4,1,9,6,3,5},
                          {3,4,5,2,8,6,1,7,9}}, false);
        test(new int[][] {{5,3,4,6,7,8,9,1,2},
                          {6,7,2,1,9,5,3,4,8},
                          {1,9,8,3,4,2,5,6,7},
                          {8,5,9,7,6,1,4,2,3},
                          {4,2,6,8,5,3,7,9,1},
                          {7,1,3,9,2,4,8,5,6},
                          {9,6,1,5,3,7,2,8,4},
                          {2,5,7,4,1,9,6,3,5},
                          {3,4,5,2,8,6,1,7,9}}, false);
        test(new int[][] {{1,2,3,4,5,6,7,8,9},
                          {4,5,6,7,8,9,1,2,3},
                          {7,8,9,1,2,3,4,5,6},
                          {2,3,4,5,6,7,8,9,1},
                          {3,4,5,6,7,8,9,1,2},
                          {5,6,7,8,9,1,2,3,4},
                          {6,7,8,9,1,2,3,4,5},
                          {8,9,1,2,3,4,5,6,7},
                          {9,1,2,3,4,5,6,7,8}}, false);
    }

    // My answer
    private static boolean sudoku(int[][] grid) {
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                arr[grid[i][j]-1]++;
                total += grid[i][j];
            }
            if (total != 45) return false;
        }
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                arr[grid[j][i]-1]++;
                total += grid[j][i];
            }
            if (total != 45) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int total = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        arr[grid[(i*3)+k][(j*3)+l]-1]++;
                        total += grid[(i*3)+k][(j*3)+l];
                    }
                }
                if (total != 45) return false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 27) return false;
        }
        return true;
    }

    // Test method
    private static boolean test(int[][] grid, boolean expected) {
        boolean output = sudoku(grid);
        System.out.println("Input: grid = " + matrixToString(grid) +
                "\nOutput: " + output +
                "\nExpected: " + expected);
        System.out.print("Result: ");
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
