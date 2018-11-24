package com.shelydexter;

/*
You are given an array of integers representing coordinates of obstacles
situated on a straight line.
Assume that you are jumping from the point with coordinate `0` to the right.
You are allowed only to make jumps of the same length represented by some
integer.
Find the minimal length of the jump enough to avoid all the obstacles.

Example:
For `inputArray = [5, 3, 6, 7, 9]`, the output should be
`avoidObstacles(inputArray) = 4`.
Check out the image below for better understanding:
 ./˙˙˙˙˙\./˙˙˙˙˙\./˙˙˙˙
–––––––+–––+–+–+–––+–––
 0 1 2 3 4 5 6 7 8 9 10

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.integer inputArray
    Non-empty array of positive integers.
    Guaranteed constraints:
    `2 ≤ inputArray.length ≤ 1000`,
    `1 ≤ inputArray[i] ≤ 1000`.
- [output] integer
    - The desired length.
 */

import java.util.Arrays;

public class AvoidObstacles {

    public static void main(String[] args) {
        test(new int[] {5, 3, 6, 7, 9}, 4, true);
        test(new int[] {2, 3}, 4, true);
        test(new int[] {1, 4, 10, 6, 2}, 7, true);
        test(new int[] {1000, 999}, 6, true);
        test(new int[] {19, 32, 11, 23}, 3, true);
        test(new int[] {5, 8, 9, 13, 14}, 6, true);
    }

    // My answer
    private static int avoidObstacles(int[] inputArray) {
        int counter = 1;
        boolean searching = true;
        while (searching) {
            counter++;
            searching = false;
            for(int num: inputArray) {
                if (num % counter == 0) {
                    searching = true;
                    break;
                }
            }
        }
        return counter;
    }

    // Test method
    private static boolean test(int[] inputArray, int expected, boolean verbose) {
        int output = avoidObstacles(inputArray);
        if (verbose) {
            System.out.println("Input: inputArray = " + Arrays.toString(inputArray) +
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
}
