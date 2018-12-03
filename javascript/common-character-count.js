/*
Given two strings, find the number of common characters between them.

Example:
For `s1 = "aabcc"` and `s2 = "adcaa"`, the output should be
`commonCharacterCount(s1, s2) = 3`.
Strings have `3` common characters - `2` "a"s and `1` "c".

Input/Output:
- [execution time limit] 4 seconds (js)
- [input] string s1
    A string consisting of lowercase English letters.
    Guaranteed constraints:
    `1 ≤ s1.length ≤ 15`.
- [input] string s2
    A string consisting of lowercase English letters.
    Guaranteed constraints:
    `1 ≤ s2.length ≤ 15`.
- [output] integer
 */

// My answer
const commonCharacterCount = (s1, s2) => {
  let available = [];
  for (let i = 0; i < s2.length; i++) {
    available.push(true);
  }
  let count = 0;
  for (let i = 0; i < s1.length; i++) {
    for (let j = 0; j < s2.length; j++) {
      if (available[j]) {
        if (s2[j] === s1[i]) {
          count++;
          available[j] = false;
          break;
        }
      }
    }
  }
  return count;
}

// Testing
const test = (s1, s2, expected) => {
  const output = commonCharacterCount(s1, s2);
  console.log("Input: s1 =", s1, "s2 =", s2);
  console.log("Output:", output);
  console.log("Expected:", expected);
  process.stdout.write("Result: ");
  if (output === expected) {
    console.log("SUCCESSFUL\n");
    return true;
  } else {
    console.log("!--- FAILED ---!\n");
    return false;
  }
}

test("aabcc", "adcaa", 3);
test("zzzz", "zzzzzzzz", 4);
test("abca", "xyzbac", 3);
test("a", "b", 0);
test("a", "aaa", 1);