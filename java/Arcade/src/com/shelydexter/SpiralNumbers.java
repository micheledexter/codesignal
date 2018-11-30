package com.shelydexter;

/*
Construct a square matrix with a size `N x N` containing integers from `1` to
`N * N` in a spiral order, starting from top-left and in clockwise direction.

Example:
For `n = 3`, the output should be
    `spiralNumbers(n) = [[1, 2, 3],
                         [8, 9, 4],
                         [7, 6, 5]]`

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer n
    Matrix size, a positive integer.
    Guaranteed constraints:
    `3 ≤ n ≤ 100`.
- [output] array.array.integer
 */

public class SpiralNumbers {

    public static void main(String[] args) {
        test(3, new int[][] {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}});
        test(5, new int[][] {{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}});
        test(6, new int[][] {{1, 2, 3, 4, 5, 6}, {20, 21, 22, 23, 24, 7}, {19, 32, 33, 34, 25, 8}, {18, 31, 36, 35, 26, 9}, {17, 30, 29, 28, 27, 10}, {16, 15, 14, 13, 12, 11}});
        test(7, new int[][] {{1, 2, 3, 4, 5, 6, 7}, {24, 25, 26, 27, 28, 29, 8}, {23, 40, 41, 42, 43, 30, 9}, {22, 39, 48, 49, 44, 31, 10}, {21, 38, 47, 46, 45, 32, 11}, {20, 37, 36, 35, 34, 33, 12}, {19, 18, 17, 16, 15, 14, 13}});
        test(10, new int[][] {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {36, 37, 38, 39, 40, 41, 42, 43, 44, 11}, {35, 64, 65, 66, 67, 68, 69, 70, 45, 12}, {34, 63, 84, 85, 86, 87, 88, 71, 46, 13}, {33, 62, 83, 96, 97, 98, 89, 72, 47, 14}, {32, 61, 82, 95, 100, 99, 90, 73, 48, 15}, {31, 60, 81, 94, 93, 92, 91, 74, 49, 16}, {30, 59, 80, 79, 78, 77, 76, 75, 50, 17}, {29, 58, 57, 56, 55, 54, 53, 52, 51, 18}, {28, 27, 26, 25, 24, 23, 22, 21, 20, 19}});
    }

    // My answer
    private static int[][] spiralNumbers(int n) {
        int[][] spiral = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                spiral[i][j] = 0;
            }
        }
        String dir = "right";
        int i = 0;
        int j = 0;
        for (int c = 1; c <= n * n; c++) {
            spiral[i][j] = c;
            boolean okay = false;
            switch (dir) {
                case "right":
                    try {
                        if (spiral[i][j+1] == 0) {
                            okay = true;
                            j++;
                        }
                    } catch (Exception e) {
                        okay = false;
                    }
                    break;
                case "down":
                    try {
                        if (spiral[i+1][j] == 0) {
                            okay = true;
                            i++;
                        }
                    } catch (Exception e) {
                        okay = false;
                    }
                    break;
                case "left":
                    try {
                        if (spiral[i][j-1] == 0) {
                            okay = true;
                            j--;
                        }
                    } catch (Exception e) {
                        okay = false;
                    }
                    break;
                case "up":
                    try {
                        if (spiral[i-1][j] == 0) {
                            okay = true;
                            i--;
                        }
                    } catch (Exception e) {
                        okay = false;
                    }
                    break;
            }
            if (!okay) {
                switch (dir) {
                    case "right":
                        dir = "down";
                        i++;
                        break;
                    case "down":
                        dir = "left";
                        j--;
                        break;
                    case "left":
                        dir = "up";
                        i--;
                        break;
                    case"up":
                        dir = "right";
                        j++;
                        break;
                }
            }
        }
        return spiral;
    }

    // Test method
    private static boolean test(int n, int[][] expected) {
        int[][] output = spiralNumbers(n);
        System.out.println("Input: n = " + n +
                "\nOutput: " + matrixToString(output) +
                "\nExpected: " + matrixToString(expected));
        System.out.print("Result: ");
        if (matricesAreEqual(output, expected)) {
            System.out.println("SUCCESSFUL\n");
            return true;
        } else {
            System.out.println("!--- FAILED ---!\n");
            return false;
        }
    }

    // Support methods
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
