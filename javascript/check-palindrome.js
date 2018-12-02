/*
Given the string, check if it is a palindrome.

Example:
- For `inputString = "aabaa"`, the output should be
`checkPalindrome(inputString) = true`;
- For `inputString = "abac"`, the output should be
`checkPalindrome(inputString) = false`;
- For `inputString = "a"`, the output should be
`checkPalindrome(inputString) = true`.

Input/Output:
- [execution time limit] 4 seconds (js)
- [input] string inputString
    A non-empty string consisting of lowercase characters.
    Guaranteed constraints:
    `1 ≤ inputString.length ≤ 10^5`.
- [output] boolean
    - `true` if `inputString` is a palindrome, `false` otherwise.
 */

// My answer
const checkPalindrome = inputString => {
  return inputString === inputString.split("").reverse().join("");
}

// Testing
const test = (inputString, expected) => {
  output = checkPalindrome(inputString);
  console.log("Input: inputString = " + inputString);
  console.log("Output: " + output);
  console.log("Expected: " + expected);
  process.stdout.write("Result: ")
  if (output === expected) {
    console.log("SUCCESSFUL\n");
    return true;
  } else {
    console.log("!--- FAILED ---!\n");
    return false;
  }
}

test("aabaa", true);
test("abac", false);
test("a", true);
test("az", false);
test("abacaba", true);
test("z", true);
test("aaabaaaa", false);
test("zzzazzazz", false);
test("hlbeeykoqqqqokyeeblh", true);
test("hlbeeykoqqqokyeeblh", true);