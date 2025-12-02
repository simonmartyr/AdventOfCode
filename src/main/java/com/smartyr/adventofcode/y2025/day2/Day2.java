package com.smartyr.adventofcode.y2025.day2;

import java.util.List;

import static com.smartyr.adventofcode.y2025.day2.Input.PUZZLE_INPUT;

public class Day2 {

    public long calculateInvalidIds() {
        return calculateInvalidIds(PUZZLE_INPUT);
    }

    public long calculateInvalidIds(List<String> input) {
        return input.stream()
                .map(Input::parseRange)
                .map(range -> range.filter(Input::isInvalid)
                        .reduce(0, Long::sum)
                ).reduce(0L, Long::sum);
    }
}