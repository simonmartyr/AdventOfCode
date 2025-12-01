package com.smartyr.adventofcode.y2025;

import java.util.List;

import com.smartyr.adventofcode.y2025.day1.Day1;
import com.smartyr.adventofcode.y2025.day1.Safe;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {
    static final Day1 day1 = new Day1();
    public static List<String> testSet = List.of(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82");

    @Nested
    class Part1 {
        @Test
        void solve() {
            assertThat(day1.invokeSet(new Safe(), testSet)).isEqualTo(3);
        }

        @Test
        void solvePart1() {
            Safe res = day1.invokePart1();
            assertThat(res.getMoveTotal()).isEqualTo(4126);
            assertThat(res.getTotal()).isEqualTo(1029);
        }
    }

    @Nested
    class Part2 {
        @Test
        void solve() {
            assertThat(day1.invokeSet(new Safe(true), testSet)).isEqualTo(6);
        }

        @Test
        void solve2() {
            final List<String> s = List.of(
                    "L68", //1
                    "L30",
                    "R48", //2
                    "L5",
                    "R60", //3
                    "L55", //4
                    "L1",
                    "L99",
                    "R14",
                    "L82",
                    "L32",
                    "R50",
                    "R50"
            );
            assertThat(day1.invokeSet(new Safe(true), s)).isEqualTo(8);
        }

        @Test
        void verifyExample() {
            final List<String> input = List.of("R1000");
            assertThat(day1.invokeSet(new Safe(true), input)).isEqualTo(10);
        }

        @Test
        void verifyExample2() {
            List<String> input = List.of("R1050");
            assertThat(day1.invokeSet(new Safe(true), input)).isEqualTo(11);
        }

        @Test
        void solvePart1() {
            Safe res = day1.invokePart2();
            assertThat(res.getMoveTotal()).isEqualTo(4126);
            assertThat(res.getTotal()).isEqualTo(5892);
        }
    }
}