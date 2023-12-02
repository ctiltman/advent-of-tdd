package org.advent.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class CalibrationDocument {
    private final ArrayList<CalibrationValue> calibrationValues = new ArrayList<>();
    public CalibrationDocument(InputStream stream) {
        assert stream != null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                calibrationValues.add(new CalibrationValue(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int GetCalibrationSum()
    {
        int sum=0;
        for (CalibrationValue val: calibrationValues) {
            sum = val.calibrationValue + sum;
        }
        return sum;
    }
}
