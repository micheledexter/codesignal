package com.shelydexter;

/*
Musical notes and their notations originated from ancient civilizations.
Interestingly, although discovered centuries prior to the birth of Heinrich
Rudolf Hertz, the system of notes is based around sound frequencies.
Each note in the chromatic scale corresponds to a sound wave, which has a
unique frequency. The same set of notes appear in higher octaves (with higher
frequencies), and in lower octaves (with lower frequencies), and there's a
system called scientific pitch notation which distinguishes between notes in
different octaves (for example, `F#3` is two octaves below `F#5`)
The magical property is that for any two notes separated by an octave (eg: `A4`
and `A5`), the ratio of their frequencies is exactly 2 - in other words,
doubling a note's frequency is equivalent to ascending an octave! In this
Particular case, the frequency of `A4` is `440` and the frequency of `A5` is
`880`.
With this information in mind, your task is to identify the frequency of the
input `note` (provided in scientific pitch notation).

Example:
- For `note = "A3"`, the output should be `noteFrequency(note) = 220`.
Since this note is one octave below `A4`, its frequency is exactly half
(`440 / 2 = 220`).
- For `note = "C5"`, the output should be `noteFrequency(note) = 523.251131`.
This note is 3 semitones above `A4` (it goes `A4`, `A#4`, `B4`, then `C5`).
Since there are 12 semitones in an octave, and the frequency doubles each
octave, we can apply `3 / 12 = 1 / 4` of the doubling to the frequency of `A4`
(which is `440`). So the result is `440 * 2^(1/4) ≐ 523.251131`.

Input/Output:
- [execution time limit] 3 seconds (java)
- [input] string note
    A string representing a single note in scientific pitch notation. Each note
    consists of the note name, followed by a number representing the octave.
    Note names consist of a letter from A to G, optionally followed by `#`
    (sharp, indicating that the note is pitched up by one semitone) or `b`
    (flat, indicating that the note is pitched down by one semitone).
    Guaranteed constraints:
    `2 ≤ note.length ≤ 3`
    `note[i] ∈ {"A" - "G", "0" - "8", "#", "b"}`
- [output] float
    - A floating point value representing the wave frequency of the given note.
 */

public class NoteFrequency {

    public static void main(String[] args) {
        test("A3", 220);
        test("C5", 523.251131);
        test("E2", 82.40688922821748);
        test("A#8", 7458.620184289439);
        test("E5", 659.2551138257398);
        test("A4", 440);
        test("A0", 27.5);
        test("Bb8", 7458.620184289439);
        test("Db3", 138.59131548843604);
        test("C#2", 69.29565774421802);
        test("B6", 1975.5332050244965);
        test("A8", 7040);
        test("Db4", 277.1826309768721);
        test("G#5", 830.6093951598903);
    }

    // My answer
    private static double noteFrequency(String note) {
        char[] arr = note.toCharArray();
        int n = 0;
        switch (arr[0]) {
            case 'C':
                n = 0;
                break;
            case 'D':
                n = 2;
                break;
            case 'E':
                n = 4;
                break;
            case 'F':
                n = 5;
                break;
            case 'G':
                n = 7;
                break;
            case 'A':
                n = 9;
                break;
            case 'B':
                n = 11;
                break;
        }
        if (arr.length == 3) {
            switch (arr[1]) {
                case '#':
                    n++;
                    break;
                case 'b':
                    n--;
                    break;
            }
        }
        int change = ((int)arr[arr.length-1] - 52) * 12;
        n += change;
        return (double)440 * Math.pow((double)2, ((double)n-9)/12);
    }

    // Test method
    private static boolean test(String note, double expected) {
        double output = noteFrequency(note);
        System.out.println("Input: note = " + note +
                "\nOutput: " + output +
                "\nExpected: " + expected);
        System.out.print("Result: ");
        if (output == expected) {
            System.out.println("SUCCESSFUL\n");
            return true;
        } else {
            System.out.println("!--- FAILED ---!\n");
            return false;
        }
    }
}
