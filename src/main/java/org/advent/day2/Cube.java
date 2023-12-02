package org.advent.day2;

public class Cube {
    Colour colour;

    public Cube(String colour)
    {
        this.colour = Enum.valueOf(Colour.class,colour.toUpperCase());
    }
}
