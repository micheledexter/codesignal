/*
Given a year, return the century it is in. The first century spans from the
year 1 up to and including the year 100, the second - from the year 101 up to
and including the year 200, etc.

Example:
- For `year = 1905`, the output should be `centuryFromYear(year) = 20`;
- For `year = 1700`, the output should be `centuryFromYear(year) = 17`.

Input/Output:
- [execution time limit] 4 seconds (js)
- [input] integer year
    A positive integer, designating the year.
    Guaranteed constraints:
    `1 ≤ year ≤ 2005`.
- [output] integer
    - The number of the century the year is in.
 */

// My answer
const centuryFromYear = year => {
  return Math.floor(((year - 1) / 100) + 1);
}

// Testing
const test = (year, expected) => {
  output = centuryFromYear(year);
  console.log("Input: year = " + year);
  console.log("Output: " + output);
  console.log("Expected: " + expected);
  if (output === expected) {
    console.log("SUCCESSFUL\n");
    return true;
  } else {
    console.log("!--- FAILED ---!\n");
    return false;
  }
}

test(1905, 20);
test(1700, 17);
test(1988, 20);
test(2000, 20);
test(2001, 21);
test(200, 2);
test(374, 4);
test(45, 1);
test(8, 1);