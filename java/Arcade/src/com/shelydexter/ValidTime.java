package com.shelydexter;

/*
Check if the given string is a correct time representation of the 24-hour
clock.

Example:
- For `time = "13:58"`, the output should be `validTime(time) = true`;
- For `time = "25:51"`, the output should be `validTime(time) = false`;
- For `time = "02:76"`, the output should be `validTime(time) = false`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string time
    A string representing time in `HH:MM` format. It is guaranteed that the
    first two characters, as well as the last two caracters, are digits.
- [output] boolean
    - `true` if the given representation is correct, `false` otherwise.
 */

public class ValidTime {

    public static void main(String[] args) {
        test("13:58", true);
        test("25:51", false);
        test("02:76", false);
        test("24:00", false);
        test("02:61", false);
        test("27:00", false);
        test("19:66", false);
        test("12:31", true);
        test("25:73", false);
        test("09:56", true);
    }

    // My answer
    private static boolean validTime(String time) {
        return (time.matches("[0-2][0-9]:[0-5][0-9]") && !time.matches("2[4-9]:[0-5][0-9]"));
    }

    // Test method
    private static boolean test(String time, boolean expected) {
        boolean output = validTime(time);
        System.out.println("Input: time = " + time +
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
