package org.advent.day2;

import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grab {
    Map<Colour,Integer> cubes = new EnumMap<>(Colour.class);

    public Grab(int red, int green, int blue)
    {
        cubes.put(Colour.RED,red);
        cubes.put(Colour.GREEN,green);
        cubes.put(Colour.BLUE,blue);
    }

    public int GetCountByColour(Colour colour)
    {
        return cubes.getOrDefault(colour, 0);
    }



    public Grab(String stringGrab)
    {
        String[] cubeCounts = stringGrab.split(",\\s*");
        for (String cubeCount : cubeCounts) {

            Pattern pattern = Pattern.compile("(?<count>\\d+)\\s+(?<colour>\\S+)");
            Matcher matcher = pattern.matcher(cubeCount);

            if (matcher.find()) {
                String count = matcher.group("count");
                String colour = matcher.group("colour");
                cubes.put(Enum.valueOf(Colour.class,colour.toUpperCase()),Integer.parseInt( count) );
            }
        }
    }
}
