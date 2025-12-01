package com.smartyr.adventofcode.y2025.Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

//0-99
//L for left (towards lower numbers)
//R for Right (towards higher numbers).
//distance values which indicates how many clicks.
//number of times the dial is left pointing at 0 after an rotation in the sequence.
public class Day1 {
    final File inputFile = new File(Day1.class.getClassLoader().getResource("y2025/day1.txt").getFile());

    public int invokeList(final List<String> test) {
        final Safe safe = new Safe();
        for (String instruction : test) {
            safe.move(instruction);
        }
        return safe.getTotal();
    }

    public Safe invokePart1() {
        final Safe safe = new Safe();
        try (FileReader fr = new FileReader(inputFile);
             BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            while (line != null) {
                safe.move(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return safe;
    }

    public int invokeListPart2(final List<String> test) {
        final Safe safe = new Safe(true);
        for (String instruction : test) {
            safe.move(instruction);
        }
        return safe.getTotal();
    }

    public Safe invokePart2() {
        final Safe safe = new Safe(true);
        try (FileReader fr = new FileReader(inputFile);
             BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            while (line != null) {
                safe.move(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return safe;
    }
}