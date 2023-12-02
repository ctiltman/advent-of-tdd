package org.advent.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestCalibrationValue {
    @ParameterizedTest
    @MethodSource("provideParameters")
    void test_finds_digits(String inputString, int correctValue) {
        CalibrationValue calibrationValue = new CalibrationValue(inputString);
        assertThat(calibrationValue.calibrationValue, equalTo(correctValue));
    }

    static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("two1nine", 29),
                Arguments.of("eightwothree", 83),
                Arguments.of("abcone2threexyz", 13),
                Arguments.of("xtwone3four", 24),
                Arguments.of("zoneight234", 14),
                Arguments.of("7pqrstsixteen", 76)
        );
    }
}

