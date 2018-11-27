package com.shelydexter;

/*
Each day a plant is growing by `upSpeed` meters. Each night that plant's height
decreases by `downSpeed` meters due to the lack of sun heat. Initially, plant
is 0 meters tall. We plan the seed at the beginning of a day. We want to know
when the height of the plant will reach a certain level.

Example:
For `upSpeed = 100`, `downSpeed = 10`, and `desiredHeight = 910`, the output
should be `growingPlant(upSpeed, downSpeed, desiredHeight) = 10`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer upSpeed
    A positive integer representing the daily growth.
    Guaranteed constraints:
    `3 ≤ upSpeed ≤ 100`.
- [input] integer downSpeed
    A positive integer representing the nightly decline.
    Guaranteed constraints:
    `2 ≤ downSpeec ≤ upSpeed`.
- [input] integer desiredHeight
    A positive integer representing the threshold.
    Guaranteed constraints:
    `4 ≤ desiredHeight ≤ 1000`.
- [output] integer
    - The number of days that it will take for the plant to reach/pass
    `desiredHeight` (including the last day in the total count).
 */

public class GrowingPlant {

    public static void main(String[] args) {
        test(100, 10, 910, 10);
        test(10, 9, 4, 1);
        test(5, 2, 7, 2);
        test(7, 3, 443, 110);
        test(6, 5, 10, 5);
    }

    // My answer
    private static int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        int height = 0;
        int days = 0;
        while (height < desiredHeight) {
            days++;
            height += upSpeed;
            if (height >= desiredHeight) return days;
            height -= downSpeed;
        }
        return days;
    }

    // Test methods
    private static boolean test(int upSpeed, int downSpeed, int desiredHeight, int expected, boolean verbose) {
        int output = growingPlant(upSpeed, downSpeed, desiredHeight);
        if (verbose) {
            System.out.println("Input: upSpeed = " + upSpeed + "; downSpeed = " + downSpeed + "; desiredHeight = " + desiredHeight +
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

    private static boolean test(int upSpeed, int downSpeed, int desiredHeight, int expected) {
        return test(upSpeed, downSpeed, desiredHeight, expected, true);
    }
}
