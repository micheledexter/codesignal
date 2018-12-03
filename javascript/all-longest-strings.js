/*
Given an array of strings, return another array containing all of its longest
strings.

Example:
For `inputArray = ["aba", "aa", "ad", "vcd", "aba"]`, the output should be
`allLongestStrings(inputArray) = ["aba", "vcd", "aba"]`.

Input/Output:
- [execution time limit] 4 seconds (js)
- [input] array.string inputArray
    A non-empty array.
    Guaranteed constraints:
    `1 ≤ inputArray.length ≤ 10`,
    `1 ≤ inputArray[i].length ≤ 10`.
- [output] array.string
    - Array of the longest strings, stored in the same order as in the
    `inputArray`.
 */

// My answer
const allLongestStrings = inputArray => {
  let arr = [];
  let longest = 0;
  for (let item of inputArray) {
    if (item.length > longest) longest = item.length;
  }
  for (let item of inputArray) {
    if (item.length === longest) arr.push(item);
  }
  return arr;
}

// Testing
const test = (inputArray, expected) => {
  const output = allLongestStrings(inputArray);
  console.log("Input: inputArray = ", inputArray);
  console.log("Output: ", output);
  console.log("Expected: ", expected);
  process.stdout.write("Result: ");
  if (arraysAreEqual(output, expected)) {
    console.log("SUCCESSFUL\n");
    return true;
  } else {
    console.log("!--- FAILED ---!\n");
    return false;
  }
}

const arraysAreEqual = (first, second) => {
  if (first.length != second.length) return false;
  for (let i = 0; i < first.length; i++) {
    if (first[i] != second[i]) return false;
  }
  return true;
}

test(["aba", "aa", "ad", "vcd", "aba"], ["aba", "vcd", "aba"]);
test(["aa"], ["aa"]);
test(["abc", "eeee", "abcd", "dcd"], ["eeee", "abcd"]);
test(["a", "abc", "cbd", "zzzzzz", "a", "abcdef", "asasa", "aaaaaa"], ["zzzzzz", "abcdef", "aaaaaa"]);