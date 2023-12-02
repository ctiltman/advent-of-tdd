package org.advent.day2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestCube {

    @Test
    void test_cube_string_constructor() {
        var cube = new Cube("red");
        assertThat(cube.colour, equalTo(Colour.RED));
    }
}
