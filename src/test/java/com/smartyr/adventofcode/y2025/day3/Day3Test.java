package com.smartyr.adventofcode.y2025.day3;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {
    static final String[] TEST_BANKS = {
            "987654321111111",
            "811111111111119",
            "234234234234278",
            "818181911112111"
    };
    final Day3 day3 = new Day3();

    @Test
    void partOneWithTestData() {
        assertThat(day3.processBanks(TEST_BANKS)).isEqualTo(357);
    }

    @Test
    void partOne() {
        long start = System.nanoTime();
        long res = day3.partOne();
        //PT0.00252475S
        System.out.println(Duration.ofNanos(System.nanoTime() - start));
        assertThat(res).isEqualTo(17074);
    }
}