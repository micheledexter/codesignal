package com.shelydexter;

/*
You are taking part in an Escape Room challenge designed specifically for
programmers. In your efforts to find a clue, you've find a binary code written
on the wall behind a vase, and realized that it must be an encrypted message.
After some thought, your first guess is that each consecutive `8` bits of the
code stand for the character with the corresponding extended ASCII code.
Assuming that your hunch is correct, decode the message.

Example:
For `code = "010010000110010101101100011011000110111100100001"`, the output
should be `messageFromBinaryCode(code) = "Hello!"`.
The first `8` characters of the code are `01001000`, which is `72` in the
binary numeral system. `72` stands for `H` in the ASCII-table, so the first
letter is `H`.
Other letters can be obtained in the same manner.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string code
    A string, the encrypted message consisting of characters `'0'` and `'1'`.
    Guaranteed constraints:
    `0 < code. length < 800`.
- [output] string
    - The decrypted message
 */

public class MessageFromBinaryCode {

    public static void main(String[] args) {
        test("010010000110010101101100011011000110111100100001", "Hello!");
        test("01001101011000010111100100100000011101000110100001100101001000000100011001101111011100100110001101100101001000000110001001100101001000000111011101101001011101000110100000100000011110010110111101110101", "May the Force be with you");
        test("010110010110111101110101001000000110100001100001011001000010000001101101011001010010000001100001011101000010000001100000011010000110010101101100011011000110111100101110", "You had me at `hello.");
        test("010001010110110001100101011011010110010101101110011101000110000101110010011110010010110000100000011011010111100100100000011001000110010101100001011100100010000001010111011000010111010001110011011011110110111000100001", "Elementary, my dear Watson!");
        test("010011000110111101110110011001010010000001000110011011110111001000100000010000010110110001101100001011000010000001001000011000010111010001110010011001010110010000100000010001100110111101110010001000000100111001101111011011100110010100101110", "Love For All, Hatred For None.");
        test("0100001101101000011000010110111001100111011001010010000001110100011010000110010100100000011101110110111101110010011011000110010000100000011000100111100100100000011000100110010101101001011011100110011100100000011110010110111101110101011100100111001101100101011011000110011000101110", "Change the world by being yourself.");
        test("01000101011101100110010101110010011110010010000001101101011011110110110101100101011011100111010000100000011010010111001100100000011000010010000001100110011100100110010101110011011010000010000001100010011001010110011101101001011011100110111001101001011011100110011100101110", "Every moment is a fresh beginning.");
        test("010011100110010101110110011001010111001000100000011100100110010101100111011100100110010101110100001000000110000101101110011110010111010001101000011010010110111001100111001000000111010001101000011000010111010000100000011011010110000101100100011001010010000001111001011011110111010100100000011100110110110101101001011011000110010100101110", "Never regret anything that made you smile.");
        test("010001000110100101100101001000000111011101101001011101000110100000100000011011010110010101101101011011110111001001101001011001010111001100101100001000000110111001101111011101000010000001100100011100100110010101100001011011010111001100101110", "Die with memories, not dreams.");
        test("0100000101110011011100000110100101110010011001010010000001110100011011110010000001101001011011100111001101110000011010010111001001100101001000000110001001100101011001100110111101110010011001010010000001110111011001010010000001100101011110000111000001101001011100100110010100101110", "Aspire to inspire before we expire.");
    }

    // My answer
    private static String messageFromBinaryCode(String code) {
        String[] arrString = code.split("");
        int[] arr = new int[arrString.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrString[i]);
        }
        String output = "";
        for (int i = 0; i < arr.length / 8; i++) {
            int total = 0;
            int bin = 1;
            for (int j = 7; j >= 0; j--) {
                int tic = (i * 8) + j;
                total += arr[tic] * bin;
                bin *= 2;
            }
            output += (char)total;
        }
        return output;
    }

    // Test method
    private static boolean test(String code, String expected) {
        String output = messageFromBinaryCode(code);
        System.out.println("Input: code = " + code +
                "\nOutput: " + output +
                "\nExpected: " + expected);
        System.out.print("Result: ");
        if (output.equals(expected)) {
            System.out.println("SUCCESSFUL\n");
            return true;
        } else {
            System.out.println("!--- FAILED ---!\n");
            return false;
        }
    }
}
