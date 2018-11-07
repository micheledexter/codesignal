package com.shelydexter;

/*
Given a year, return the century it is in. The first century spans from the
year 1 up to and including the year 100, the second - from the year 101 up to
and including the year 200, etc.

Example:
- For `year = 1905`, the output should be `centuryFromYear(year) = 20`;
- For `year = 1700`, the output should be `centuryFromYear(year) = 17`.

Input/Output
- [execution time limit] 3 seconds (java)
- [input] integer year
    A positive integer, designating the year.
    Guaranteed constraints:
    `1 ≤ year ≤ 2005`.
- [output] integer
    - The number of the century the year is in.
 */

public class Main {

    public static void main(String[] args) {
        test(1905, 20, true);
        test(1700, 17, true);
        test(1988, 20, true);
        test(2000, 20, true);
        test(2001, 21, true);
        test(200, 2, true);
        test(374, 4, true);
        test(45, 1, true);
        test(8, 1, true);
    }

    private static int centuryFromYears(int year) {
        return ((year - 1) / 100) + 1;
    }

    private static boolean test(int year, int expected, boolean verbose) {
        if (verbose) {
            System.out.println("Input: year = " + year +
                    "\nOutput: " + centuryFromYears(year) +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (centuryFromYears(year) == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
