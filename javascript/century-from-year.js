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