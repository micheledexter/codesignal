/*
Given a sequence of integers as an array, determine whether it is possible to
obtain a strictly increasing sequence by removing no more than one element
from the array.

Example:
- For `sequence = [1, 3, 2, 1]`, the output should be
`almostIncreasingSequence(sequence) = false`.
    There is no one element in this array that can be removed in order to get a
    strictly increasing sequence.
- For `sequence = [1, 3, 2]`, the output should be
`almostIncreasingSequence(sequence) = true`.
    You can remove `3` from the array to get the strictly increasing sequence
    `[1, 2]`. Alternatively you can remove `2` to get the strictly increasing
sequence `[1, 3]`.

Input/Output:
- [execution time limit] 4 seconds (js)
- [input] array.integer sequence
    Guaranteed constraints:
    `2 ≤ sequence.length ≤ 10^5`,
    `-10^5 ≤ sequence[i] ≤ 10^5`.
- [output] boolean
    - Return `true` if it is possible to remove one element from the array in
    order to get a strictly increasing sequence, otherwise return `false`
NOTE: currently taking over 3 seconds for test 17 on the website, make sure to check why this is a problem.
 */

// My answer
const almostIncreasingSequence = sequence => {
  for (let i = 0; i < sequence.length; i++) {
    let s = sequence.slice();
    s.splice(i, 1);
    let works = true;
    for (let x = 1; x < s.length; x++) {
      if (s[x] <= s[x-1]) {
        works = false;
        break;
      }
    }
    if (works) return true;
  }
  return false;
}

// Testing
const test = (sequence, expected) => {
  let output = almostIncreasingSequence(sequence);
  console.log("Input: sequence = " + sequence);
  console.log("Output: " + output);
  console.log("Expected: " + expected);
  process.stdout.write("Result: ");
  if (output === expected) {
    console.log("SUCCESSFUL\n");
    return true;
  } else {
    console.log("!--- FAILED ---!\n");
    return false;
  }
}

test([1, 3, 2, 1], false);
test([1, 3, 2], true);
test([1, 2, 1, 2], false);
test([1, 4, 10, 4, 2], false);
test([10, 1, 2, 3, 4, 5], true);
test([1, 1, 1, 2, 3], false);
test([0, -2, 5, 6], true);
test([1, 2, 3, 4, 5, 3, 5, 6], false);
test([40, 50, 60, 10, 20, 30], false);
test([1, 1], true);
test([1, 2, 5, 3, 5], true);
test([1, 2, 5, 5, 5], false);
test([10, 1, 2, 3, 4, 5, 6, 1], false);
test([1, 2, 3, 4, 3, 6], true);
test([1, 2, 3, 4, 99, 5, 6], true);
test([123, -17, -5, 1, 2, 3, 12, 43, 45], true);
test([3, 5, 67, 98, 3], true);