package com.smartyr.adventofcode.y2025.day5;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.smartyr.adventofcode.y2025.day5.Input.INGREDIENTS;
import static org.assertj.core.api.Assertions.assertThat;

class Day5Test {
    static final String[] EXAMPLE = new String[]{
            "3-5",
            "10-14",
            "16-20",
            "12-18",
    };

    static final int[] TO_EVALUATE = {
            1, 5, 8, 11, 17, 32,
    };

    @Nested
    class PartTwo {
        @Test
        void test_part2() {
            List<IngredientRange> reduced = Cafeteria.freshRanges(EXAMPLE);
            long res = reduced.stream().map(IngredientRange::difference).reduce(0L, Long::sum);
            assertThat(res).isEqualTo(14L);
        }

        @Test
        void test_part2_real() {
            long start = System.nanoTime();
            List<IngredientRange> reduced = Cafeteria.freshRanges();
            long res = reduced.stream().map(IngredientRange::difference).reduce(0L, Long::sum);
            //PT0.001934208S
            System.out.println(Duration.ofNanos(System.nanoTime() - start));
            assertThat(res).isEqualTo(353863745078671L);
        }
    }

    @Nested
    class PartOne {
        @Test
        void combinedRanges() {
            assertThat(Cafeteria.freshRanges(EXAMPLE))
                    .hasSize(2);
        }

        @Test
        void test_part1() {
            List<IngredientRange> reduced = Cafeteria.freshRanges(EXAMPLE);
            assertThat(Arrays.stream(TO_EVALUATE)
                    .filter(value -> reduced.stream().anyMatch(x -> x.withinRange(value)))
                    .count())
                    .isEqualTo(3);
        }

        @Test
        void real_part1() {
            long start = System.nanoTime();
            List<IngredientRange> reduced = Cafeteria.freshRanges();
            long result = Arrays.stream(INGREDIENTS)
                    .filter(value -> reduced.stream().anyMatch(x -> x.withinRange(value)))
                    .count();
            //PT0.005244875S
            System.out.println(Duration.ofNanos(System.nanoTime() - start));
            assertThat(result)
                    .isEqualTo(782);
        }

    }
}