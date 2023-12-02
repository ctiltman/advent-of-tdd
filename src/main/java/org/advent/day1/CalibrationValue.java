package org.advent.day1;

import java.security.InvalidParameterException;

public class CalibrationValue
{
    int calibrationValue;
    private static final String[] constArrayDigits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public CalibrationValue(String str) {
        int firstDigitIndex = Integer.MAX_VALUE;
        int lastDigitIndex = -1;
        int firstDigit = -1;
        int lastDigit = -1;

        for (int d = 0; d <= 9; d++) {
            String digitStr = Integer.toString(d);
            String wordStr = constArrayDigits[d];

            // Check for the numeric digit
            int firstIndexNum = str.indexOf(digitStr);
            int lastIndexNum = str.lastIndexOf(digitStr);

            // Check for the word representation of the digit
            int firstIndexWord = str.indexOf(wordStr);
            int lastIndexWord = str.lastIndexOf(wordStr);

            // Update first digit if a new minimum is found
            int minFirstIndex = minPositiveIndex(firstIndexNum, firstIndexWord);
            if (minFirstIndex != -1 && minFirstIndex < firstDigitIndex) {
                firstDigitIndex = minFirstIndex;
                firstDigit = d;
            }

            // Update last digit if a new maximum is found
            int maxLastIndex = Math.max(lastIndexNum, lastIndexWord);
            if (maxLastIndex > lastDigitIndex) {
                lastDigitIndex = maxLastIndex;
                lastDigit = d;
            }
        }

        if (firstDigit == -1 || lastDigit == -1) {
            throw new InvalidParameterException("given string value was " + str);
        }
        calibrationValue =  lastDigit + 10*firstDigit;
    }

    private static int minPositiveIndex(int a, int b) {
        if (a == -1) return b;
        if (b == -1) return a;
        return Math.min(a, b);
    }

}