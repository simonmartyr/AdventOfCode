package com.smartyr.adventofcode.y2025.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.smartyr.adventofcode.y2025.day1.Day1;

public class Day6 {
    final File inputFile = new File(Day1.class.getClassLoader().getResource("y2025/day6.txt").getFile());
    final File exampleFile = new File(Day1.class.getClassLoader().getResource("y2025/day6_example.txt").getFile());

    public List<String[]> readRealPart1() {
        return readInput(inputFile, this::formatPart1);
    }

    public List<String[]> readExamplePart1() {
        return readInput(exampleFile, this::formatPart1);
    }

    public List<String[]> readRealPart2() {
        return readInput(inputFile, this::formatPart2);
    }

    public List<String[]> readExamplePart2() {
        return readInput(exampleFile, this::formatPart2);
    }

    public List<String[]> readInput(File file, Function<String, String[]> parser) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                    .map(parser)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long solvePart1() {
        return solvePart1(readRealPart1());
    }

    public long solvePart1(List<String[]> input) {
        final String[] operators = input.getLast();
        final List<String[]> dataRows = input.subList(0, input.size() - 1);

        return IntStream.range(0, input.getFirst().length)
                .mapToLong(col -> calculateColumn(dataRows, col, operators[col].equals("+")))
                .sum();
    }

    private long calculateColumn(List<String[]> rows, int col, boolean isAddition) {
        return rows.stream()
                .mapToLong(row -> Long.parseLong(row[col]))
                .reduce(isAddition ? 0 : 1, (acc, val) -> isAddition ? acc + val : acc * val);
    }

    public long solvePart2() {
        return solvePart2(readRealPart2());
    }

    public long solvePart2(final List<String[]> input) {
        final String[] operators = input.getLast();
        final List<String[]> rows = input.subList(0, input.size() - 1);
        final int numColumns = input.getFirst().length;

        long total = 0;
        List<String> currentGroup = new ArrayList<>();
        for (int col = numColumns - 1; col >= 0; col--) {
            String column = extractColumn(rows, col);
            if (!column.isEmpty()) {
                currentGroup.add(column);
            }
            if (col < operators.length && !operators[col].isBlank()) {
                boolean isAddition = input.getLast()[col].equals("+");
                total += calculateGroup(currentGroup, isAddition);
                currentGroup.clear();
            }
        }
        return total;
    }

    private String extractColumn(List<String[]> rows, int col) {
        return rows.stream()
                .map(row -> row[col])
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining());
    }

    private long calculateGroup(List<String> group, boolean addition) {
        long total = addition ? 0 : 1;
        for (String value : group) {
            if (addition) {
                total += Long.parseLong(value);
            } else {
                total *= Long.parseLong(value);
            }
        }
        return total;
    }

    private String[] formatPart2(String row) {
        return row.split("");
    }

    private String[] formatPart1(String row) {
        return row.trim().split("\\s+");
    }
}