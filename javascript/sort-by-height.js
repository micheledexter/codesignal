/*
Some people are standing in a row in a park. There are trees between them which
cannot be moved. Your task is to rearrange the people by their heights in a
non-descending order without moving the trees. People can be very tall!

Example:
For `a = [-1, 150, 190, 170, -1, -1, 160, 180]`, the output should be
`sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190]`.

Input/Output:
- [execution time limit] 4 seconds (js)
- [input array.integer a
    if `a[i] = -1`, then the `ith` position is occupied by a tree. Otherwise
    `a[i]` is the height of a person standing in the `ith` position.
    Guaranteed constraints:
    `1 ≤ a.length ≤ 1000`,
    `-1 ≤ a[i] ≤ 1000`.
- [output] array.integer
    - Sorted array `a` with all the trees untouched.
 */

// My answer
const sortByHeight = a => {
  if (a.length === 1) return a;
  let sticky = 0;
  for (let i = 0; i < a.length; i++) {
    if (a[i] === -1) continue;
    for (let j = i; j < a.length; j++) {
      if (a[j] === -1) continue;
      if (a[j] < a[sticky]) {
        let temp = a[j];
        a[j] = a[sticky];
        a[sticky] = temp;
      }
    }
    sticky = i;
  }
  return a;
}

// Testing
const test = (a, expected) => {
  const output = sortByHeight(a);
  console.log("Input: a =", a);
  console.log("Output:", output);
  console.log("Expected:", expected);
  process.stdout.write("Result: ");
  if (areEqual(output, expected)) {
    console.log("SUCCESSFUL\n");
    return true;
  } else {
    console.log("!--- FAILED ---!\n");
    return false;
  }
}

const areEqual = (first, second) => {
  if (first.length !== second.length) return false;
  for (let i = 0; i < first.length; i++) {
    if (first[i] !== second[i]) return false;
  }
  return true;
}

test([-1, 150, 190, 170, -1, -1, 160, 180], [-1, 150, 160, 170, -1, -1, 180, 190]);
test([-1, -1, -1, -1, -1], [-1, -1, -1, -1, -1]);
test([-1], [-1]);
test([4, 2, 9, 11, 2, 16], [2, 2, 4, 9, 11, 16]);
test([2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1], [1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2]);
test([23, 54, -1, 43, 1, -1, -1, 77, -1, -1, -1, 3], [1, 3, -1, 23, 43, -1, -1, 54, -1, -1, -1, 77]);