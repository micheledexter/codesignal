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