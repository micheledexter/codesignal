package com.shelydexter;

/*
Ratiorg got `statues` of different sizes as a present from CodeMaster for his
birthday, each statue having a non-negative integer size. Since he likes to
make things perfect, he wants to arrange them from smallest to largest so that
each statue will be bigger than the previous one exactly by `1`. He may need
some additional statues to be able to accomplish that. Help him figure out the
minimum number of additional statues needed.

Example:
For `statues = [6, 2, 3, 8], the output should be
`makeArrayConsecutive2(statues) = 3`.
Ratiorg needs statues of sizes `4`, `5`, and `7`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.integer statues
    An array of distinct non-negative integers.
    Guaranteed constraints:
    `1 ≤ statues.length ≤ 10`,
    `0 ≤ statues[i] ≤ 20`.
- [output] integer
    - The minimal number of statues that need to be added to existing
    `statues` such that it contains every integer size from an interval
    `[L, R]` (for some `L, R`) and no other sizes.
 */

import java.util.Arrays;

public class MakeArrayConsecutive2 {

    public static void main(String[] args) {
        test(new int[] {6, 2, 3, 8}, 3, true);
        test(new int[] {0, 3}, 2, true);
        test(new int[] {5, 4, 6}, 0, true);
        test(new int[] {6, 3}, 2, true);
        test(new int[] {1}, 0, true);
    }

    // My answer
    public static int makeArrayConsecutive2(int[] statues) {
        if (statues.length < 2) return 0;
        int highest = statues[0];
        int lowest = statues[0];
        for (int statue: statues) {
            if (statue > highest) highest = statue;
            if (statue < lowest) lowest = statue;
        }
        return (highest - lowest) - (statues.length - 1);
    }

    // Test method
    public static boolean test(int[] statues, int expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: statues = " + Arrays.toString(statues) +
                    "\nOutput: " + makeArrayConsecutive2(statues) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (makeArrayConsecutive2(statues) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
