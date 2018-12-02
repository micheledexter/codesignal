/*
Given an array of integers, find the pair of adjacent elements that has the
largest product and return that product.

Example:
For `inputArray = [3, 6, -2, -5, 7, 3]`, the output should be
`adjacentElementsProduct(inputArray) = 21`.
`7` and `3` produce the largest product.

Input/Output
- [execution time limit] 4 seconds (js)
- [input] array.integer inputArray
    An array of integers containing at least two elements.
    Guaranteed constraints:
    `2 ≤ inputArray.length ≤ 10`,
    `-1000 ≤ inputArray[i] ≤ 1000`.
- [output] integer
    - The largest product of adjacent elements.
 */

// My answer
const adjacentElementsProduct = inputArray => {
  highest = inputArray[0] * inputArray[1];
  for (let i = 1; i < inputArray.length-1; i++) {
    calc = inputArray[i] * inputArray[i+1];
    if (calc > highest) highest = calc;
  }
  return highest;
}

// Testing
const test = (inputArray, expected) => {
  output = adjacentElementsProduct(inputArray);
  console.log("Input: inputArray = " + inputArray);
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

test([3, 6, -2, -5, 7, 3], 21);
test([-1, -2], 2);
test([5, 1, 2, 3, 1, 4], 6);
test([1, 2, 3, 0], 6);
test([9, 5, 10, 2, 24, -1, -48], 50);
test([5, 6, -4, 2, 3, 2, -23], 30);
test([4, 1, 2, 3, 1, 5], 6);
test([-23, 4, -3, 8, -12], -12);
test([1, 0, 1, 0, 1000], 0);