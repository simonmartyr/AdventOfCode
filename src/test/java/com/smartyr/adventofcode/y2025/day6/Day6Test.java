package com.smartyr.adventofcode.y2025.day6;

import java.time.Duration;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day6Test {
    final Day6 day6 = new Day6();

    @Nested
    class Part1 {
        @Test
        void test_input_part1() {
            assertThat(day6.solvePart1(day6.readExamplePart1())).isEqualTo(4277556);
        }

        @Test
        void part1() {
            long start = System.nanoTime();
            long res = day6.solvePart1();
            //PT0.008393417S
            System.out.println(Duration.ofNanos(System.nanoTime() - start));
            assertThat(res).isEqualTo(4412382293768L);
        }
    }

    @Nested
    class Part2 {
        @Test
        void test_input_part2() {
            assertThat(day6.solvePart2(day6.readExamplePart2())).isEqualTo(3263827);
        }

        @Test
        void test_input_part2_real() {
            long start = System.nanoTime();
            long res = day6.solvePart2();
            //PT0.0139415S
            System.out.println(Duration.ofNanos(System.nanoTime() - start));
            assertThat(res).isEqualTo(7858808482092L);
        }
    }

}