package com.shelydexter;

/*
Last night you partied a little too hard. Now there's a black and white photo
of you that's about to go viral! You can't let this ruin your reputation, so
you want to apply the box blur algorithm to the photo to hide its content.
The pixels in the input image are represented as integers. The algorithm
distorts the input image in the following way: Every pixel `x` in the output
image has a value equal to the average value of the pixel values from the
`3 x 3` square that has its center at `x`, including `x` itself. All the pixels
on the border of `x` are then removed.
Return the blurred image as an integer, with the fractions rounded down.

Example:
For
`image = [[1, 1, 1],
          [1, 7, 1],
          [1, 1, 1]]`
the output should be `boxBlur(image) = [[1]]`.
To get the value of the middle pixel in the input `3 x 3` square:
`(1 + 1 + 1 + 1 + 7 + 1 + 1 + 1 + 1) = 15 / 9 = 1.66666 = 1`. The border pixels
are cropped from the final result.
For
`image = [[7, 4, 0, 1],
          [5, 6, 2, 2],
          [6, 10, 7, 8],
          [1, 4, 2, 0]]`
the output should be
`boxBlur(image) = [[5, 4],
                   [4, 4]]`
There are four `3 x 3` squares in the input image, so there should be four
integers in the blurred output. To get the first value:
`(7 + 4 + 0 + 5 + 6 + 2 + 6 + 10 + 7) = 47 / 9 = 5.2222 = 5`. The other three
integers are obtained the same way, then the surrounding integers are cropped
from the final result.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.array.integer image
    An image, stored as a rectangular matrix of non-negative integers.
    Guaranteed constraints:
    `3 ≤ image.length ≤ 10`,
    `3 ≤ image[0].length ≤ 10`,
    `0 ≤ image[i][j] ≤ 255`.
- [output] array.array.integer
    - A blurred image represented as integers, obtained through the process in
    the description.
 */

public class BoxBlur {

    public static void main(String[] args) {
        test(new int[][] {{1, 1, 1}, {1, 7, 1}, {1, 1, 1}}, new int[][] {{1}}, true);
        test(new int[][] {{0, 18, 9}, {27, 9, 0}, {81, 63, 45}}, new int[][] {{28}}, true);
        test(new int[][] {{36, 0, 18, 9}, {27, 54, 9, 0}, {81, 63, 72, 45}}, new int[][] {{40, 30}}, true);
        test(new int[][] {{7, 4, 0, 1}, {5, 6, 2, 2}, {6, 10, 7, 8}, {1, 4, 2, 0}}, new int[][] {{5, 4}, {4, 4}}, true);
        test(new int[][] {{36, 0, 18, 9, 9, 45, 27}, {27, 0, 54, 9, 0, 63, 90}, {81, 63, 72, 45, 18, 27, 0}, {0, 0, 9, 81, 27, 18, 45}, {45, 45, 27, 27, 90, 81, 72}, {45, 18, 9, 0, 9, 18, 45}, {27, 81, 36, 63, 63, 72, 81}}, new int[][] {{39, 30, 26, 25, 31}, {34, 37, 35, 32, 32}, {38, 41, 44, 46, 42}, {22, 24, 31, 39, 45}, {37, 34, 36, 47, 59}}, true);
    }

    // My answer
    private static int[][] boxBlur(int[][] image) {
        int rowSize = image.length-2;
        int colSize = image[0].length-2;
        int[][] blur = new int[rowSize][colSize];
        int[][] m = image.clone();
        for (int i = 1; i < m.length-1; i++) {
            for (int j = 1; j < m[i].length-1; j++) {
                int total = m[i-1][j-1] + m[i-1][j] + m[i-1][j+1] +
                        m[i][j-1] + m[i][j] + m[i][j+1] +
                        m[i+1][j-1] + m[i+1][j] + m[i+1][j+1];
                blur[i-1][j-1] = total / 9;
            }
        }
        return blur;
    }

    // Test method
    private static boolean test(int[][] image, int[][] expected, boolean verbose) {
        int[][] output = boxBlur(image);
        if (verbose) {
            System.out.println("Input: " + intMatrixToString(image) +
                    "\nOutput: " + intMatrixToString(output) +
                    "\nExpected: " + intMatrixToString(expected));
            System.out.print("Result: ");
        }
        if (matricesAreEqual(output, expected)) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static String intMatrixToString(int[][] matrix) {
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
