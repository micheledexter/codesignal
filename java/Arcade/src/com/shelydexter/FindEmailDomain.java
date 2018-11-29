package com.shelydexter;

/*
An email address such as `"John.Smith@example.com"` is made up of a local part
(`"John.Smith"`), an `"@"` symbol, then a domain part (`"example.com"`).
The domain part of an email address may only consist of letters, digits,
hyphens and dots. The local part, however, also allows a lot of different
special characters. Here (https://en.wikipedia.org/wiki/Email_address#Examples)
you can look at several examples of correct and incorrect email addresses.
Given a valid email address, find its domain part.

Example:
For `address = "prettyandsimple@example.com"`, the output should be
`findEmailDomain(address) = "example.com";
For `address = "<>[]:,;@"!#$%&*+-/=?^_{}|~.a"@example.org"`, the output should
be `findEmailDomain(address) = "example.org"`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string address
    Guaranteed constraints:
    `10 ≤ address.length ≤ 50`.
- [output] string
 */

public class FindEmailDomain {

    public static void main(String[] args) {
        test("prettyandsimple@example.com", "example.com");
        test("<>[]:,;@\"!#$%&*+-/=?^_{}| ~.a\"@example.org", "example.org");
        test("someaddress@yandex.ru", "yandex.ru");
        test("\" \"@xample.org", "xample.org");
    }

    // My answer
    private static String findEmailDomain(String address) {
        String[] fragments = address.split("@");
        return fragments[fragments.length-1];
    }

    // Test methods
    private static boolean test(String address, String expected, boolean verbose) {
        String output = findEmailDomain(address);
        if (verbose) {
            System.out.println("Input: address = " + address +
                    "\nOutput: " + output +
                    "\nExpected: " + expected);
            System.out.print("Result: ");
        }
        if (output.equals(expected)) {
            if (verbose) System.out.println("SUCCESSFUL\n");
            return true;
        }
        if (verbose) System.out.println("!--- FAILED ---!\n");
        return false;
    }

    private static boolean test(String address, String expected) {
        return test(address, expected, true);
    }
}
