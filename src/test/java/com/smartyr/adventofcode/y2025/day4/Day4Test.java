package com.smartyr.adventofcode.y2025.day4;

import java.time.Duration;

import org.junit.jupiter.api.Nested;
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

    @Nested
    class Part1 {
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

    @Nested
    class Part2 {
        @Test
        void part2TestInput() {
            assertThat(PrintingDepartment.processRemoval(testInput)).isEqualTo(43);
        }

        @Test
        void part2() {
            long start = System.nanoTime();
            int res = PrintingDepartment.processPartTwo();
            //PT0.014721917S
            System.out.println(Duration.ofNanos(System.nanoTime() - start));
            assertThat(res).isEqualTo(9038);
        }
    }
}