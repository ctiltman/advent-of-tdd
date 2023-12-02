package org.advent.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestGame {

    @Test
    void test_game_string_constructor() {
        var game = new Game("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        assertThat(game.id, equalTo(1));
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void test_game_powers(String gameLine, int power) {
        Game game = new Game(gameLine);
        int bagPower = game.MimimumBag().PowerOfCubes();
        assertThat(bagPower, equalTo(power));
    }

    static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green", 48),
                Arguments.of("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue", 12),
                Arguments.of("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red", 1560),
                Arguments.of("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red", 630),
                Arguments.of("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green", 36)
        );
    }
}
