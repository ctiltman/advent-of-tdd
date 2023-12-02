package org.advent.day2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    int id;
    private ArrayList<Grab> grabs = new ArrayList<>();
    public Game(String line)
    {
        Pattern gamePattern = Pattern.compile("Game (?<gameNumber>\\d+): (?<allGrabs>.+)");
        Matcher gameMatcher = gamePattern.matcher(line);

        if (gameMatcher.find()) {
           id = Integer.parseInt(gameMatcher.group("gameNumber"));

            // Split the pairs by semicolon
            String[] groups = gameMatcher.group("allGrabs").split(";\\s*");
            for (String stringGrab : groups) {
                grabs.add(new Grab(stringGrab));
            }
        }
    }
    public boolean CheckBagAgainstGame(Bag bag)
    {
        for (Grab grab:grabs) {
            if(!bag.CheckGrab(grab))
            {
                return false;
            }
        }
        return true;
    }

    Bag MimimumBag()
    {
        Bag bag = new Bag();
        for (Grab grab: grabs) {
            for (Colour colour: Colour.values()) {
                int count = grab.GetCountByColour(colour);
                if(bag.GetCountByColour(colour) < count)
                {
                    bag.SetCountByColour(colour, count);
                }
            }
        }
        return bag;
    }
}
