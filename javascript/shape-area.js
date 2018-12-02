/*
Below we will define an `n`-interesting polygon. Your task is to find the area
of a polygon for a given `n`.
A `1`-interesting polygon is just a square with a side of length `1`. An
`n`-interesting polygon is obtained by taking the `n - 1`-interesting
polygon and appending `1`-interesting polygons to its rim, side by side. You
can see the `1`-, `2`-, `3`- and `4`-interesting polygons in the picture
below.
                #
         #     ###
    #   ###   #####
 # ### ##### #######
    #   ###   #####
         #     ###
                #
 1  2    3      4

Example:
- For `n = 2`, the output should be `shapeArea(n) = 5`;
- For `n = 3`, the output should be `shapeArea(n) = 13`.

Input/Output:
- [execution time limit] 4 seconds (js)
- [input] integer n
    Guaranteed constraints:
    `1 ≤ n < 10^4`.
- [output] integer
    - The area of the `n`-interesting polygon.
 */

// My answer
const shapeArea = n => {
  total = 1;
  while (n > 1) {
    total += (n-1) * 4;
    n--;
  }
  return total;
}

const test = (n, expected) => {
  output = shapeArea(n);
  console.log("Input: n = " + n);
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

test(2, 5);
test(3, 13);
test(1, 1);
test(5, 41);