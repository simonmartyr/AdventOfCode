package com.smartyr.adventofcode.y2025.day4;


import java.util.Arrays;

public interface PrintingDepartment extends Input {
    static int processPartOne() {
        return process(ROLLS_OF_PAPER);
    }

    static int processPartTwo() {
        return processRemoval(ROLLS_OF_PAPER);
    }

    static int process(char[][] input) {
        int totalLength = input.length;
        int total = 0;
        for (int i = 0; i < totalLength; i++) {
            total += process(input[i], input, i);
        }
        return total;
    }

    static int processRemoval(char[][] input) {
        int totalLength = input.length;
        int total = 0;
        int eachRun;
        char[][] copy;
        do {
            eachRun = 0;
            copy = new char[totalLength][input[0].length];
            for (int i = 0; i < totalLength; i++) {
                Processed res = processRemove(input[i], input, i);
                copy[i] = res.processed();
                total += res.count();
                eachRun += res.count();
            }
            input = Arrays.copyOf(copy, copy.length);
        } while (eachRun > 0);
        return total;
    }

    static int process(char[] input, char[][] collection, int row) {
        int counter = 0;
        for (int i = 0; i < input.length; i++) {
            int surrounding = 0;
            if (input[i] == '.') {
                continue;
            }
            surrounding = countSurrounding(input, collection, row, i, surrounding);
            if (surrounding < 4) {
                counter++;
            }
        }
        return counter;
    }

    static Processed processRemove(char[] input, char[][] collection, int row) {
        int counter = 0;
        char[] result = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            int surrounding = 0;
            if (input[i] == '.') {
                result[i] = input[i];
                continue;
            }
            surrounding = countSurrounding(input, collection, row, i, surrounding);
            if (surrounding < 4) {
                counter++;
                result[i] = '.';
            } else {
                result[i] = input[i];
            }
        }
        return new Processed(counter, result);
    }

    private static int countSurrounding(char[] input, char[][] collection, int row, int i, int surrounding) {
        surrounding += processRange(input, i) - 1;
        if (row > 0) {
            //process top
            surrounding += processRange(collection[row - 1], i);
        }
        if (surrounding < 4 && row < collection.length - 1) {
            //process bottom
            surrounding += processRange(collection[row + 1], i);
        }
        return surrounding;
    }

    private static int processRange(char[] row, int location) {
        int x = location == 0 ? 0 : location - 1;
        int y = location == row.length - 1 ? location : location + 1;
        int count = 0;
        for (; x <= y; x++) {
            if (row[x] == '@') {
                count++;
            }
        }
        return count;
    }
}