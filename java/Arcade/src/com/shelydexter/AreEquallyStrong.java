package com.shelydexter;

/*
Call two arms equally strong if the heaviest weights they each are able to lift
are equal.
Call two people equally strong if their strongest arms are equally strong (the
arm can be both the right and the left), and so are their weakest arms.
Given your and your friend's arms' lifting capabilities find out if you two are
equally strong.

Example:
- For `yourLeft = 10`, `yourRight = 15`, `friendsLeft = 15`, and
`friendsRight = 10`, the output should be
`areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight) = true`;
- For `yourLeft = 15`, `yourRight = 10`, `friendsLeft = 15`, and
`friendsRight = 10`, the output should be
`areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight) = true`;
- For `yourLeft = 15`, `yourRight = 10`, `friendsLeft = 15`, and
`friendsRight = 9`, the output should be
`areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight) = false`;

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer yourLeft
    A non-negative integer representing the heaviest weight you can lift with
    your left arm.
    Guaranteed constraints:
    `0 ≤ yourLeft ≤ 20`.
- [input] integer yourRight
    A non-negative integer representing the heaviest weight you can lift with
    your right arm.
    Guaranteed constraints:
    `0 ≤ yourRight ≤ 20`.
- [input] integer friendsLeft
    A non-negative integer representing the heaviest weight your friend can
    lift with his or her left arm.
    Guaranteed constraints:
    `0 ≤ friendsLeft ≤ 20`.
- [input] integer friendsRight
    A non-negative integer representing the heaviest weight your friend can
    lift with his or her right arm.
    Guaranteed constraints:
    `0 ≤ friendsRight ≤ 20`.
- [output] boolean
    - `true` if you and your friend are equally strong, `false` otherwise.
 */

public class AreEquallyStrong {

    public static void main(String[] args) {
        test(10, 15, 15, 10, true, true);
        test(15, 10, 15, 10, true, true);
        test(15, 10, 15, 9, false, true);
        test(10, 5, 5, 10, true, true);
        test(10, 15, 5, 20, false, true);
        test(10, 20, 10, 20, true, true);
        test(5, 20, 20, 5, true, true);
        test(20, 15, 5, 20, false, true);
        test(5, 10, 5, 10, true, true);
        test(1, 10, 10, 0, false, true);
        test(5, 5, 10, 10, false, true);
        test(10, 5, 10, 6, false, true);
        test(1, 1, 1, 1, true, true);
        test(0, 10, 10, 0, true, true);
    }

    // My answer
    private static boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        int yourDominant = 0;
        int friendsDominant = 0;
        if (yourLeft > yourRight) {
            yourDominant = yourLeft;
        } else {
            yourDominant = yourRight;
        }
        if (friendsLeft > friendsRight) {
            friendsDominant = friendsLeft;
        } else {
            friendsDominant = friendsRight;
        }
        if (yourDominant != friendsDominant) return false;
        return yourLeft + yourRight == friendsLeft + friendsRight;
    }

    // Test method
    private static boolean test(int yourLeft, int yourRight, int friendsLeft, int friendsRight, boolean expected, boolean verbose) {
        boolean result = areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight);
        if (verbose) {
            System.out.println("Input: yourLeft = " + yourLeft + "; yourRight = " + yourRight + "; friendsLeft = " + friendsLeft + "; friendsRight = " + friendsRight +
                    "\nOutput: " + result +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if(result == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
