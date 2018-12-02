/*
Ratiorg got `statues` of different sizes as a present from CodeMaster for his
birthday, each statue having a non-negative integer size. Since he likes to
make things perfect, he wants to arrange them from smallest to largest so that
each statue will be bigger than the previous one exactly by `1`. He may need
some additional statues to be able to accomplish that. Help him figure out the
minimum number of additional statues needed.

Example:
For `statues = [6, 2, 3, 8], the output should be
`makeArrayConsecutive2(statues) = 3`.
Ratiorg needs statues of sizes `4`, `5`, and `7`.

Input/Output:
- [execution time limit] 4 seconds (js)
- [input] array.integer statues
    An array of distinct non-negative integers.
    Guaranteed constraints:
    `1 ≤ statues.length ≤ 10`,
    `0 ≤ statues[i] ≤ 20`.
- [output] integer
    - The minimal number of statues that need to be added to existing
    `statues` such that it contains every integer size from an interval
    `[L, R]` (for some `L, R`) and no other sizes.
 */

// My answer
const makeArrayConsecutive2 = statues => {
  lowest = statues[0];
  highest = statues[0];
  for (let statue of statues) {
    if (statue > highest) highest = statue;
    if (statue < lowest) lowest = statue;
  }
  return (highest - lowest) - (statues.length - 1);
}

// Testing
const test = (statues, expected) => {
  output = makeArrayConsecutive2(statues);
  console.log("Input: statues = " + statues);
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

test([6, 2, 3, 8], 3);
test([0, 3], 2);
test([5, 4, 6], 0);
test([6, 3], 2);
test([1], 0);