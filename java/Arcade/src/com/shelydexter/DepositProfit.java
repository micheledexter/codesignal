package com.shelydexter;

/*
You have deposited a specific amount of money into your bank account. Each year
your balance increases at the same growth `rate`. With the assumption that you
don't make any additional deposits, find out how long it would take for your
balance to pass a specific `threshold`. of course you don't want to wait too
long, so you know that the answer is not greater than `6`.

Example:
For `deposit = 100`, `rate = 20`, and `threshold = 170`, the output should be
`depositProfit(deposit, rate, threshold) = 3`.
Each year the amount of money in your account increases by `20%`. So throughout
the years, your balance would be:
* year 0: `100`;
* year 1: `120`;
* year 2: `144`;
* year 3: `172.8.
Thus, it will take `3` years for your balance to pass the `threshold`, so the
answer is `3`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer deposit
    The initial deposit, guaranteed to be a positive integer.
    Guaranteed constraints:
    `1 ≤ deposit ≤ 100`.
- [input] integer rate
    The rate of increase. Each year the balance increases by the `rate` percent
    of the current sum.
    Guarantee constraints:
    `1 ≤ rate ≤ 100`.
- [input] integer threshold
    The target balance.
    Guaranteed constraints:
    `deposit < threshold ≤ 200`.
- [output] integer
    - The number of years it would take to hit the `threshold`.
 */

public class DepositProfit {

    public static void main(String[] args) {
        test(100, 20, 170, 3);
        test(100, 1, 101, 1);
        test(1, 100, 64, 6);
        test(20, 20, 50, 6);
        test(50, 25, 100, 4);
    }

    // My answer
    private static int depositProfit(int deposit, int rate, int threshold) {
        double account = deposit;
        int years = 0;
        while (account < threshold) {
            account *= (1+((double)rate / 100));
            years++;
        }
        return years;
    }

    // Test method
    private static boolean test(int deposit, int rate, int threshold, int expected, boolean verbose) {
        int output = depositProfit(deposit, rate, threshold);
        if (verbose) {
            System.out.println("Input: deposit = " + deposit + "; rate = " + rate + "; threshold = " + threshold +
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

    private static boolean test(int deposit, int rate, int threshold, int expected) {
        return test(deposit, rate, threshold, expected, true);
    }
}
