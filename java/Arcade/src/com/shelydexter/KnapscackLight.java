package com.shelydexter;

/*
You found two items in a treasure chest! The first item weighs `weight1` and is
worth `value1`, and the second item weighs `weight2` and is worth `value2`.
What is the total maximum value of the items you can take with you, assuming
that your max weight capacity is `maxW` and you can't come back for the items
later?
Note that there are only two items and you can't bring more than one item of
each type, i.e. you can't take two first items or two second items.

Example:
For `value1 = 10`, `weight1 = 5`, `value2 = 6`, `weight2 = 4`, and `maxW = 8`,
the output should be
`knapsackLight(value1, weight1, value2, weight2, maxW) = 10`.
You can only carry the first item.
For `value1 = 10`, `weight1 = 5`, `value2 = 6`, `weight2 = 4`, and `maxW = 9`,
the output should be
`knapsackLight(value1, weight1, value2, weight2, maxW) = 16`.
You're strong enough to take both of the items with you.
For `value1 = 5`, `weight1 = 3`, `value2 = 7`, `weight2 = 4`, and `maxW = 6`,
the output should be
`knapsackLight(value1, weight1, value2, weight2, maxW) = 7`.
You can't take both items, but you can take any of them.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer value1
    Guaranteed constraints:
    `2 ≤ value1 ≤ 20`.
- [input] integer weight1
    Guaranteed constraints:
    `2 ≤ weight1 ≤ 10`.
- [input] integer value2
    Guaranteed constraints:
    `2 ≤ value2 ≤ 20`.
- [input] integer weight2
    Guaranteed constraints:
    `2 ≤ weight2 ≤ 10`.
- [input] integer maxW
    Guaranteed constraints:
    `1 ≤ maxW ≤ 20`.
- [output] integer
 */

public class KnapscackLight {

    public static void main(String[] args) {
        test(10, 5, 6, 4, 8, 10);
        test(10, 5, 6, 4, 9, 16);
        test(5, 3, 7, 4, 6, 7);
        test(10, 2, 11, 3, 1, 0);
        test(15, 2, 20, 3, 2, 15);
        test(2, 5, 3, 4, 5, 3);
        test(4, 3, 3, 4, 4, 4);
        test(3, 5, 3, 8, 10, 3);
    }

    // My answer
    private static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        if (weight1 + weight2 <= maxW) return value1 + value2;
        if (value1 >= value2 && weight1 <= maxW) return value1;
        if (value2 >= value1 && weight2 <= maxW) return value2;
        if (value2 >= value2 && weight1 <= maxW) return value1;
        return 0;
    }

    // Test methods
    private static boolean test(int value1, int weight1, int value2, int weight2, int maxW, int expected, boolean verbose) {
        int output = knapsackLight(value1, weight1, value2, weight2, maxW);
        if (verbose) {
            System.out.println("Input: value1 = " + value1 + "; weight1 = " + weight1 + "; value2 = " + value2 + "; weight2 = " + weight2 + "; maxW = " + maxW +
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

    private static boolean test(int value1, int weight1, int value2, int weight2, int maxW, int expected) {
        return test(value1, weight1, value2, weight2, maxW, expected, true);
    }
}
