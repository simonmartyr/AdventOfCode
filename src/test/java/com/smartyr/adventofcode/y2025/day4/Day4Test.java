package com.smartyr.adventofcode.y2025.day4;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {
    char[][] testInput = new char[][]{
            {'.', '.', '@', '@', '.', '@', '@', '@', '@', '.'},
            {'@', '@', '@', '.', '@', '.', '@', '.', '@', '@'},
            {'@', '@', '@', '@', '@', '.', '@', '.', '@', '@'},
            {'@', '.', '@', '@', '@', '@', '.', '.', '@', '.'},
            {'@', '@', '.', '@', '@', '@', '@', '.', '@', '@'},
            {'.', '@', '@', '@', '@', '@', '@', '@', '.', '@'},
            {'.', '@', '.', '@', '.', '@', '.', '@', '@', '@'},
            {'@', '.', '@', '@', '@', '.', '@', '@', '@', '@'},
            {'.', '@', '@', '@', '@', '@', '@', '@', '@', '.'},
            {'@', '.', '@', '.', '@', '@', '@', '.', '@', '.'},
    };

    @Test
    void part1TestInput() {
        assertThat(PrintingDepartment.process(testInput)).isEqualTo(13);
    }

    @Test
    void part1() {
        long start = System.nanoTime();
        //PT0.001979833S
        int res = PrintingDepartment.processPartOne();
        System.out.println(Duration.ofNanos(System.nanoTime() - start));
        assertThat(res).isEqualTo(1543);
    }
}