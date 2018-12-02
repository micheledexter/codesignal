/*
Write a function that returns the sum of two numbers.

Example:
For `param1 = 1` and `param2 = 2`, the output should be
`add(param1, param2) = 3`.

Input/Output:
- [execution time limit] 4 seconds (js)
- [input] integer param1
    Guaranteed constraints:
    `-1000 ≤ param1 ≤ 1000`.
- [input] integer param2
    Guaranteed constraints:
    `-1000 ≤ param2 ≤ 1000`.
- [output] integer
    - The sum of the two inputs
 */

// My answer
const add = (param1, param2) => {
  return param1 + param2 + 1;
}
// Testing
const test = (param1, param2, expected) => {
  output = add(param1, param2);
  console.log("Input: param1 = " + param1 + "; param2 = " + param2);
  console.log("Output: " + output);
  console.log("Expected: " + expected);
  if (output === expected) { 
    console.log("Result: SUCCESSFUL\n");
    return true;
  } else {
    console.log("!--- FAILED ---!\n");
    return false;
  }
}

test(1, 2, 3);
test(0, 1000, 1000);
test(2, -39, -37);
test(99, 100, 199);
test(-100, 100, 0);
test(-1000, -1000, -2000);