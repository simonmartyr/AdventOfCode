package com.smartyr.adventofcode.y2025.day1;

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

    public int invokeSet(final Safe safe, final List<String> test) {
        for (String instruction : test) {
            safe.move(instruction);
        }
        return safe.getTotal();
    }

    public Safe invokePart1() {
        return invoke(new Safe());
    }

    public Safe invokePart2() {
        return invoke(new Safe(true));
    }

    private Safe invoke(final Safe safe) {
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