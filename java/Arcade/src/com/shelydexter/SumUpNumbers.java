package com.shelydexter;

/*
CodeMaster has just returned from shopping. He scanned the check of the items
he bought and gave the resulting string to Ratiorg to figure out the total
number of purchased items. Since Ratiorg is a bot he is definitely going to
automate it, so he needs a program that sums up all the numbers which appear
in the given input.
Help Ratiorg by writing a function that returns the sum of numbers that appear
in the given `inputString`.

Example:
For `inputString = "2 apples, 12 oranges"`, the output should be
`sumUpNumbers(inputString) = 14`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string inputString
    Guaranteed constraints:
    `6 ≤ inputString.length ≤ 60`.
- [output] integer
 */

public class SumUpNumbers {

    public static void main(String[] args) {
        test("2 apples, 12 oranges", 14);
        test("123450", 123450);
        test("Your payment method is invalid", 0);
        test("no digits at all", 0);
        test("there are some (12) digits 5566 in this 770 string 239", 6587);
    }

    // My answer
    private static int sumUpNumbers(String inputString) {
        String[] items = inputString.split("[^0-9]");
        int total = 0;
        for (String item: items) {
            if (item.length() > 0) {
                total += Integer.parseInt(item);
            }
        }
        return total;
    }

    // Test method
    private static boolean test(String inputString, int expected) {
        int output = sumUpNumbers(inputString);
        System.out.println("Input: inputString = " + inputString +
                "\nOutput: " + output +
                "\nExpected: " + expected);
        System.out.print("Result: ");
        if (output == expected) {
            System.out.println("SUCCESSFUL\n");
            return true;
        } else {
            System.out.println("!--- FAILED ---!\n");
            return false;
        }
    }
}
