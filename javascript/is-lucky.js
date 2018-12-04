/*
Ticket numbers usually consist of an even number of digits. A ticket number is
considered lucky if the sum of the first half of the digits is equal to the sum
of the second half.
Given a ticket number `n`, determine if it's lucky or not.

Example:
For `n = 1230`, the output should be `isLucky(n) = true`,
For `n = 239017`, the output should be `isLucky(n) = false`.

Input/Output
- [execution time limit] 4 seconds (js)
- [input] integer n
    A ticket number represented as a positive integer with an even number of
    digits.
    Guaranteed constraints:
    `10 ≤ n < 10^6`.
- [output] boolean
    - `true` if `n` is a lucky ticket number, `false` otherwise.
 */

// My answer
const isLucky = n => {
  let length = 0;
  let x = n;
  while (x > 0) {
    x = Math.floor(x / 10);
    length++;
  }
  let half = length / 2;
  let head = 0;
  for (let i = 0; i < half; i++) {
    head += n % 10;
    n = Math.floor(n / 10);
  }
  let tail = 0;
  for (let i = 0; i < half; i++) {
    tail += n % 10;
    n = Math.floor(n / 10);
  }
  if (head === tail) {
    return true;
  } else {
    return false;
  }
}

// Testing
const test = (n, expected) => {
  const output = isLucky(n);
  console.log("Input: n =", n);
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

test(1230, true);
test(239017, false);
test(134008, true);
test(10, false);
test(11, true);
test(1010, true);
test(261534, false);
test(100000, false);
test(999999, true);
test(123321, true);