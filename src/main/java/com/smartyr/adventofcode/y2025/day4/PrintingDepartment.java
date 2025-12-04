package com.smartyr.adventofcode.y2025.day4;


public interface PrintingDepartment extends Input {
    static int processPartOne() {
        return process(ROLLS_OF_PAPER);
    }

    static int process(char[][] input) {
        int totalLength = input.length;
        int total = 0;
        for (int i = 0; i < totalLength; i++) {
            total += process(input[i], input, i);
        }
        return total;
    }

    static int process(char[] input, char[][] collection, int row) {
        int counter = 0;
        for (int i = 0; i < input.length; i++) {
            int surrounding = 0;
            if (input[i] == '.') {
                continue;
            }
            surrounding += processRange(input, i) - 1;
            if (row > 0) {
                //process top
                surrounding += processRange(collection[row - 1], i);
            }
            if (surrounding < 4 && row < collection.length - 1) {
                //process bottom
                surrounding += processRange(collection[row + 1], i);
            }
            if (surrounding < 4) {
                counter++;
            }
        }
        return counter;
    }

    static int processRange(char[] row, int location) {
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