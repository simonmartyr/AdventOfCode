package com.smartyr.adventofcode.y2025.day2;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {
    static final List<String> EXAMPLE_INPUT = List.of(
            "11-22",
            "95-115",
            "998-1012",
            "1188511880-1188511890",
            "222220-222224",
            "1698522-1698528",
            "446443-446449",
            "38593856-38593862",
            "565653-565659",
            "824824821-824824827",
            "2121212118-2121212124"
    );

    static final long wrongRes = 8989806846L;

    final Day2 day2 = new Day2();

    @Nested
    class Part1 {
        @Test
        void testExampleInput() {
            assertThat(day2.calculateInvalidIds(EXAMPLE_INPUT)).isEqualTo(1227775554);
        }

        @Test
        void realInput() {
            long start = System.nanoTime();
            long res = day2.calculateInvalidIds();
            System.out.println(Duration.ofNanos(System.nanoTime() - start));
            assertThat(res).isEqualTo(18952700150L);
        }
    }

    @Nested
    class Part2 {
        @Test
        void testExampleInput() {
            assertThat(day2.calculateInvalidIdsRepeating(EXAMPLE_INPUT)).isEqualTo(4174379265L);
        }

        @Test
        void validateEachSet() {
            assertThat(day2.calculateInvalidIdsRepeating(List.of("2121212118-2121212124")))
                    .isEqualTo(2121212121);
        }

        @Test
        void realInput() {
            long start = System.nanoTime();
            long res = day2.calculateInvalidIdsRepeating();
            System.out.println(Duration.ofNanos(System.nanoTime() - start));
            assertThat(res).isEqualTo(28858486244L);
        }
    }
}