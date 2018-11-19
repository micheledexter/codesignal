package com.shelydexter;

/*
Below we will define an `n`-interesting polygon. Your task is to find the area
of a polygon for a given `n`.
A `1`-interesting polygon is just a square with a side of length `1`. An
`n`-interesting polygon is obtained by taking the `n - 1`-interesting
polygon and appending `1`-interesting polygons to its rim, side by side. You
can see the `1`-, `2`-, `3`- and `4`-interesting polygons in the picture
below.
                #
         #     ###
    #   ###   #####
 # ### ##### #######
    #   ###   #####
         #     ###
                #
 1  2    3      4

Example:
- For `n = 2`, the output should be `shapeArea(n) = 5`;
- For `n = 3`, the output should be `shapeArea(n) = 13`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer n
    Guaranteed constraints:
    `1 ≤ n < 10^4`.
- [output] integer
    - The area of the `n`-interesting polygon.
 */

public class ShapeArea {

    public static void main(String[] args) {
        test(2, 5, true);
        test(3, 13, true);
        test(1, 1, true);
        test(5, 41, true);
    }

    // My answer
    private static int shapeArea(int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += i * 4;
        }
        return total + 1;
    }

    // Test method
    private static boolean test(int n, int expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: n = " + n +
                    "\nOutput: " + shapeArea(n) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (shapeArea(n) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}