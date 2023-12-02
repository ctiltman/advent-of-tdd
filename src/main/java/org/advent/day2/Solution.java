package org.advent.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Game> games = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream("day2.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                games.add(new Game(line)); // Assuming Game has a constructor that takes a String
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading from the file", e);
        }

        Bag bag = new Bag(12,13,14);
        int sum = 0;
        for (Game game : games)
        {
            if(game.CheckBagAgainstGame(bag))
            {
                sum += game.id;
            }
        }
        System.out.println(sum);

        int sumOfPower=0;
        for (Game game : games) {

            sumOfPower += game.MimimumBag().PowerOfCubes();
        }
        System.out.println(sumOfPower);
    }

}

