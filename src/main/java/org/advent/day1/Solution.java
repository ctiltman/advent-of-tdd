package org.advent.day1;

import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args)  {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("day1.txt")) {
            assert inputStream != null;
            CalibrationDocument doc = new CalibrationDocument(inputStream);
            System.out.println(doc.GetCalibrationSum());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

