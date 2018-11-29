package com.shelydexter;

/*
A media access control address (MAC address) is a unique identifier assigned to
network interfaces for communications on the physical network segment.
The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly
form is six groups of two hexadecimal digits (`0` to `9` or `A` to `F`),
separated by hyphens (e.g. `01-23-45-67-89-AB`).
Your task is to check by given string `inputString` whether it corresponds to
MAC-48 address or not.

Example:
- For `inputString = "00-1B-63-84-45-E6"`, the output should be
`isMAC48Address(inputString) = true`;
- For `inputString = "Z1-1B-63-84-45-E6"`, the output should be
`isMAC48Address(inputString) = false`;
- For `inputString = "not a MAC-48 address"`, the output should be
`isMAC48address(inputString) = false`;

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string inputString
    Guaranteed constraints:
    `15 ≤ inputString.length ≤ 20`.
- [output] boolean
    - `true` if `inputString` corresponds to MAC-48 address naming rules,
    `false` otherwise.
 */

public class IsMAC48Address {

    public static void main(String[] args) {
        test("00-1B-63-84-45-E6", true);
        test("Z1-1B-63-84-45-E6", false);
        test("not a MAC-48 address", false);
        test("FF-FF-FF-FF-FF-FF", true);
        test("00-00-00-00-00-00", true);
        test("G0-00-00-00-00-00", false);
        test("02-03-04-05-06-07-", false);
        test("12-34-56-78-9A-BC", true);
        test("FF-FF-AB-CD-EA-BC", true);
        test("12-34-56-78-9A-BG", false);
    }

    // My answer
    private static boolean isMAC48Address(String inputString) {
        return inputString.matches("([0-9A-F]{2}-){5}[0-9A-F]{2}");
    }

    // Test methods
    private static boolean test(String inputString, boolean expected, boolean verbose) {
        boolean output = isMAC48Address(inputString);
        if (verbose) {
            System.out.println("Input: inputString = " + inputString +
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

    private static boolean test(String inputString, boolean expected) {
        return test(inputString, expected, true);
    }
}
