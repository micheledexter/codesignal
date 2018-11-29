package com.shelydexter;

/*
Given an integer `product`, find the smallest positive (i.e. greater than `0`)
integer the product of whose digits is equal to `product`. If there is no such
integer, return `-1` instead.

Example:
- For `product = 12`, the output should be `digitsProduct(product) = 26`;
- For `product = 19`, the output should be `digitsProduct(product) = -1`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] integer product
    Guaranteed constraints:
    `0 ≤ product ≤ 600`.
- [output] integer
 */

public class DigitsProduct {

    public static void main(String[] args) {
        test(12, 26);
        test(19, -1);
        test(450, 2559);
        test(0, 10);
        test(13, -1);
        test(1, 1);
        test(243, 399);
        test(576, 889);
        test(360, 589);
    }

    // My answer
    private static int digitsProduct(int product) {
        if (product == 0) return 10;
        if (product == 1) return 1;
        String total = "";
        while (product > 1) {
            boolean found = false;
            for (int i = 9; i > 1; i--) {
                if (product % i == 0) {
                    total = i + total;
                    product /= i;
                    found = true;
                    break;
                }
            }
            if (!found) return -1;
        }
        return Integer.parseInt(total);
    }

    // Test method
    private static boolean test(int product, int expected) {
        int output = digitsProduct(product);
        System.out.println("Input: product = " + product +
                "\nOutput = " + output +
                "\nExpected = " + expected);
        System.out.print("Result: ");
        if (output == expected) {
            System.out.println("SUCCESSFUL\n");
            return true;
        }
        System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
