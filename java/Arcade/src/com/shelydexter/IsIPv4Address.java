package com.shelydexter;

/*
An IP address is a numerical label assigned to each device (e.g., computer,
printer) participating in a computer network that uses the Internet Protocol
for communication. There are two versions of the Internet protocol, and thus
two versions of addresses. One of them is the IPv4 address.
IPv4 addresses are represented in dot-decimal notation, which consists of four
decimal numbers, each ranging from `0` to `255` inclusive, separated by dots,
e.g., `172.16.254.1`.
Given a string, find out if it satisfies the IPv4 address naming rules.

Example:
- For `inputString = "172.16.254.1"`, the output should be
`isIPv4Address(inputString) = true`;
- For `inputString = "172.316.254.1"`, the output should be
`isIPv4Address(inputString) = false`.
`316` is not in range `[0, 255]`.
- For `inputString = ".254.255.0"`, the output should be
`isIPv4Address(inputString) = false`.
There is no first number

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string inputString
    A string consisting of digits, full stops and lowercase English letters.
    Guaranteed constraints:
    `1 ≤ inputString.length ≤ 30`.
- [output] boolean
    - `true` if `inputString` satisfies the IPv4 address naming rules, `false`
    otherwise.
 */

public class IsIPv4Address {

    public static void main(String[] args) {
        test("172.16.254.1", true, true);
        test("172.316.254.1", false, true);
        test(".254.255.0", false, true);
        test("1.1.1.1a", false, true);
        test("1", false, true);
        test("0.254.255.0", true, true);
        test("1.23.256.255", false, true);
        test("1.23.256..", false, true);
        test("0..1.0", false, true);
        test("1.1.1.1.1", false, true);
        test("1.256.1.1", false, true);
        test("a0.1.1.1", false, true);
        test("0.1.1.256", false, true);
        test("129380129831213981.255.255.255", false, true);
        test("255.255.255.255abcdekjhf", false, true);
        test("7283728", false, true);
    }

    // My answer
    private static boolean isIPv4Address(String inputString) {
        String[] inArr = inputString.split("\\.");
        if (inArr.length != 4) return false;
        for (String item: inArr) {
            if (item.isBlank()) return false;
            try {
                int block = Integer.parseInt(item);
                if (block < 0 || block > 255) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private static boolean test(String inputString, boolean expected, boolean verbose) {
        boolean result = isIPv4Address(inputString);
        if (verbose) {
            System.out.println("Input: inputString = " + inputString +
                    "\nOutput: " + result +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (result == expected) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }
}
