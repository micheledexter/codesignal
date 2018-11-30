package com.shelydexter;

/*
You are given an array of desired filenames in the order of their creation.
Since two files cannot have equal names, the one which comes later will have an
addition to its name in a form of `(k)`, where `k` is the smallest positive
integer such that the obtained name is not used yet.
Return an array of names that will be given to the files.

Example:
For `names = ["doc", "doc", "image", "doc(1)", "doc"]`, the output should be
`fileNaming(names) = ["doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"]`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] array.string names
    Guaranteed constraints:
    `5 ≤ names.length ≤ 15`,
    `1 ≤ names[i].length ≤ 15`.
- [output] array.string
 */

public class FileNaming {

    public static void main(String[] args) {
        test(new String[] {"doc", "doc", "image", "doc(1)", "doc"}, new String[] {"doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"});
        test(new String[] {"a(1)", "a(6)", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"}, new String[] {"a(1)", "a(6)", "a", "a(2)", "a(3)", "a(4)", "a(5)", "a(7)", "a(8)", "a(9)", "a(10)", "a(11)"});
        test(new String[] {"dd", "dd(1)", "dd(2)", "dd", "dd(1)", "dd(1)(2)", "dd(1)(1)", "dd", "dd(1)"}, new String[] {"dd", "dd(1)", "dd(2)", "dd(3)", "dd(1)(1)", "dd(1)(2)", "dd(1)(1)(1)", "dd(4)", "dd(1)(3)"});
    }

    // My answer
    private static String[] fileNaming(String[] names) {
        String[] list = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            list[i] = names[i];
            for (int j = 0; j < i; j++) {
                if (list[i].equals(list[j])) {
                    int counter = 1;
                    boolean found = false;
                    while (!found) {
                        found = true;
                        for (int k = 0; k < i; k++) {
                            String temp = list[i] + "(" + counter + ")";
                            if (temp.equals(list[k])) {
                                found = false;
                                counter++;
                                break;
                            }
                        }
                    }
                    list[i] += "(" + counter + ")";
                    break;
                }
            }
        }
        return list;
    }

    // Test method
    private static boolean test(String[] names, String[] expected) {
        String[] output = fileNaming(names);
        System.out.println("Input: names = " + arrayToString(names) +
                "\nOutput: " + arrayToString(output) +
                "\nExpected: " + arrayToString(expected));
        System.out.print("Result: ");
        if (arraysAreEqual(output, expected)) {
            System.out.println("SUCCESSFUL\n");
            return true;
        }
        System.out.println("!--- FAILED ---!\n");
        return false;
    }

    // Support methods
    private static String arrayToString(String[] array) {
        String output = "[";
        for (int i = 0; i < array.length; i++) {
            output += "\"" + array[i] + "\"";
            if (i < array.length-1) output += ", ";
        }
        output += "]";
        return output;
    }

    private static boolean arraysAreEqual(String[] first, String[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) return false;
        }
        return true;
    }
}
